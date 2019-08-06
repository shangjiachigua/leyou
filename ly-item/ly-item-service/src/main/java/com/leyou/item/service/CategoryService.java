package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.myexception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wen.tian.it.pojo.Category;

import java.util.List;

/**
 * @author tianwenwen
 * @date 2019/8/6 9:59
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> selectCategoryById(Long pId){
        Category category = new Category();
        category.setParentId(pId);
       List<Category> categories =  categoryMapper.select(category);
       if (CollectionUtils.isEmpty(categories)){
            throw new  LyException(ExceptionEnums.CATEGROY_NOT_FIND);
       }
        return categories;
    }
}
