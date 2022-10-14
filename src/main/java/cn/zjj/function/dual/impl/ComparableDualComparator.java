package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.DualComparator;

public class ComparableDualComparator implements DualComparator<Comparable,Object> {
    @Override
    public boolean compute(Comparable former, Object latter) {
        return former.compareTo(latter) > 0;
    }
}
