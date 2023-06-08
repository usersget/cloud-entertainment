package org.cyt.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Comment
 * @Description 评论实体类
 * @Author CYT
 * @LastChangeDate 2022/12/28 12:43
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer commentId;
    private String commentContent;
    private Integer commentSingerid;
    private Integer commentMusicid;
    private String commentUserid;

}
