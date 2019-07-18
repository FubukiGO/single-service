package com.ygg.baba.app.common.util;

import com.ygg.baba.common.util.MsgIdUtil;
import com.ygg.baba.common.util.freemarker.FreemarkerUtils;
import com.ygg.baba.common.util.freemarker.ItextUtils;

import java.io.*;
import java.util.Map;

public class CreateEvidenceUtile {
    static String FILE_PATH = "." + File.separator;
    static String TEMPLATE_URL = File.separator + "templates";
    static String TEMPLATE_NAME = "protocol.ftl";

    public static File create(Map<String, String> params) throws IOException {

        String fileName = MsgIdUtil.generateMsgId() + ".pdf";
        ItextUtils.buildPdfDocument(FILE_PATH, fileName, FreemarkerUtils.loadFtlHtml(TEMPLATE_URL, TEMPLATE_NAME, params));
        File file = new File(FILE_PATH + File.separator + fileName);
        return file;
    }

    public static byte[] getBytes(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
