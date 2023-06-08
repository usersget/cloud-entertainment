package org.cyt.service;

import org.cyt.common.Result;
import org.cyt.entity.Menu.EMenu;

/**
 * @InterfaceName Menu
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/20 15:13
 * @Version v2.0.1
 */
public interface MenuService {
    Result getMenu(EMenu eMenu);
}
