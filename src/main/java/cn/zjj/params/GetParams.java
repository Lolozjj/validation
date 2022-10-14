package cn.zjj.params;

import cn.zjj.function.dual.impl.ComparableDualComparator;
import cn.zjj.validation.Dual;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Dual(alias = "time", comparator = ComparableDualComparator.class)
public class GetParams {

    @Dual.Former(alias = "time")
    private String beginTime;
    @Dual.Latter(alias = "time")
    private String endTime;

}
