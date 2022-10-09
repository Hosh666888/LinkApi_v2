package pro.goforit.service.base;

import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:18
 * @desc:
 **/
public interface ICommentService {

    void insertSelective(Comment comment) throws AuthException;

    void delete(Long id);

    void updateSelective(Comment comment) throws NoSuchDataException;

    Comment selectByPrimaryKey(Long id);

}
