package pro.goforit.common.aspect;

import cn.hutool.log.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pro.goforit.common.anno.Auth;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.entity.R;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoPermissionException;

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
    public void preAuth(Auth auth) throws AuthException, NoPermissionException {

        PermissionEnum[] needPermissions = auth.hasPermission();
        RoleEnum[] roleEnums = auth.hasRole();
        boolean b = auth.mustBeAdmin();

        if (b && !ContextConfig.isAdmin()){
            throw new RuntimeException("非管理员无法访问");
        }

        if (roleEnums.length>0){
            RoleEnum myRole = ContextConfig.getRole();
            long count = Arrays.stream(roleEnums).filter(item -> item.equals(myRole)).count();
            if (count<1){
                throw new RuntimeException("不具备相应角色权限");
            }
        }

        if (needPermissions.length>0){
            List<PermissionEnum> myPermissions = ContextConfig.getPermissions();

            if (CollectionUtils.isEmpty(myPermissions)){
                throw new RuntimeException("不具备此操作权限");
            }

            boolean containPermissions = false;
            for (PermissionEnum needPermission : needPermissions) {
                if (myPermissions.contains(needPermission)) {
                    containPermissions = true;
                    break;
                }
            }
            if (!containPermissions){
                throw new RuntimeException("不具备相应操作权限");
            }
        }




    }




}
