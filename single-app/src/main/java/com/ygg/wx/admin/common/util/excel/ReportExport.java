package com.ygg.wx.admin.common.util.excel;

import java.io.OutputStream;

/**
 * 描述：导出抽像类
 *
 * @author huangjianheng
 */
public class ReportExport implements IExport {

    //用于存放导出的流
    private OutputStream outputStream;

    //get set methods
    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }


}
