package cn.zjj.validator;

import cn.zjj.validation.Enums;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 枚举值参数验证器
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class EnumsValidator implements ConstraintValidator<Enums, String> {
    /**
     * 枚举值元素列表
     */
    private List<String> enumList;

    /**
     * 是否不理睬大小写
     */
    private boolean ignoreCase;

    /**
     * 参数校验时，会初始化一个 Validator ，此时调用该方法
     *
     * @param constraintAnnotation 修饰参数的 Enums注解
     */
    @Override
    public void initialize(Enums constraintAnnotation) {
        Class<? extends Enum> enumClass = constraintAnnotation.value();
        try{
            Method method = enumClass.getMethod("values");
            Enum[] enums = (Enum[])method.invoke(null, null);
            enumList = Arrays.stream(enums).map(Enum::name).collect(Collectors.toList());
            ignoreCase = constraintAnnotation.ignoreCase();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 配合 initialize 方法初始化的值，对参数值进行校验
     *
     * @param value 参数实际值
     * @param context 上下文
     * @return 参数是否通过校验
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        BiFunction<String, String, Boolean> equalFun = ignoreCase ? String::equalsIgnoreCase : String::equals;
        for (String item : enumList){
            if (equalFun.apply(item, value)) {
                return true;
            }
        }
        return false;
    }
}