package pro.goforit.service.base;

import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.exceptions.NoSuchDataException;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:18
 * @desc:
 **/
public interface IUserService {
    void insertSelective(User user);

    void delete(Long id);

    void updateSelective(User user) throws NoSuchDataException;

    User selectByPrimaryKey(Long id);
}
