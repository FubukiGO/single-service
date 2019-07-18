package com.ygg.baba.app.common.util.excel;

import java.util.ArrayList;


/**
 * 描述：导出的表结构
 *
 * @author tonglq
 */
public class DataTable {

    //表头列
    private ArrayList<ArrayList<Cell>> tableTitle;

    //行列
    private ArrayList<ArrayList<Cell>> tableRow;


    //get set methods

    public ArrayList<ArrayList<Cell>> getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(ArrayList<ArrayList<Cell>> tableTitle) {
        this.tableTitle = tableTitle;
    }

    public ArrayList<ArrayList<Cell>> getTableRow() {
        return tableRow;
    }

    public void setTableRow(ArrayList<ArrayList<Cell>> tableRow) {
        this.tableRow = tableRow;
    }


}