package com.xtl.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author 31925
 * 给容器中加入我们自己定义的ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    /**
     * 返回值的map就是页面和json能获取的所有字段
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company","xtl.com");
        return map;
    }
}
