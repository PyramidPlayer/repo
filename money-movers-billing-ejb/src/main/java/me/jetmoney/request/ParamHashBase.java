package me.jetmoney.request;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by toroptsev on 19.09.16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.TYPE)
public @interface ParamHashBase {

    String[] fields();
    String algorithm();
    String separator();

}
