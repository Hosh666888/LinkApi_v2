package pro.goforit.common.config;

import org.springframework.util.Assert;
import pro.goforit.common.converter.UserConverter;
import pro.goforit.common.entity.Accessor;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.AuthException;

import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:36
 * @desc:
 **/
public class ContextConfig {
    private static final InheritableThreadLocal<Accessor>  _context = new InheritableThreadLocal();

    public static void set(Accessor accessor){
        _context.remove();
        _context.set(accessor);
    }


    private static Accessor get() throws AuthException {
        Accessor accessor = _context.get();

        // //=========================   mock数据
        // User user = new User();
        // user.setId(1556843175833477122L);
        // user.setNickName("Максим, Андрей ");
        // user.setRole(RoleEnum.ADMIN.name());
        // user.setPermissions(PermissionEnum.REVIEW_ARTICLE.name()+Constants.SEPARATOR+PermissionEnum.SUBMIT_ARTICLE.name());
        // accessor = UserConverter.convert2Accessor(user);
        // //=========================

        if (accessor==null){
            throw new AuthException("未读取到用户信息");
        }


        return accessor;
    }




    public static RoleEnum getRole() throws AuthException {
        return get().getRole();
    }

    public static List<PermissionEnum> getPermissions() throws AuthException {
        return get().getPermissions();
    }

    public static Long getUid() throws AuthException {
        return get().getUid();
    }

    public static String getNickName() throws AuthException {
        return get().getNickName();
    }

    public static boolean isAdmin() throws AuthException {
        return RoleEnum.ADMIN.equals(getRole());
    }

    public static boolean isVip() throws AuthException {
        return RoleEnum.VIP.equals(getRole());
    }

    public static boolean hasPermission(PermissionEnum permissionEnum) throws AuthException {
        return getPermissions().contains(permissionEnum);
    }


}
