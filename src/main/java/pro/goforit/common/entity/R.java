package pro.goforit.common.entity;

import lombok.Data;
import pro.goforit.common.enums.RCode;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:24
 * @desc:
 **/
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1940563938453505479L;

    private Integer code;

    private String message;

    private T data;

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R<String> success(){
        return success(null,RCode.SUCCESS.getDesc());
    }

    public static <P> R<P> success(P data){
        return success(data,RCode.SUCCESS.getDesc());
    }

    public static <P> R<P> success(P data,String message){
        return new R<>(RCode.SUCCESS.getCode(), message,data);
    }

    public static R<String> fail(String message){
        return new R<>(RCode.FAIL.getCode(),message,message);
    }

    public static R<String > fail(){
        return fail(RCode.FAIL.getDesc());
    }

    public static R<String> authFail(){
        return R.authFail(RCode.AUTH_FAIL.getDesc());
    }

    public static R<String> authFail(String message){
        return new R<>(RCode.AUTH_FAIL.getCode(), message,message);
    }



}
