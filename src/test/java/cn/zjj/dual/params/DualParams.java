package cn.zjj.dual.params;

import cn.zjj.function.dual.impl.IntegerDualComparator;
import cn.zjj.validation.Dual;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Dual(alias = "normal", comparator = IntegerDualComparator.class)
public class DualParams {

    @Dual.Former(alias = "normal")
    private int one;

    @Dual.Latter(alias = "normal")
    private int two;
}
