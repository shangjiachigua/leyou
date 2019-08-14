package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wen.tian.it.pojo.Brand;

import java.util.List;

/**
 * @author tianwenwen
 * @date 2019/8/6 21:31
 **/
@RestController
@RequestMapping("brand")
/*http://api.leyou.com/api/item/brand/page?key=&page=1&rows=5&sortBy=id&desc=false*/
public class BrandController {
    @Autowired
    private BrandService brandService;
    /**
     *
     * 功能描述:品牌分类查询
     *
     * @Author wenwen
     * @Description //TODO
     * @Date 2019/8/6 22:16
     * @Param [key, rows, page, sortBy, desc]
     * @return org.springframework.http.ResponseEntity<com.leyou.common.vo.PageResult<wen.tian.it.pojo.Brand>>
     **/
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> selectBrand(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",defaultValue = "false") Boolean desc

    ){

        return ResponseEntity.ok(brandService.selectBrand(key,rows,page,sortBy,desc));
    }
    /**
     * 功能描述:品牌新增
     * @Author wenwen
     * @Description //TODO
     * @Date 2019/8/7 21:41
     * @Param [brand, cids]
     * @return org.springframework.http.ResponseEntity<java.lang.Void>
     **/
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,
                                          @RequestParam("cids") List<Long> cids){
        brandService.saveBrand(brand,cids);
        //如果有返回体使用.body,没有使用build
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
