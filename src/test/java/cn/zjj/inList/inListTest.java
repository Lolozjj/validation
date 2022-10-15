package cn.zjj.inList;

import cn.zjj.validation.InList;
import cn.zjj.validator.InListValidator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

@SpringBootTest
public class inListTest {
    private static InListValidator enumsValidator = new InListValidator();

    private static String[] values = new String[]{"A","B","C"};
    static {
        enumsValidator.initialize(getAno());
    }
    @Test
    public void testTrue() {
        Assert.assertTrue(enumsValidator.isValid("A",null));
    }
    @Test
    public void testError() {
        Assert.assertFalse(enumsValidator.isValid("Z",null));
    }
    @Test
    public void testIgnoreCase() {
        Assert.assertTrue(enumsValidator.isValid("a",null));
    }

    private static InList getAno() {
        return new InList() {
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
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return null;
            }

            @Override
            public String[] value() {
                return values;
            }

            @Override
            public boolean ignoreCase() {
                return true;
            }
        };
    }

}
