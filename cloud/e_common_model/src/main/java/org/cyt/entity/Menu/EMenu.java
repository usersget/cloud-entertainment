package org.cyt.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName EMenu
 * @Description e_menu实体类
 * @Author CYT
 * @LastChangeDate 2022/12/20 13:50
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMenu {
    private String path;
    private String name;
    private String redirect;
    private Integer haschild;
    private Integer ischild;
    private Integer metaid;
    private Integer menuId;
    private Integer permissions;

}
