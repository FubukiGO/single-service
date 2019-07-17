package com.ygg.wx.admin.common.util.excel;

/**
 * 描述：Excel表格中的单元格例
 *
 * @author huangjianheng
 */
public class Cell {

    //单元格值
    private String cellValue;

    //跨列值
    private int colspan = 0;

    //跨行值
    private int rowspan = 0;

    /**
     * 描述：默认构造函数
     *
     * @param cellValue 单元格值
     */
    public Cell(String cellValue) {
        this.cellValue = cellValue;
    }

    /**
     * 描述：默认构造函数
     *
     * @param cellValue 单元格值
     * @param colspan   跨列单元格
     * @param rowspan   跨行单元格
     */
    public Cell(String cellValue, int colspan) {
        this.cellValue = cellValue;
        this.colspan = colspan;
    }

    /**
     * 描述：默认构造函数
     *
     * @param cellValue 单元格值
     * @param colspan   跨列单元格
     * @param rowspan   跨行单元格
     */
    public Cell(String cellValue, int colspan, int rowspan) {
        this.cellValue = cellValue;
        this.colspan = colspan;
        this.rowspan = rowspan;
    }

    /**
     * 描述：默认构造函数
     */
    public Cell() {

    }


    //get set methods
    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }


    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }


}