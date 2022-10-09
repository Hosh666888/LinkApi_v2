package pro.goforit.service.base.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pro.goforit.common.config.Constants;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.mapper.UserMapper;
import pro.goforit.service.base.IUserService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 14:44
 * @desc:
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(User user) {
        Assert.notNull(user,Constants.PARAMETER_CANT_BE_EMPTY);
        user.setId(IdUtil.getSnowflakeNextId());
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Assert.notNull(id,Constants.ID_CANT_BE_EMPTY);
        int i = userMapper.deleteByPrimaryKey(id);
        if (i<1){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSelective(User user) throws NoSuchDataException {
        Assert.notNull(user, Constants.PARAMETER_CANT_BE_EMPTY);
        Long userId = user.getId();
        Assert.notNull(userId,Constants.ID_CANT_BE_EMPTY);

        User origin = selectByPrimaryKey(userId);
        if (origin==null){
            throw new NoSuchDataException(String.format("未找到id为%s的用户信息",userId));
        }

        user.setUpdateTime(new Date());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i<1){
            throw new RuntimeException("更新失败");
        }

    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
