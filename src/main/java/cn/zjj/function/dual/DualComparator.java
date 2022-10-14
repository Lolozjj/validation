package cn.zjj.function.dual;

/**
 * 双元比较器，校验两个值之间是否满足某种关系
 * @param <T> 第一个参数的类型
 * @param <K> 第二个参数的类型
 */
public interface DualComparator<T, K> {
    boolean compute(T former, K latter);
}
