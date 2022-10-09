package pro.goforit.common.entity.tuple;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:28
 * @desc:
 **/
public class Tuple3<L,C,R> {
    public L t1;
    public C t2;
    public R t3;

    public Tuple3(L t1, C t2, R t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }
}
