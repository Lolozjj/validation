package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.AbstractDualComparator;

import java.util.Date;

/**
 * 时间范围比较器
 * 判断两个时间的间隔是否满足条件
 *
 * 常用场景：
 * 查表时不允许查询过大时间段的数据
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class DateRangeDualComparator extends AbstractDualComparator<Date, Date> {
    private int interval;

    @Override
    public boolean compute(Date former, Date latter) {
        if (former == null || latter == null) {
            return false;
        }
        Date now = new Date();
        if (former.after(now) || latter.after(now)) {
            return false;
        }
        return latter.getTime() - former.getTime() <= Integer.parseInt(prams[0]);
    }

}
