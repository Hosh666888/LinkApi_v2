package pro.goforit.common.anno;

import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;

import java.lang.annotation.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:45
 * @desc:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Auth {
    RoleEnum[] hasRole() default {};
    PermissionEnum[] hasPermission() default {};
    boolean mustBeAdmin() default false;
}
