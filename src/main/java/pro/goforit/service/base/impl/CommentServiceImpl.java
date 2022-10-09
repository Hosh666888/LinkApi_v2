package pro.goforit.service.base.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pro.goforit.common.config.Constants;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.entity.domain.Comment;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.mapper.CommentMapper;
import pro.goforit.service.base.ICommentService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 14:11
 * @desc:
 **/
@Service
@Slf4j
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(Comment comment) throws AuthException {
        Assert.notNull(comment, Constants.PARAMETER_CANT_BE_EMPTY);

        long id = IdUtil.getSnowflakeNextId();
        comment.setId(id);
        comment.setCreateTime(new Date());
        comment.setCreateUser(ContextConfig.getUid());

        int i = commentMapper.insertSelective(comment);
        if (i<1){
            throw new RuntimeException("新增失败");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Assert.notNull(id,Constants.PARAMETER_CANT_BE_EMPTY);
        int i = commentMapper.deleteByPrimaryKey(id);
        if (i<1){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSelective(Comment comment) throws NoSuchDataException {
        Assert.notNull(comment,Constants.PARAMETER_CANT_BE_EMPTY);
        Long id = comment.getId();
        Assert.notNull(id,Constants.ID_CANT_BE_EMPTY);

        Comment origin = selectByPrimaryKey(id);
        if (origin==null){
            throw new NoSuchDataException(String.format("未找到id为%s的评论信息",id));
        }

        int i = commentMapper.updateByPrimaryKeySelective(comment);
        if (i<1){
            throw new RuntimeException("更新失败");
        }

    }

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }
}
