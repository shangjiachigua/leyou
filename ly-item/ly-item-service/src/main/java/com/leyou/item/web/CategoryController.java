package com.leyou.item.web;

import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;
import wen.tian.it.pojo.Category;

import java.util.List;

/**
 * @author tianwenwen
 * @date 2019/8/6 9:59
 **/
@RestController
/*api/item/category/list api是配置的路由前缀，item是路由匹配规则*/
@RequestMapping("category")
@MapperScan("com.leyou.item.mapper")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> FindCategoryList(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(categoryService.selectCategoryById(pid));
    }
}
