package pro.goforit.mapper;

import pro.goforit.common.entity.domain.Comment;

/**
* @author zjj20
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2022-10-09 09:58:02
* @Entity pro.goforit.common.entity.domain.Comment
*/
public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

}
