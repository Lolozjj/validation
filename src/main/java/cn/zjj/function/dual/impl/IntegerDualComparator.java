package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.AbstractDualComparator;

/**
 * Integer 大小比较器
 * 判断 former 是否大于 latter
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class IntegerDualComparator extends AbstractDualComparator<Integer, Integer> {
    @Override
    public boolean compute(Integer former, Integer latter) {
        return former > latter;
    }
}
