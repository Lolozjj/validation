package cn.zjj.enums;

import cn.zjj.enums.enums.Fruit;
import cn.zjj.validation.Enums;
import cn.zjj.validator.EnumsValidator;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

@SpringBootTest
public class EnumsTest {
    private static EnumsValidator enumsValidator = new EnumsValidator();

    static {
        enumsValidator.initialize(getAno());
    }
    @Test
    public void testTrue() {
        Assert.assertTrue(enumsValidator.isValid("APPLE",null));
    }
    @Test
    public void testError() {
        Assert.assertFalse(enumsValidator.isValid("A",null));
    }
    @Test
    public void testIgnoreCase() {
        Assert.assertTrue(enumsValidator.isValid("apple",null));
    }

    private static Enums getAno() {
        Enums enums = new Enums(){

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return null;
            }

            @Override
            public Class<?>[] groups() {
                return null;
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return null;
            }

            @Override
            public Class<? extends Enum> value() {
                return Fruit.class;
            }

            @Override
            public boolean ignoreCase() {
                return true;
            }
        };
        return enums;
    }

}
