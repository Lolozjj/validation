package cn.zjj.validator;

import cn.zjj.validation.InList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.BiFunction;

/**
 * InList参数验证器
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class InListValidator implements ConstraintValidator<InList, Object> {
    /**
     * 元素列表
     */
    private String[] list;

    /**
     * 是否不理睬大小写
     */
    private boolean ignoreCase;

    /**
     * 参数校验时，会初始化一个 Validator ，此时调用该方法
     *
     * @param ano 修饰参数的 InList注解
     */
    @Override
    public void initialize(InList ano) {
        list = ano.value();;
        ignoreCase = ano.ignoreCase();
    }

    /**
     * 配合 initialize 方法初始化的值，对参数值进行校验
     *
     * @param value 参数实际值
     * @param context 上下文
     * @return 参数是否通过校验
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BiFunction<String, String, Boolean> equalFun = ignoreCase ? String::equalsIgnoreCase : String::equals;
        for (String item : list){
            if (equalFun.apply(item, value.toString())) {
                return true;
            }
        }
        return false;
    }
}