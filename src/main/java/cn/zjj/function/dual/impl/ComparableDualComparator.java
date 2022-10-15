package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.AbstractDualComparator;

/**
 * Comparable 比较器
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class ComparableDualComparator extends AbstractDualComparator<Comparable,Object> {
    @Override
    public boolean compute(Comparable former, Object latter) {
        return former.compareTo(latter) > 0;
    }
}
