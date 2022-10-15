package cn.zjj.validator;

import cn.zjj.function.dual.DualComparator;
import cn.zjj.validation.Dual;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * 双元验证器
 */
@Slf4j
public class DualValidator implements ConstraintValidator<Dual, Object> {

    /**
     * 双元比较器
     */
    private DualComparator comparator;
    /**
     * 验证器别名分组
     */
    private String alias;

    public void initialize(Dual dualAno) {
        Class<? extends DualComparator> comparator = dualAno.comparator();
        try {
            this.comparator = comparator.newInstance();
            this.alias = dualAno.alias();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            Object big = null;
            Object small = null;
            for (Field field : fields) {
                field.setAccessible(true);
                Dual.Former formerAno = field.getAnnotation(Dual.Former.class);
                if (formerAno != null) {
                    if (formerAno.alias().equals(this.alias)) {
                        big = field.get(obj);
                    }
                }
                Dual.Latter latterAno = field.getAnnotation(Dual.Latter.class);
                if (latterAno != null) {
                    if (latterAno.alias().equals(this.alias)) {
                        small = field.get(obj);
                    }
                }
            }
            return comparator.compute(big, small);
        } catch (Exception e) {
            log.error("params valid exception, ", e);
            return false;
        }
    }
}
