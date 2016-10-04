package me.jetmoney.request;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by vk on 28.07.16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.FIELD)
public @interface Param {

    String value();

}
