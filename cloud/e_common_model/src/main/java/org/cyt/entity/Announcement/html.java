package org.cyt.entity.Announcement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName html
 * @Description 公告实体类
 * @Author CYT
 * @LastChangeDate 2022/12/31 19:21
 * @Version v2.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class html {
    private String announcement;
    private Integer announcementId;
    private Integer start;
}
