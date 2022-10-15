package cn.zjj.validation;

import cn.zjj.validator.EnumsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 枚举值参数校验器
 * 判断参数值是否在枚举元素的names之中
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
@Constraint(validatedBy = {EnumsValidator.class})
@Documented
@Repeatable(Enums.List.class)
@Retention(RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
public @interface Enums {
    String message() default "不在枚举值中";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    /**
     * 枚举类
     * @return class
     */
    Class<? extends Enum> value();

    /**
     * 是否理睬大小写，默认不理睬
     * @return boolean
     */
    boolean ignoreCase() default true;

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Enums[] value();
    }
}
