package springAnnotation.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by shengchao wu on 7/5/2018.
 */
@Repository
public class PersonDao {

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "PersonDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
