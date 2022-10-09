package pro.goforit.service.base;

import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.entity.domain.TreeCatalog;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;

import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:19
 * @desc:
 **/
public interface ITreeCatalogService {

    void insertSelective(TreeCatalog treeCatalog) throws AuthException;

    /**
     *  判断是否包含子节点或者文章
     * @param id
     */
    void delete(Long id);

    void updateSelective(TreeCatalog treeCatalog) throws NoSuchDataException;

    TreeCatalog selectByPrimaryKey(Long id);


    /**
     *  通过id获取到其所有子目录
     * @param id
     * @return
     */
    List<Long> selectAllSonIdsAndItselfById(Long id);

}
