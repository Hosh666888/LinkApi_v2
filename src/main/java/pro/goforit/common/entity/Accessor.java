package pro.goforit.common.entity;

import lombok.Data;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:37
 * @desc:
 **/
@Data
public class Accessor implements Serializable {
    private static final long serialVersionUID = 3873848873820266146L;

    private Long uid;

    private String nickName;

    private RoleEnum role;

    private List<PermissionEnum> permissions;

}
