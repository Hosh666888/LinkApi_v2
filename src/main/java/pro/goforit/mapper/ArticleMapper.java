package pro.goforit.mapper;

import org.apache.ibatis.annotations.Param;
import pro.goforit.common.entity.domain.Article;

import java.util.List;

/**
* @author zjj20
* @description 针对表【article】的数据库操作Mapper
* @createDate 2022-10-09 09:58:15
* @Entity pro.goforit.common.entity.domain.Article
*/
public interface ArticleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);


    List<Article> selectByTreeCatalogIds(@Param("ids") List<Long> ids);
}
