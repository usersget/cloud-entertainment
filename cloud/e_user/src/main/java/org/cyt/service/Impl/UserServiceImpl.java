package org.cyt.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.dao.UserDao;
import org.cyt.entity.Menu.EMenu;
import org.cyt.entity.User.User;
import org.cyt.entity.User.Usercode;
import org.cyt.service.UserService;
import org.cyt.utils.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.cyt.entity.CodeTypeEnum.ARITHMETIC;

/**
 * @ClassName UserServiceImpl
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/15 13:57
 * @Version v2.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EasyCaptchaService captchaService;

    /**
     * 登录
     * @param usercode
     * @return
     */
    @Override
    public Result getUser(Usercode usercode) {
        Integer integer = userDao.numberUser(usercode.getUser());
        usercode.getUser().setPassword(DigestUtils.md5DigestAsHex(usercode.getUser().getPassword().getBytes()));
        if (integer<=0){
            return new Result(1234,"该用户未注册",false);
        }else {
            User user1 = userDao.selectUser(usercode.getUser());
            if(usercode.getUser().getPassword().equals(user1.getPassword())){
                return new Result(ResultCode.SUCCESS,user1);
            }else {
                return new Result(1234,"用户名或密码错误",false);
            }
        }
    }
    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public Result setUser(User user) {
        Integer integer = userDao.numberUser(user);
        if (integer>0){
           return new Result(101,"该用户名已被占用",false);
        }else {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            user.setUsid(0);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            user.setRegistration(sdf.format(d));
            SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(1, 2);
            String s = snowflakeIdGenerator.nextId() + "";
            user.setUserid(s);
            Integer retUser = userDao.insertUser(user);
            if(retUser >0){
                return  new Result(10000,"用户添加成功,请登录 ",true);
            }else {
                return new Result(400,"发生未知错误，请稍后再试",false);
            }
        }

    }

    /**
     * 验证码
     * @return
     */
    @Override
    public Map<String, String> getCapt() {
        Map<String, String> capt = captchaService.getCaptchaValueAndBase64(ARITHMETIC);
        return capt;
    }

}
