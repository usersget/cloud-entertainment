package com.cyt.e_music.controller;

import com.cyt.e_music.service.GetTypeService;
import com.cyt.e_music.service.MTypeService;
import org.cyt.common.Result;
import org.cyt.entity.Music.QueryMusic.GetMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName TypeController
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/27 17:04
 * @Version v2.0.1
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/music")
public class TypeController {
    @Autowired
    private MTypeService mTypeService;
    @Autowired
    private GetTypeService getTypeService;

    @RequestMapping(value = "/musictype",method = RequestMethod.GET)
    public Result getTypes(){
        return getTypeService.getType();
    }


    @RequestMapping(value = "/musictype/{id}",method = RequestMethod.GET)
    public Result getType( @PathVariable Integer id){
        return mTypeService.getMType(id);
    }

    @RequestMapping(value = "/musicsinger",method = RequestMethod.GET)
    public Result getSinger(){
        return getTypeService.getSinger();
    }

    @RequestMapping(value = "/musicTypeList",method = RequestMethod.POST)
    public Result getMuTyList(@RequestBody GetMusic music){
        return mTypeService.getMtype(music);
    }
}

