package mybatis.dao;

import mybatis.entity.User;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public interface UserMapper {
    User getUserById(Integer id);

    void updateUser(User user);

}
