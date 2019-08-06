package wen.tian.it.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tianwenwen
 * @date 2019/8/6 9:46
 **/
@Data
@Table(name = "tb_category")
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
