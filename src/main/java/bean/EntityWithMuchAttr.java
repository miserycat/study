package bean;

/**
 * Created by shengchao wu on 7/27/2017.
 */
public class EntityWithMuchAttr {
    //required parameters
    private final String id;
    private final String name;
    //optional parameters
    private final String address;
    private final String lover;


    private EntityWithMuchAttr(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.lover = builder.lover;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLover() {
        return lover;
    }

    public static final class Builder {
        private  String id;
        private  String name;
        private  String address;
        private  String lover;

        public Builder(final String id, final String name) {
            this.id = id;
            this.name = name;
        }

        public Builder address(final String address) {
            this.address = address;
            return this;
        }
        public Builder lover(final String lover) {
            this.lover = lover;
            return this;
        }

        public EntityWithMuchAttr build() {
            return new EntityWithMuchAttr(this);
        }
    }

    @Override
    public String toString() {
        return "EntityWithMuchAttr{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lover='" + lover + '\'' +
                '}';
    }
}
