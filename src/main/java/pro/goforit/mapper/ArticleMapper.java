package pro.goforit.mapper;

import org.apache.ibatis.annotations.Param;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.dto.article.ArticleSelectDTO;
import pro.goforit.common.entity.vo.article.ArticleSelectVO;
import pro.goforit.common.entity.vo.article.ArticleVO;

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

    //不返回origin_content(纯文本内容)
    List<ArticleSelectVO> richSelect(ArticleSelectDTO dto);
}
