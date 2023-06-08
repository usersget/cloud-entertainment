package com.cyt.e_music.Dao;

import org.cyt.entity.Music.Musics;
import org.cyt.entity.Music.QueryMusic.GetMusic;
import org.cyt.entity.Music.QueryMusic.TypeMusic;
import org.cyt.entity.Music.Type;
import org.cyt.entity.Singer.SingerType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MusicTest
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/28 16:29
 * @Version v2.0.1
 */
@SpringBootTest
public class MusicTest {

    @Autowired
    private MusicDao musicDao;
    @Autowired
    private MType mType;

    @Test
    public void getMucic(){
//        for (Musics musics : musicDao.SelectAll()) {
//            System.out.println("Music:"+musics);
//            Type selectone = mType.selectone(musics.getMusicTypeid());
//            System.out.println(selectone);
//        }
        Musics musics1 = new Musics();
        musics1.setMusicId(1);
        Musics musics = musicDao.SelectOne(musics1);
        System.out.println(musics);

    }
    @Test
    public void getSingerType(){
        for (SingerType singerType : musicDao.SelectAller()) {
            System.out.println(singerType);
        }
    }

    @Test
    public void getMuTyList(){
        GetMusic getMusic = new GetMusic();
        getMusic.setPageIndex(0);
        getMusic.setPageSize(7);
        ArrayList<TypeMusic> typeMusics = new ArrayList<>();
        for (Musics musics : musicDao.SelectofTyid(getMusic)) {
            TypeMusic typeMusic = new TypeMusic();
            Type selectone = mType.selectone(musics.getMusicTypeid());
            typeMusic.setMusicName(musics.getMusicName());
            typeMusic.setType(selectone);
            typeMusic.setMusicId(musics.getMusicId());
            typeMusic.setMusicImg(musics.getMusicImg());
            typeMusics.add(typeMusic);
        }
        for (int i = 0; i < typeMusics.size(); i++) {
            System.out.println(typeMusics.get(i));
        }
    }
}
