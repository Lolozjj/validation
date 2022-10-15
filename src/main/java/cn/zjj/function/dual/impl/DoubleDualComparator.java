package cn.zjj.function.dual.impl;

import cn.zjj.function.dual.AbstractDualComparator;

/**
 * Double 大小比较器
 * 判断 former 是否大于 latter
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public class DoubleDualComparator extends AbstractDualComparator<Double, Double> {
    @Override
    public boolean compute(Double former, Double latter) {
        return former > latter;
    }
}
