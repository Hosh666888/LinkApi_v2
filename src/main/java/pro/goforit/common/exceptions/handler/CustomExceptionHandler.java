package pro.goforit.common.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.goforit.common.entity.R;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoPermissionException;
import pro.goforit.common.exceptions.NoSuchDataException;

import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:29
 * @desc:
 **/
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {


    @ExceptionHandler(AuthException.class)
    public R<String> authException(AuthException e){
      log.error(e.getMessage(),e);
      return R.authFail(e.getMessage());
    }

    @ExceptionHandler(NoSuchDataException.class)
    public R<String> noSuckDataException(NoSuchDataException e){
        log.error(e.getMessage(),e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<String> exception(Exception e){
        log.error(e.getMessage(),e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public R<String> runtimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return R.fail(e.getMessage());
    }


    @ExceptionHandler(NoPermissionException.class)
    public R<String> noPermissionException(NoPermissionException e){
        log.error(e.getMessage(),e);
        return R.fail(e.getMessage());
    }


    @ExceptionHandler(value = BindException.class)
    public R<String> handler4BindException(BindException e){
        log.error("参数绑定异常:{}",e.getMessage(),e);
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError field : fieldErrors) {
            sb.append(field.getField())
                    .append(":")
                    .append(field.getDefaultMessage())
                    .append(",");
        }
        log.error("参数绑定异常:{} 在绑定时出现异常",sb);
        return R.fail(String.format("参数绑定异常:%s ",sb));
    }



}
