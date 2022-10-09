package pro.goforit.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pro.goforit.common.anno.Auth;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.entity.R;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.AuthException;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:48
 * @desc:
 **/
@Aspect
@Component
public class PreAuthAspect {


    @Before("@annotation(auth)")
    public void preAuth(Auth auth) throws AuthException {

        PermissionEnum[] permissionEnums = auth.hasPermission();
        RoleEnum[] roleEnums = auth.hasRole();
        boolean b = auth.mustBeAdmin();

        if (b && !ContextConfig.isAdmin()){
            throw new AuthException("非管理员无法访问");
        }

        if (roleEnums.length>0){
            RoleEnum myRole = ContextConfig.getRole();
            long count = Arrays.stream(roleEnums).filter(item -> item.equals(myRole)).count();
            if (count<1){
                throw new AuthException("不具备相应角色权限");
            }
        }

        if (permissionEnums.length>0){
            boolean containPermissions = false;
            List<PermissionEnum> permissions = ContextConfig.getPermissions();
            for (PermissionEnum needPermission : permissionEnums) {
                if (permissions.contains(needPermission)) {
                    containPermissions = true;
                    break;
                }
            }

            if (!containPermissions){
                throw new AuthException("不具备相应操作权限");
            }
        }




    }




}
