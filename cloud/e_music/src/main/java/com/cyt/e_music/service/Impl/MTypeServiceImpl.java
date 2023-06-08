package com.cyt.e_music.service.Impl;

import com.cyt.e_music.Dao.MType;
import com.cyt.e_music.Dao.MusicDao;
import com.cyt.e_music.service.MTypeService;
import org.cyt.common.Result;
import org.cyt.common.ResultCode;
import org.cyt.entity.Music.Musics;
import org.cyt.entity.Music.QueryMusic.GetMusic;
import org.cyt.entity.Music.QueryMusic.TypeMusic;
import org.cyt.entity.Music.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MTypeServiceImpl
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/27 14:09
 * @Version v2.0.1
 */
@Service
public class MTypeServiceImpl implements MTypeService {

    @Autowired
    private MType mType;

    @Autowired
    private MusicDao musicDao;
    /**
     * 获取所有类型
     * @return
     */
    @Override
    public Result getMTypes() {
        List<Type> types = mType.selectAll();
        if (types.isEmpty()) {
            return  new Result(ResultCode.TYPE_UNAUTHENTICATED,types);
        }else {
            return new Result(ResultCode.SUCCESS,types);
        }
    }

    /**
     * 获取具体类型
     * @param id
     * @return
     */
    @Override
    public Result getMType(Integer id) {
        Type selectone = mType.selectone(id);
        if (selectone==null){
           return new Result(ResultCode.TYPE_UNAUTHENTICATED,selectone  );
        }else {
            return new Result(ResultCode.SUCCESS,selectone);
        }
    }

    /**
     * 音乐类型列表获取
     * @param music
     * @return
     */
    @Override
    public Result getMtype(GetMusic music) {
        music.setPageIndex((music.getPageIndex()-1)*music.getPageSize());
        ArrayList<TypeMusic> typeMusics = new ArrayList<>();
        for (Musics musics : musicDao.SelectofTyid(music)) {
            TypeMusic typeMusic = new TypeMusic();
            Type selectone = mType.selectone(musics.getMusicTypeid());
            typeMusic.setMusicName(musics.getMusicName());
            typeMusic.setMusicId(musics.getMusicId());
            typeMusic.setMusicImg(musics.getMusicImg());
            typeMusic.setType(selectone);
            typeMusics.add(typeMusic);
        }
        if(typeMusics.isEmpty()){
            return new Result(1002,"抱歉暂未查到",false);
        }else {
            return new Result(ResultCode.SUCCESS,typeMusics);
        }
    }

}
