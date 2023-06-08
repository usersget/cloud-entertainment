package com.cyt.controller;

import com.cyt.service.AnnService;
import org.cyt.common.Result;
import org.cyt.entity.Announcement.html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AnnController
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2023/1/1 13:57
 * @Version v2.0.1
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/annor")
public class AnnController {
    @Autowired
    private AnnService annService;


    @RequestMapping(method = RequestMethod.POST)
    public Result UpdataAnno(@RequestBody html html){
        return annService.Puthtml(html);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Result getAnno(){
        return annService.gethtml();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getAnno(@PathVariable Integer id){
        return annService.gethtml(id);
    }
    @RequestMapping(value = "/s",method = RequestMethod.GET)
    public Result getAnnos(){
        return annService.gethtmls();
    }
}
