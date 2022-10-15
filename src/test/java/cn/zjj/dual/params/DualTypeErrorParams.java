package cn.zjj.dual.params;

import cn.zjj.function.dual.impl.IntegerDualComparator;
import cn.zjj.validation.Dual;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Dual(alias = "normal", comparator = IntegerDualComparator.class)
public class DualTypeErrorParams {

    @Dual.Former(alias = "normal")
    private String one;

    @Dual.Latter(alias = "normal")
    private int two;
}
