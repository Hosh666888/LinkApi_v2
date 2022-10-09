package pro.goforit.mapper;

import pro.goforit.common.entity.domain.User;

/**
* @author zjj20
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-10-09 09:56:46
* @Entity pro.goforit.common.entity.domain.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

}
