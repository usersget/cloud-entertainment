package org.cyt.entity.Music;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Type
 * @Description 类型实体类
 * @Author CYT
 * @LastChangeDate 2022/12/26 19:59
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    /**
     * 类型名称
     */
    private String Type;
    /**
     * 类型ID
     */
    private Integer Typeid;
    /**
     * 类型图片
     */
    private String TypeImg;
    /**
     * 类型描述
     */
    private String TypeDescription;
}
