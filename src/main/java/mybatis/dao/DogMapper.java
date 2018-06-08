package mybatis.dao;

import mybatis.entity.Dog;

import java.util.List;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public interface DogMapper {

    void add(Dog dog);

    List<Dog> getDogsByConditions(Dog dog);

    List<Dog> getDogsLikedByName(Dog dog);


}
