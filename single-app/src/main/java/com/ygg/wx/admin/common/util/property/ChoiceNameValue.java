package com.ygg.wx.admin.common.util.property;

import java.io.Serializable;

/**
 * 列表的label/value保持类。
 *
 * @author 2015/02/01 yingcankeji
 */
public class ChoiceNameValue implements Comparable<ChoiceNameValue>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名
     */
    private String name = "";
    /**
     * 值
     */
    private String value = "";

    public ChoiceNameValue() {
    }

    public ChoiceNameValue(String name, String value) {
        this.setName(name);
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ChoiceNameValue value) {
        return this.value.compareTo(value.getValue());
    }

}
