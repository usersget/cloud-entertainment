package org.cyt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.cyt.entity.Menu.EMenu;
import org.cyt.entity.Menu.Mate;

import java.util.List;

/**
 * @ClassName UserMenu
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/20 13:40
 * @Version v2.0.1
 */
@Mapper
public interface UserMenu {

    Mate selectMate(Integer metaid);
    List<EMenu> selectMenu(EMenu eMenu);
}
