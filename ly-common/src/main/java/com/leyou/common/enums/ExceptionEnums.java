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
    BRAND_NOT_FIND(404,"品牌不存在"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    FILE_TYPE_ERROR(400,"图片类型错误")
    ;
    private int code;
    private String msg;
}
