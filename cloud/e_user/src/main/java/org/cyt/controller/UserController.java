package org.cyt.controller;

import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.entity.User.User;
import org.cyt.entity.User.Usercode;
import org.cyt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/15 14:00
 * @Version v2.0.1
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")
//    private String dateformat;

//    @RequestMapping(value = "/now", method = RequestMethod.GET)
//    public Result gettime(){
//        System.out.println(dateformat);
//        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
//        return new Result(ResultCode.SUCCESS,format);
////        return new Result(ResultCode.SUCCESS);
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result getUser(@RequestBody Usercode usercode){
        return userService.getUser(usercode);
    }
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public Result AddUser(@RequestBody User user){return userService.setUser(user);
    }

    @RequestMapping(value = "captage",method = RequestMethod.GET)
    public Map<String,String> getCapt(){
        return userService.getCapt();
    }
}
