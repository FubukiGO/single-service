package com.ygg.wx.admin.common.util;

/**
 * @author akhan
 * @description twitter snowflake
 * @date 下午4:43 2018/9/10
 */
public class IdWorker {
    /**
     * 0bit符号 41bit时间戳 10bit机器id 12bit序列号
     */
    private static volatile IdWorker instance;
    private long workId;
    private long datacenterId;
    private long sequence = 0L;

    public static IdWorker getInstance() {
        if (instance == null) {
            synchronized (IdWorker.class) {
                if (instance == null) {
                    instance = new IdWorker(1L, 1L, 1L);
                }
            }
        }

        return instance;
    }

    public IdWorker(long workId, long datacenterId, long sequence) {
        // sanity check for workerId
        if (workId > maxWorkerId || workId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }

        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }


        this.workId = workId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    private IdWorker() {
    }

    private long twepoch = 1536569202000L;

    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    private long maxWorkerId = ~(-1L << workerIdBits);
    private long maxDatacenterId = ~(-1L << datacenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    /**
     * 取seq的最大值 防止seq递增导致溢出
     */
    private long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;

    public long getWorkId() {
        return this.workId;
    }

    public long getDatacenterId() {
        return this.datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        long seqBit = 5L;

        long seqLimit = ~(-1L << seqBit);

        System.out.println(Long.toBinaryString(-1L << 12));
        System.out.println(Long.toBinaryString(seqLimit));

        for (int i = 0; i < 1000; i++) {
            System.out.println(getInstance().nextId());
        }
    }
}
