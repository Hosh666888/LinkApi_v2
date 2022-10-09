package pro.goforit.service.base.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.goforit.common.config.Constants;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.service.base.IUserService;

import javax.annotation.Resource;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:15
 * @desc:
 **/
@SpringBootTest
class UserServiceImplTest {
    @Resource
    private IUserService iUserService;

    @Test
    void insertSelective() {
        User user = new User();

        StringJoiner joiner = new StringJoiner(Constants.SEPARATOR);
        for (PermissionEnum value : PermissionEnum.values()) {
            joiner.add(value.name());
        }
        user.setPermissions(joiner.toString());
        user.setNickName("mike~");
        user.setRole(RoleEnum.ADMIN.name());

        iUserService.insertSelective(user);

    }

    @Test
    void delete() {
        iUserService.delete(1579008841275146240L);
    }

    @Test
    void updateSelective() throws NoSuchDataException {
        User user = new User();
        user.setId(1579008841275146240L);
        user.setNickName("update~");

        iUserService.updateSelective(user);
    }
}