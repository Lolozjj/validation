package cn.zjj.dual;

import cn.zjj.dual.params.DualComparableParams;
import cn.zjj.dual.params.DualDateRangeParams;
import cn.zjj.dual.params.DualParams;
import cn.zjj.dual.params.DualTypeErrorParams;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.ConstraintViolation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DualTest {
    @Autowired
    private SpringValidatorAdapter validatorAdapter;

    @Test
    public void testTrue() {
        DualParams dualParams = new DualParams(3,1);
        Set<ConstraintViolation<DualParams>> set = validatorAdapter.validate(dualParams);
        Assert.assertTrue(set.isEmpty());
    }

    @Test
    public void testError() {
        DualParams dualParams = new DualParams(1,3);
        Set<ConstraintViolation<DualParams>> set = validatorAdapter.validate(dualParams);
        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void testTypeError() {
        DualTypeErrorParams dualParams = new DualTypeErrorParams("1",3);
        Set<ConstraintViolation<DualTypeErrorParams>> set = validatorAdapter.validate(dualParams);
        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void testComparable() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DualComparableParams dualParams = new DualComparableParams(sdf.parse("2022-10-10"),sdf.parse("2022-10-1"));
        Set<ConstraintViolation<DualComparableParams>> set = validatorAdapter.validate(dualParams);
        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void testDateRange() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DualDateRangeParams dualParams = new DualDateRangeParams(sdf.parse("2022-10-10 12:00:00"),sdf.parse("2022-10-10 12:20:00"));
        Set<ConstraintViolation<DualDateRangeParams>> set = validatorAdapter.validate(dualParams);
        Assert.assertFalse(set.isEmpty());
    }

}
