package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.DualComparator;

/**
 * Integer 大小比较器
 * 判断 former 是否大于 latter
 */
public class IntegerDualComparator implements DualComparator<Integer, Integer> {
    @Override
    public boolean compute(Integer former, Integer latter) {
        return former > latter;
    }
}
