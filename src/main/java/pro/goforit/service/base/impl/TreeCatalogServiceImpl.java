package pro.goforit.service.base.impl;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import pro.goforit.common.config.Constants;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.domain.TreeCatalog;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.mapper.TreeCatalogMapper;
import pro.goforit.service.base.IArticleService;
import pro.goforit.service.base.ITreeCatalogService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 14:18
 * @desc:
 **/
@Slf4j
@Service
public class TreeCatalogServiceImpl implements ITreeCatalogService {
    @Resource
    private TreeCatalogMapper treeCatalogMapper;
    @Resource
    private IArticleService iArticleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(TreeCatalog treeCatalog) throws AuthException {
        Assert.notNull(treeCatalog, Constants.PARAMETER_CANT_BE_EMPTY);
        Assert.hasText(treeCatalog.getName(),"目录名称不可为空");

        treeCatalog.setId(IdUtil.getSnowflakeNextId());
        treeCatalog.setOwner(ContextConfig.getUid());

        int i = treeCatalogMapper.insertSelective(treeCatalog);
        if (i<1){
            throw new RuntimeException("新增失败");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Assert.notNull(id,Constants.ID_CANT_BE_EMPTY);
        List<Long> ids = selectAllSonIdsAndItselfById(id);
        if (!CollectionUtils.isEmpty(ids) && ids.size()>1){
            throw new RuntimeException("存在子节点不可删除");
        }
        List<Article> articles = iArticleService.selectByTreeCatalogIds(Collections.singletonList(id));
        if (!CollectionUtils.isEmpty(articles) && articles.size()>0){
            throw new RuntimeException("该目录下存在文章不可删除");
        }
        int i = treeCatalogMapper.deleteByPrimaryKey(id);
        if (i<1){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSelective(TreeCatalog treeCatalog) throws NoSuchDataException {
        Assert.notNull(treeCatalog,Constants.PARAMETER_CANT_BE_EMPTY);
        Long id = treeCatalog.getId();
        Assert.notNull(id, Constants.ID_CANT_BE_EMPTY);

        TreeCatalog origin = selectByPrimaryKey(id);
        if (origin==null){
            throw new NoSuchDataException(String.format("未找到id为%s的目录信息",id));
        }

        int i = treeCatalogMapper.updateByPrimaryKeySelective(treeCatalog);
        if (i<1){
            throw new RuntimeException("更新失败");
        }
    }

    @Override
    public TreeCatalog selectByPrimaryKey(Long id) {
        return treeCatalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Long> selectAllSonIdsAndItselfById(Long id) {
        return treeCatalogMapper.selectAllSonIdsAndItselfById(id);
    }
}
