package com.cyt.e_music.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.cyt.entity.Music.Type;

import java.util.List;

/**
 * @InterfaceName MType
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/26 20:29
 * @Version v2.0.1
 */
@Mapper
public interface MType {
    List<Type> selectAll();
    Type selectone(Integer Typeid);
}
