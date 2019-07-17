package com.ygg.debt.common.util.freemarker;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class ItextUtils {

    /**
     * @param fileName
     * @param response
     * @param htmlString
     * @Author: akhan
     * @Description: 创建pdf文档并输出流
     * @Date: 15:26 2019-03-22
     */
    public static void buildPdfDocument(String fileName, HttpServletResponse response, String htmlString) throws IOException {
        response.reset();
        response.setContentType("application/pdf; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".pdf", "UTF-8"));

        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ServletOutputStream out = response.getOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlString.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        baos.writeTo(out);
        out.flush();
        out.close();
    }

    public static void buildPdfDocument(String filePath, String fileName, String htmlString) throws IOException {
//        response.reset();
//        response.setContentType("application/pdf; charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".pdf", "UTF-8"));
        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        FileOutputStream baos = new FileOutputStream(filePath + "\\" + fileName);
//        ServletOutputStream out = response.getOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlString.getBytes()), Charset.forName("UTF-8"), new AsianFontProvider());
            ;
            baos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
            baos.close();
        }
//        baos.writeTo(out);
//        out.flush();
//        out.close();
    }
}
