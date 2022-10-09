package pro.goforit.common.enums;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:25
 * @desc:
 **/
public enum RCode {

    SUCCESS(0,"请求成功"),
    FAIL(-1,"请求失败"),
    AUTH_FAIL(-2,"认证失败")
    ;


    private final Integer code;
    private final String desc;


    RCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
