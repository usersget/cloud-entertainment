package org.cyt.dao;


import org.apache.ibatis.annotations.Mapper;
import org.cyt.entity.User.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * @InterfaceName UserDao
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/14 20:34
 * @Version v2.0.1
 */
@Mapper
public interface UserDao {
   User selectUser(User user);
   Integer insertUser(User user);
   Integer numberUser(User user);
}
