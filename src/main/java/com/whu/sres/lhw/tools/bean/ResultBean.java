package com.whu.sres.lhw.tools.bean;

import java.io.Serializable;

import lombok.Data;


/**
 * 返回对象包装类(带泛型)
 */
@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int FAIL = -1;

    public static final int SUCCESS = 0;

    private int code = SUCCESS;

    private String errorMsg;

    /**
     * 返回的数据
     */
    private T result;

    public ResultBean() {
        super();
    }

    public ResultBean(T result) {
        super();
        this.result = result;
    }

    public ResultBean(Throwable e) {
        super();
        this.code = FAIL;
        this.errorMsg = e.getMessage();
        this.result = null;
    }
}
