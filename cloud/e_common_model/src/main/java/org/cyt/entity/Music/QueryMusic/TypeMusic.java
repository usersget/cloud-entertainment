package org.cyt.entity.Music.QueryMusic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cyt.entity.Music.Type;

/**
 * @ClassName TypeMusic
 * @Description 音乐类型返回实体类
 * @Author CYT
 * @LastChangeDate 2022/12/28 15:47
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeMusic {
    /**
     * 音乐类型
     */
    private Type type;
    /**
     * 音乐名称
     */
    private String MusicName;
    /**
     * 音乐图片
     */
    private String MusicImg;
    /**
     * 音乐ID
     */
    private Integer MusicId;

}
