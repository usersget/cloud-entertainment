package com.cyt.service.Impl;

import com.cyt.Dao.AnnDao;
import com.cyt.service.AnnService;
import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.entity.Announcement.html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AnnServiceImpl
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/31 19:30
 * @Version v2.0.1
 */
@Service
public class AnnServiceImpl implements AnnService {

    @Autowired
    private AnnDao annDao;
    @Override
    public Result gethtml() {
        html html = annDao.getHtml();
        return new Result(ResultCode.SUCCESS,html);
    }

    @Override
    public Result gethtmls() {
        List<html> htmls = annDao.SelectAll();

        return new Result(ResultCode.SUCCESS,htmls);
    }

    @Override
    public Result gethtml(Integer id) {
        html html = annDao.getHtml(id);
        return new Result(ResultCode.SUCCESS,html);
    }

    @Override
    public Result Puthtml(html html) {
        Integer integer = annDao.InsetHtml(html);
        return new Result(ResultCode.SUCCESS,integer);
    }
}
