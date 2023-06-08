package org.cyt.entity.Singer;

import lombok.Data;

/**
 * @ClassName Singer
 * @Description 数据库歌手实体类
 * @Author CYT
 * @LastChangeDate 2022/12/28 14:50
 * @Version v2.0.1
 */
@Data
public class Singer {
    private Integer SingerId;
    private String SingerName;
    private String SingerDescription;
    private String SingerImg;
    private String SingerSex;
    private String SingerBrithday;
    private String SingerBirthplace;
}
