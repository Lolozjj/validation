package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.DualComparator;

/**
 * Integer 大小比较器
 */
public class IntegerDualComparator implements DualComparator<Integer, Integer> {
    @Override
    public boolean compute(Integer former, Integer latter) {
        return former > latter;
    }
}