package com.ygg.debt.admin.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdWorker {

    protected static final Logger LOG = LoggerFactory.getLogger(IdWorker.class);

    private long workerId;
    private long sequence = 0L;

    private long twepoch = 1288834974657L;

    private long workerIdBits = 10L;
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long timestampLeftShift = sequenceBits + workerIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;
    private static IdWorker instance;

    public IdWorker(long workerId) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
        LOG.info(String.format(
                "worker starting. timestamp left shift %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, workerIdBits, sequenceBits, workerId));
    }

    public static synchronized IdWorker getInstance() {
        if (instance == null) {
            instance = new IdWorker(0L);
        }
        return instance;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main(String[] arfs) {
        while (true)
            System.out.println(getInstance().nextId());
    }
}