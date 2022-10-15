package cn.zjj.dual.params;

import cn.zjj.function.dual.impl.ComparableDualComparator;
import cn.zjj.validation.Dual;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Dual(alias = "normal", comparator = ComparableDualComparator.class)
public class DualComparableParams {

    @Dual.Former(alias = "normal")
    private Date endTime;

    @Dual.Latter(alias = "normal")
    private Date beginTime;
}
