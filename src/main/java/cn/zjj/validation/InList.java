package cn.zjj.validation;

import cn.zjj.validator.InListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {InListValidator.class})
@Documented
@Repeatable(InList.List.class)
@Retention(RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
public @interface InList {
    String message() default "不在列表值中";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    /**
     * 枚举类
     * @return class
     */
    String[] value();

    /**
     * 是否理睬大小写，默认不理睬
     * @return boolean
     */
    boolean ignoreCase() default true;

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        InList[] value();
    }
}
