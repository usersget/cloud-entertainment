package org.cyt.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Usercode
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/18 14:19
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usercode {
    private User user;
    private String code;
}
