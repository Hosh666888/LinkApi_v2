package pro.goforit.service.base;

import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;

import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:19
 * @desc:
 **/
public interface IArticleService {
    void insertSelective(Article article) throws AuthException;

    void delete(Long id);

    void updateSelective(Article article) throws NoSuchDataException, AuthException;

    Article selectByPrimaryKey(Long id);

    List<Article> selectByTreeCatalogIds(List<Long> ids);
}
