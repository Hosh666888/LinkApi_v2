package pro.goforit.service.base.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pro.goforit.common.config.Constants;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.converter.ArticleConverter;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.dto.article.ArticleSelectDTO;
import pro.goforit.common.entity.vo.article.ArticleSelectVO;
import pro.goforit.common.entity.vo.article.ArticleVO;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoPermissionException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.mapper.ArticleMapper;
import pro.goforit.service.base.IArticleService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:22
 * @desc:
 **/
@Component
@Slf4j
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSelective(Article article) throws AuthException {

        Assert.notNull(article,Constants.PARAMETER_CANT_BE_EMPTY);
        Assert.hasText(article.getTitle(),"标题不可为空");
        Assert.notNull(article.getTreeCatalogId(),"目录id不可为空");

        log.info("正在新增文章,参数:{}",article);

        long id = IdUtil.getSnowflakeNextId();
        article.setId(id);
        Long uid = ContextConfig.getUid();
        Date now = new Date();
        article.setCreateUser(uid);
        article.setUpdateUser(uid);
        article.setCreateTime(now);
        article.setUpdateTime(now);

        int i = articleMapper.insertSelective(article);
        if (i<1){
            throw new RuntimeException("新增失败");
        }
        log.info("成功添加一篇文章");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws AuthException, NoPermissionException {
        Assert.notNull(id,Constants.ID_CANT_BE_EMPTY);
        log.info("正在删除id为[{}]的文章",id);
        if (!ContextConfig.isAdmin()){
            Article origin = selectByPrimaryKey(id);
            if (!origin.getCreateUser().equals(ContextConfig.getUid())) {
                throw new NoPermissionException("无法删除他人文章");
            }
        }

        int i = articleMapper.deleteByPrimaryKey(id);
        if (i<1){
            throw new RuntimeException("删除失败");
        }
        log.info("成功删除文章");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSelective(Article article) throws NoSuchDataException, AuthException, NoPermissionException {
        Assert.notNull(article, Constants.PARAMETER_CANT_BE_EMPTY);
        log.info("正在更新文章信息,参数:{}",article);
        Long id = article.getId();
        Assert.notNull(id,Constants.ID_CANT_BE_EMPTY);

        Article origin = selectByPrimaryKey(id);
        if (origin==null){
            throw new NoSuchDataException(String.format("未找到id为[%s]的文章信息",id));
        }

        if (!ContextConfig.isAdmin() && !ContextConfig.getUid().equals(origin.getCreateUser())){
            throw new NoPermissionException("不可修改他人文章");
        }


        article.setUpdateTime(new Date());
        article.setUpdateUser(ContextConfig.getUid());

        int i = articleMapper.updateByPrimaryKeySelective(article);
        if (i<1){
            throw new RuntimeException("更新失败");
        }
        log.info("成功修改文章信息");

    }

    @Override
    public Article selectByPrimaryKey(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> selectByTreeCatalogIds(List<Long> ids) {
        return articleMapper.selectByTreeCatalogIds(ids);
    }

    @Override
    public PageInfo<ArticleVO> select(ArticleSelectDTO dto) {
        if (dto==null){
            dto = new ArticleSelectDTO();
        }
        PageMethod.startPage(dto.getPageIndex(),dto.getPageSize());
        List<ArticleSelectVO> articles = articleMapper.richSelect(dto);
        PageInfo<ArticleSelectVO> of = PageInfo.of(articles);

        PageInfo<ArticleVO> result = new PageInfo<>();
        BeanUtils.copyProperties(of,result);

        List<ArticleVO> collect = of.getList()
                .stream().map(ArticleConverter::convertSelectVO2VO)
                .collect(Collectors.toList());
        result.setList(collect);

        return result;
    }

}
