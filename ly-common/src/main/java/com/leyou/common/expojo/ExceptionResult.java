package com.leyou.common.expojo;

import com.leyou.common.enums.ExceptionEnums;
import lombok.Data;

/**
 * @author tianwenwen
 * @date 2019/8/4 0:11
 **/
@Data
public class ExceptionResult {
    private String msg;
    private int status;
    private long longtime;

    public ExceptionResult(ExceptionEnums exceptionEnums) {
        this.longtime = System.currentTimeMillis();
        this.msg = exceptionEnums.getMsg();
        this.status = exceptionEnums.getCode();
    }
}
