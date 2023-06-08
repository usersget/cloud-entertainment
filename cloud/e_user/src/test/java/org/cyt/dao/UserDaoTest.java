package org.cyt.dao;

import org.cyt.entity.User.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName UserDaoTest
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/14 20:48
 * @Version v2.0.1
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void SelestUser(){
        User user = new User();
        user.setUsername("1");
        User users = userDao.selectUser(user);
        System.out.println(users);
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("1");
        user.setUserid("1278978");
        user.setUsername("yut");
        Integer integer = userDao.insertUser(user);
        System.out.println(integer);
    }

}
