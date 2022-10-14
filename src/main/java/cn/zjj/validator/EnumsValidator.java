package cn.zjj.validator;

import cn.zjj.validation.Enums;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 枚举值参数校验器
 *
 *
 */
public class EnumsValidator implements ConstraintValidator<Enums, String> {
    private List<String> enumList;
    public void initialize(Enums constraintAnnotation) {
        Class<? extends Enum> enumClass = constraintAnnotation.value();
        try{
            Method method = enumClass.getMethod("values");
            Enum[] enums = (Enum[])method.invoke(null, null);
            enumList = Arrays.stream(enums).map(Enum::name).collect(Collectors.toList());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return enumList.contains(value);
    }
}