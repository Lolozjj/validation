package cn.zjj.function.dual;

/**
 * 双元比较器，校验两个值之间是否满足某种关系
 * 配合@Dual参数校验器使用
 *
 * @see cn.zjj.validation.Dual
 *
 * @param <T> 第一个参数的类型
 * @param <K> 第二个参数的类型
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public interface DualComparator<T, K> {
    /**
     * 计算被 @Dual 注解修饰的参数其中的Former值和Latter值是否满足校验
     *
     * @param former @Former 注解修饰的属性
     * @param latter @Latter 注解修饰的属性
     * @return 校验结果
     */
    boolean compute(T former, K latter);

    /**
     * 设置参数
     * @param params params
     */
    void setParams(String[] params);
}
