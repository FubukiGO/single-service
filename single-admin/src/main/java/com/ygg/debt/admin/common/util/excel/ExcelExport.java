package com.ygg.debt.admin.common.util.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * 描述：Excel导出实现类
 *
 * @author huangjianheng
 */
public class ExcelExport extends ReportExport implements IExport {


    /**
     * 描述：默认构造函数
     *
     * @param outputStream
     */
    public ExcelExport(OutputStream outputStream) {
        this.setOutputStream(outputStream);
    }


    /**
     * 描述：导出Excel报表
     *
     * @param sheetName
     * @param dataTable
     */
    public void exportData(String sheetName, DataTable dataTable) throws IOException {


        try {
            //1.构造EXCEL的对像
            XSSFWorkbook wb = null;
            XSSFSheet sheet = null;

            //2.构造工作本
            wb = new XSSFWorkbook();
            sheet = wb.createSheet(sheetName);

            //3.填充数据内容
            //this.createData(sheet,dataTable);
            this.createData(sheet, dataTable, wb);

            //4.输出到页面
            wb.write(this.getOutputStream());
        } finally {
            this.getOutputStream().close();
        }
    }

    //构造内容
    private void createData(XSSFSheet sheet, DataTable table, XSSFWorkbook wb) {

        //设置填充颜色
        CellStyle style = wb.createCellStyle();
        //style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        //设置边框
        style.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        style.setBorderTop(CellStyle.BORDER_THIN);//上边框
        style.setBorderRight(CellStyle.BORDER_THIN);//右边框

        //1.构造多行的列头
        //int currentRow=0;

        for (int i = 0; i < table.getTableTitle().size(); i++) {//行

            ArrayList<Cell> cellList = table.getTableTitle().get(i);
            //currentRow+=i;
            XSSFRow titleRow = sheet.createRow(i);

            for (int j = 0; j < cellList.size(); j++) {//每一列的内容

                Cell myCell = cellList.get(j);

                //设置单元格格式
                XSSFCell cell = titleRow.createCell(j, XSSFCell.CELL_TYPE_STRING);            //设置为文本格式
                cell.setCellValue(new XSSFRichTextString(myCell.getCellValue()));            //设置单元格值
                cell.setCellStyle(style);
                if (myCell.getColspan() > 0) {//跨列
                }

                if (myCell.getRowspan() > 0) {//跨行
                }
            }

        }

        //2.设置表格里面主体内容
        //currentRow++;
        for (int i = 0; i < table.getTableRow().size(); i++) {//行

            ArrayList<Cell> cellList = table.getTableRow().get(i);
            //currentRow+=i;
            XSSFRow addContentRow = sheet.createRow(table.getTableTitle().size() + i);

            for (int j = 0; j < cellList.size(); j++) {//每一列的内容

                Cell myCell = cellList.get(j);

                //设置单元格格式
                XSSFCell cell = addContentRow.createCell(j, XSSFCell.CELL_TYPE_STRING);            //设置为文本格式
                cell.setCellValue(new XSSFRichTextString(!myCell.getCellValue().equals("null") ? myCell.getCellValue() : ""));            //设置单元格值
                cell.setCellStyle(style);
                if (myCell.getColspan() > 0) {//跨列
                }

                if (myCell.getRowspan() > 0) {//跨行
                }
            }

        }

    }


}
