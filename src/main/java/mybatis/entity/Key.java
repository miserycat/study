package mybatis.entity;

/**
 * Created by shengchao wu on 6/8/2018.
 */
public class Key {
    private Integer id;

    private String name;

    public Key() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
