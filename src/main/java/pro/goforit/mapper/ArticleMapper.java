package pro.goforit.mapper;

import pro.goforit.common.entity.domain.Article;

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


}
