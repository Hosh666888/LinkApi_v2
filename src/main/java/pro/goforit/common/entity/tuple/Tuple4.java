package pro.goforit.common.entity.tuple;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:28
 * @desc:
 **/
public class Tuple4<L,C1,C2,R> {
    public L t1;
    public C1 t2;
    public C2 t3;
    public R t4;

    public Tuple4(L t1, C1 t2, C2 t3, R t4) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }
}
