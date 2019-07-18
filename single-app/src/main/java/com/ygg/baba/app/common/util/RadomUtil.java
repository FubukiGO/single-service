package com.ygg.baba.app.common.util;

public class RadomUtil {


    /**
     * 生成6位数的随机数
     *
     * @param
     * @return int
     * @throws
     * @Title: getnumber
     * @description
     */
    public static int getnumber() {

        int randNum = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));

        return randNum;
    }


    /**
     * 生成4位数的随机数
     *
     * @param
     * @return int
     * @throws
     * @Title: getnumber
     * @description
     */
    public static int getfournumber() {

        int randNum = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));

        return randNum;
    }


}
