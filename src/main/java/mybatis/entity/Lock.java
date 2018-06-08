package mybatis.entity;

/**
 * Created by shengchao wu on 6/8/2018.
 */
public class Lock {
    private Integer id;

    private String name;

    private Key key;

    public Lock() {
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

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", key=" + key +
                '}';
    }
}
