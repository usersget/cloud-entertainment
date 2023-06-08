package org.cyt.common;



import lombok.Data;
import org.cyt.entity.CodeTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CaptchaConfig
 * @Description 验证码配置类
 * @Author CYT
 * @LastChangeDate 2022/11/22 19:46
 * @Version v2.0.1
 */
@Data
@ConfigurationProperties(prefix = "easycaptcha")
@Configuration
public class EasyCaptchaConfig {
    /**
     * 验证码配置
     */
    private CodeTypeEnum codeType;
    /**
     * 验证码内容长度
     */
    private int length = 4;
    /**
     * 验证码宽度
     */
    private int width = 111;
    /**
     * 验证码高度
     */
    private int height = 36;
    /**
     * 验证码字体
     */
    private String fontName;
    /**
     * 字体大小
     */
    private int fontSize = 25;
}
