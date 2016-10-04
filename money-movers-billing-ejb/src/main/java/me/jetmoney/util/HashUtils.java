package me.jetmoney.util;

import me.jetmoney.request.Param;
import me.jetmoney.request.ParamHashBase;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by toroptsev
 */
public class HashUtils {

    private static Logger logger = LoggerFactory.getLogger(HashUtils.class);

    public static String calc(Object o, String secret) {
        Class<ParamHashBase> paramHashBaseClass = ParamHashBase.class;
        if (!o.getClass().isAnnotationPresent(paramHashBaseClass)) {
            return null;
        }
        ParamHashBase paramHashBase = o.getClass().getAnnotation(paramHashBaseClass);
        String algorithm = paramHashBase.algorithm();
        String separator = paramHashBase.separator();
        Stream<String> fieldsStream = Arrays.stream(paramHashBase.fields());

        HashMap<String, Object> objectHashMap = new FastHashMap();

        Class<?> oClass = o.getClass();

        for (Field f : oClass.getDeclaredFields()) {

            if (f.isAnnotationPresent(Param.class)) {
                Param param = f.getAnnotation(Param.class);
                if (null != param ) {
                    try {
                        f.setAccessible(true);
                        Object v = f.get(o);
                        if (v != null) {
                            objectHashMap.put(param.value(), v);
                        }
                    } catch (IllegalAccessException e) {
                        logger.error("Failed to access to field " + f.getName(), e);
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        fieldsStream.forEach(field -> {

            if (field.equals("#secret")) {
                if (StringUtils.isNotEmpty(stringBuilder.toString())) {
                    stringBuilder.append(separator);
                }
                stringBuilder.append(secret);
            }

            Object fieldValue = objectHashMap.get(field);

            if (null != fieldValue) {
                if (StringUtils.isNotEmpty(stringBuilder.toString())) {
                    stringBuilder.append(separator);
                }
                stringBuilder.append(fieldValue);
            }
        });

        String message = stringBuilder.toString();

        logger.info("message: " + message);
        String digest = prepareDigest(message, algorithm);
        logger.info("digest: " + digest);

        return digest;
    }


    private static String prepareDigest(String message, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(message.getBytes());

            byte byteData[] = md.digest();

            String hexString = getHexStringB(byteData);
            logger.info("Hex format : " + hexString);
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            logger.error("Failed to prepare digest", e);
        }

        return null;
    }


    private static String getHexStringB(byte[] byteData) {
        StringBuilder hexString = new StringBuilder();
        for (byte aByteData : byteData) {
            String hex = Integer.toHexString(0xff & aByteData);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
