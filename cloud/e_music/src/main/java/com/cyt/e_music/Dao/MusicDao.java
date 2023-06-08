package com.cyt.e_music.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.cyt.entity.Music.Musics;
import org.cyt.entity.Music.QueryMusic.GetMusic;
import org.cyt.entity.Singer.SingerType;

import java.util.List;

/**
 * @InterfaceName TypeMusicDao
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/28 16:00
 * @Version v2.0.1
 */
@Mapper
public interface MusicDao {
    List<Musics> SelectAll();
    Musics SelectOne(Musics musics);
    List<Musics> SelectofTyid(GetMusic getMusic);
    List<SingerType> SelectAller();
}
