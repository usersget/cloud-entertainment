package org.cyt.entity.Music.QueryMusic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName GetMusic
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/29 12:10
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMusic {
    /**
     * 分页页码
     */
    private Integer pageIndex;
    /**
     * 每页条目数
     */
    private Integer pageSize;
    /**
     * 歌手id
     */
    private Integer SingerId;
    /**
     * 类型ID
     */
    private Integer Typeid;
}
