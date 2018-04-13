package collection;

/**
 * Created by shengchao wu on 3/30/2018.
 */
public class MyClass {

    public MyClass() {
    }

    public MyClass(String name) {
        this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        return !(name != null ? !name.equals(myClass.name) : myClass.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
