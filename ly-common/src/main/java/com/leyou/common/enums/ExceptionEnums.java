package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author tianwenwen
 * @date 2019/8/4 0:00
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGROY_NOT_FIND(404,"商品分类没查到"),
    ;
    private int code;
    private String msg;
}
