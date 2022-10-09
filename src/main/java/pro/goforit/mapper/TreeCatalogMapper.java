package pro.goforit.mapper;

import pro.goforit.common.entity.domain.TreeCatalog;

import java.util.List;

/**
* @author zjj20
* @description 针对表【tree_catalog(树型目录)】的数据库操作Mapper
* @createDate 2022-10-09 09:57:21
* @Entity pro.goforit.common.entity.domain.TreeCatalog
*/
public interface TreeCatalogMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(TreeCatalog record);

    TreeCatalog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TreeCatalog record);

    /**
     *      目前只找了一层
     * @param id
     * @return
     */
    List<Long> selectAllSonIdsAndItselfById(Long id);
}
