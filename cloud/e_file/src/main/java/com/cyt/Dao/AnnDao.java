package com.cyt.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.cyt.entity.Announcement.html;

import java.util.List;

/**
 * @InterfaceName AnnDao
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/31 19:23
 * @Version v2.0.1
 */
@Mapper
public interface AnnDao {
    Integer InsetHtml(html anno);
    html getHtml();
    html getHtml(Integer id);
    List<html> SelectAll();
}
