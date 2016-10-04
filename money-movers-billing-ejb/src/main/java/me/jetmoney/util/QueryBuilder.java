package me.jetmoney.util;

import me.jetmoney.request.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/**
 * Created by toroptsev on 05.10.16.
 */
public class QueryBuilder {

    private static Logger logger = LoggerFactory.getLogger(QueryBuilder.class);

    public static String getQueryString(Object o) {
        String queryString = "";
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Param.class)) {
                Param param = field.getAnnotation(Param.class);
                try {
                    field.setAccessible(true);
                    Object value = field.get(o);
                    if (value != null) {
                        String encodedValue = URLEncoder.encode(value.toString(), "UTF-8");
                        logger.info(param.value() + "=" + encodedValue);
                        queryString += "&" + param.value() + "=" + encodedValue;
                    }
                } catch (IllegalAccessException | UnsupportedEncodingException e) {
                    logger.error("Failed to get value of field " + field.getName(), e);
                }
            }
        }

        return "?" + queryString.substring(1);
    }
}
