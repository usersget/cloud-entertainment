package org.cyt.service.Impl;

import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.dao.UserMenu;
import org.cyt.entity.Menu.EMenu;
import org.cyt.entity.Menu.Mate;
import org.cyt.entity.Menu.back.Menu;
import org.cyt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @ClassName MenuServiceImpl
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/20 15:14
 * @Version v2.0.1
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private UserMenu userMenu;

    @Override
    public Result getMenu(EMenu eMenu) {
        ArrayList<Menu> menus = new ArrayList<>();
        int i = 0;
        for (EMenu selectMenu : userMenu.selectMenu(eMenu)) {
            Menu menu = new Menu();
            Mate mate = userMenu.selectMate(selectMenu.getMetaid());
            menu.setMeta(mate);
            if (selectMenu.getHaschild() ==0){
                menu.setPath(selectMenu.getPath());
                menu.setName(selectMenu.getName());
                menu.setRedirect(selectMenu.getRedirect());
            }else {
                eMenu.setIschild(selectMenu.getHaschild());
                ArrayList<Menu> menus1 = new ArrayList<>();
                int j=0;
                for (EMenu selectMenu1 : userMenu.selectMenu(eMenu)) {
                    Menu menu1 = new Menu();
                    Mate mate1 = userMenu.selectMate(selectMenu1.getMetaid());
                    menu1.setMeta(mate1);
                    menu1.setPath(selectMenu1.getPath());
                    menu1.setName(selectMenu1.getName());
                    menu1.setRedirect(selectMenu1.getRedirect());
                    menus1.add(j,menu1);
                    j++;
                }
                menu.setChildren(menus1);
            }

            menus.add(i,menu);
            i++;
        }
        if ( null==menus) {
           return new Result(ResultCode.SERVER_ERROR);
        }else {
            return new Result(ResultCode.SUCCESS,menus);
        }

    }
}
