package com.cyt.e_music.service.Impl;

import com.cyt.e_music.Dao.MType;
import com.cyt.e_music.Dao.MusicDao;
import com.cyt.e_music.service.GetTypeService;
import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.entity.Music.Type;
import org.cyt.entity.Singer.SingerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GetTypeImpl
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/29 12:19
 * @Version v2.0.1
 */
@Service
public class GetTypeImpl implements GetTypeService {
    @Autowired
    private MType mType;
    @Autowired
    private MusicDao musicDao;

    /**
     * 获取分类
     * @return
     */
    @Override
    public Result getType() {
        List<Type> types = mType.selectAll();
        if (types.isEmpty()){
            return new Result(ResultCode.SERVER_ERROR);
        }{
            return new Result(ResultCode.SUCCESS,types);
        }

    }

    /**
     * 获取歌手
     * @return
     */
    @Override
    public Result getSinger() {
        List<SingerType> singerTypes = musicDao.SelectAller();
        if (singerTypes.isEmpty()) {
            return new Result(ResultCode.SERVER_ERROR);
        }else {
            return new Result(ResultCode.SUCCESS,singerTypes);
        }
    }
}
