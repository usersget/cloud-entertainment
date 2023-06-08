package org.cyt.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName R
 * @Description 通用返回结果类
 * @Author CYT
 * @LastChangeDate 2022/12/14 16:20
 * @Version v2.0.1
 */
@Data
@AllArgsConstructor
public class R {
    private boolean success;//是否成功
    private Integer code;// 返回码
    private String message;//返回信息
    private Object data;// 返回数据
    private Map<String,Object> map;
}
