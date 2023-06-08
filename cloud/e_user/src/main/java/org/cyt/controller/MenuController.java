package org.cyt.controller;

import org.cyt.common.Result;
import org.cyt.entity.Menu.EMenu;
import org.cyt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MenuController
 * @Description 菜单
 * @Author CYT
 * @LastChangeDate 2022/12/20 15:25
 * @Version v2.0.1
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu/{parmid}",method = RequestMethod.GET)
    public Result getMenu(@PathVariable Integer parmid){
        EMenu eMenu = new EMenu();
        eMenu.setPermissions(parmid);
        return menuService.getMenu(eMenu);
    }
}
