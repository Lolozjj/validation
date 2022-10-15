package cn.zjj.validation;

import cn.zjj.function.dual.DualComparator;
import cn.zjj.validator.DualValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 二元校验器校验器
 * 只能作用在类上，用@Former 和 @Latter 修饰要比较的字段
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
@Constraint(validatedBy = {DualValidator.class})
@Documented
@Repeatable(Dual.List.class)
@Retention(RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface Dual {
    String message() default "差值过大";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String alias();

    /**
     * 差值计算比较者
     * 指定两个值之间差值计算方法
     */
    Class<? extends DualComparator> comparator();

    /**
     * 传给 DualValidator 的参数
     */
    String[] params() default {};

    /**
     * 修饰差值计算中大的那个属性
     */
    @Documented
    @Retention(RUNTIME)
    @Target({FIELD})
    @interface Former{
        /**
         * 一个被 @Dual 修饰的类中可能存在多个差值对
         * 用此属性来确定@Former @Latter之间的配对
         * @return
         */
        String alias();
    }

    /**
     * 修饰差值计算中小的那个属性
     */
    @Documented
    @Retention(RUNTIME)
    @Target({FIELD})
    @interface Latter{
        String alias();
    }

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Dual[] value();
    }
}
