package cn.zjj.validator;

import cn.zjj.function.dual.DualComparator;
import cn.zjj.validation.Dual;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class DualValidator implements ConstraintValidator<Dual, Object> {

    private DualComparator comparator;
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

    @SneakyThrows
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
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
    }
}
