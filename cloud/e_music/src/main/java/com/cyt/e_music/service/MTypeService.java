package com.cyt.e_music.service;

import org.cyt.common.Result;
import org.cyt.entity.Music.QueryMusic.GetMusic;
import org.cyt.entity.Music.Type;

import java.util.List;

/**
 * @InterfaceName MTypeService
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/27 14:08
 * @Version v2.0.1
 */
public interface MTypeService {
    Result getMTypes();
    Result getMType(Integer id);
    Result getMtype(GetMusic music);
}
