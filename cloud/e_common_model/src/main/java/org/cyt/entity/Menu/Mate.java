package org.cyt.entity.Menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Mate
 * @Description mate数据实体类
 * @Author CYT
 * @LastChangeDate 2022/12/18 21:47
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mate {
    private String title;
    private String icon;
    private Integer metaid;
}
