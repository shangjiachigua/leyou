package wen.tian.it;

import java.util.Objects;

/**
 * @author tianwenwen
 * @date 2019/8/12 9:55
 **/
public class Key1 {
    private Integer id;
    private String string;

    public Key1(Integer id, String string) {
        this.id = id;
        this.string = string;
    }

    public Key1(Integer id) {
        this.id = id;
    }

    public Key1() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key1 key1 = (Key1) o;
        return Objects.equals(id, key1.id) &&
                Objects.equals(string, key1.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, string);
    }
}
