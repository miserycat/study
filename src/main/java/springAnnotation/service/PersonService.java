package springAnnotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springAnnotation.dao.PersonDao;

/**
 * Created by shengchao wu on 7/5/2018.
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;


    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
