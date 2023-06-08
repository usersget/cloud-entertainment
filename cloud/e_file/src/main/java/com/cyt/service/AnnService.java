package com.cyt.service;

import org.cyt.common.Result;
import org.cyt.entity.Announcement.html;

/**
 * @InterfaceName AnnService
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2022/12/31 19:29
 * @Version v2.0.1
 */
public interface AnnService {
    Result gethtml();
    Result gethtmls();
    Result gethtml(Integer id);
    Result Puthtml(html html);
}
