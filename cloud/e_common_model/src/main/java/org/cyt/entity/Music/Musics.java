package org.cyt.entity.Music;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Musics
 * @Description 音乐实体类
 * @Author CYT
 * @LastChangeDate 2022/12/28 15:33
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Musics {
    /**
     * 音乐ID
     */
    private Integer musicId;
    /**
     * 音乐名称
     */
    private String MusicName;
    /**
     * 音乐地址
     */
    private String MusicUrl;
    /**
     * 音乐图片
     */
    private String musicImg;
    /**
     * 音乐描述
     */
    private String MusicDescription;
    /**
     * 歌手ID
     */
    private Integer MusicSingerid;
    /**
     * 类型ID
     */
    private Integer musicTypeid;
}
