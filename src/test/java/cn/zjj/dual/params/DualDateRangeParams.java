package cn.zjj.dual.params;

import cn.zjj.function.dual.impl.DateRangeDualComparator;
import cn.zjj.function.dual.impl.IntegerDualComparator;
import cn.zjj.validation.Dual;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Dual(alias = "normal", comparator = DateRangeDualComparator.class ,params = {"3600"})
public class DualDateRangeParams {

    @Dual.Former(alias = "normal")
    private Date beginTime;

    @Dual.Latter(alias = "normal")
    private Date EndTime;
}
