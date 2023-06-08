package org.cyt.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/14 17:46
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String username;
    private String password;
    private String email;
    private String userid;
    private String registration;
    private String city;
    private Integer usid;
}
