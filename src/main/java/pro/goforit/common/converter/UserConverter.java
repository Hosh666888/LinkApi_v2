package pro.goforit.common.converter;

import org.springframework.util.StringUtils;
import pro.goforit.common.config.Constants;
import pro.goforit.common.entity.Accessor;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;

import java.util.ArrayList;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:49
 * @desc:
 **/
public class UserConverter {


    public static Accessor convert2Accessor(User user){

        Accessor accessor = new Accessor();

        accessor.setNickName(user.getNickName());
        accessor.setUid(user.getId());
        accessor.setRole(RoleEnum.valueOf(user.getRole()));

        String permissions = user.getPermissions();
        if (StringUtils.hasText(permissions)){
            String[] split = permissions.split(Constants.SEPARATOR);
            ArrayList<PermissionEnum> list = new ArrayList<>(split.length);
            for (String s : split) {
                list.add(PermissionEnum.valueOf(s));
            }
            accessor.setPermissions(list);
        }


        return accessor;

    }


}
