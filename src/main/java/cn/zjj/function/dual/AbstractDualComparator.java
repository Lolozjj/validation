package cn.zjj.function.dual;



/**
 *
 * @author zjj
 * @date 2022-10-15 22:00:00
 */
public abstract class AbstractDualComparator<T,K> implements DualComparator<T,K> {

    protected String[] prams;

    @Override
    public void setParams(String[] params) {
        this.prams = params;
    }
}
