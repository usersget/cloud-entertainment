package org.cyt.service;

import org.cyt.common.Result;
import org.cyt.entity.Menu.EMenu;
import org.cyt.entity.User.User;
import org.cyt.entity.User.Usercode;

import java.util.Map;

/**
 * @InterfaceName UserService
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/14 23:07
 * @Version v2.0.1
 */
public interface UserService {
    Result getUser(Usercode usercode);
    Result setUser(User user);
    Map<String,String> getCapt();

}
