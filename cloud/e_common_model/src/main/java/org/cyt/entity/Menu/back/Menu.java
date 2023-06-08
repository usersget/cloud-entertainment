package org.cyt.entity.Menu.back;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @ClassName Menu
 * @Description 菜单数据总返回格式
 * @Author CYT
 * @LastChangeDate 2022/12/18 21:29
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String path;
    private String name;
    private String redirect;
    private Object  meta;
    private ArrayList children;
}
