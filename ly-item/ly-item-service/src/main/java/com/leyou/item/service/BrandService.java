package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.myexception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import wen.tian.it.pojo.Brand;

import java.util.List;

/**
 * @author tianwenwen
 * @date 2019/8/6 21:49
 **/
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 功能描述:品牌分页查询
     *
     * @return com.leyou.common.vo.PageResult<wen.tian.it.pojo.Brand>
     * @Author wenwen
     * @Description //TODO
     * @Date 2019/8/6 22:32
     * @Param [key, rows, page, sortBy, desc]
     **/
    public PageResult<Brand> selectBrand(String key, Integer rows,
                                         Integer page, String sortBy, Boolean desc) {
        //开始分页
        PageHelper.startPage(page, rows);
        Example example = new Example(Brand.class);
        //过滤
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + " " + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        List<Brand> list = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnums.BRAND_NOT_FIND);
        }
        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(list);
        return new PageResult<Brand>(info.getTotal(), info.getList());
    }
    //添加事务
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增品牌
        int insert = brandMapper.insert(brand);
        if (insert != 1) {
            throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
        }
        //新增中间表 分析：中间表没有实体类
        for (Long cid : cids) {
            int i = brandMapper.insertCategoryBrand(cid, brand.getId());
            if (i !=1){
                throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
            }
        }
    }
}
