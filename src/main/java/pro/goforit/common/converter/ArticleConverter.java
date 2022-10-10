package pro.goforit.common.converter;

import cn.hutool.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pro.goforit.common.config.Constants;
import pro.goforit.common.config.ContextConfig;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.dto.article.ArticleInsertDTO;
import pro.goforit.common.entity.dto.article.ArticleUpdateDTO;
import pro.goforit.common.entity.vo.article.ArticleSelectVO;
import pro.goforit.common.entity.vo.article.ArticleVO;
import pro.goforit.common.exceptions.AuthException;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 8:48
 * @desc:
 **/
@Slf4j
public class ArticleConverter {

    public static Article convertFromInsertDTO(ArticleInsertDTO dto) throws AuthException {
        if (dto==null) return null;

        Article article = new Article();
        article.setTreeCatalogId(dto.getTreeCatalogId());
        article.setTitle(dto.getTitle());
        List<String> labels = dto.getLabels();
        StringJoiner joiner = new StringJoiner(Constants.SEPARATOR);
        if (!CollectionUtils.isEmpty(labels)){
            labels.forEach(joiner::add);
            article.setLabels(joiner.toString());
        }
        article.setContent(dto.getContent());
        article.setOriginContent(dto.getOriginContent());
        article.setCoverImageUrl(dto.getCoverImageUrl());
        Boolean ifReprinted = dto.getIfReprinted();
        if (ifReprinted!=null && ifReprinted){
            String reprintedUrl = dto.getReprintedUrl();
            if (!StringUtils.hasText(reprintedUrl)) {
                throw new IllegalArgumentException("转载内容的链接不可为空");
            }
            article.setIfReprinted(1);
            article.setReprintedUrl(reprintedUrl);
        }

        Boolean ifTop = dto.getIfTop();
        if (ifTop!=null && ifTop){
            article.setIfTop(1);
        }

        Boolean ifPrivate = dto.getIfPrivate();
        if (ifPrivate!=null && ifPrivate){
            article.setIfPrivate(1);
        }

        article.setRemark(dto.getRemark());



        //status  admin无需审核
        if (ContextConfig.isAdmin()) {
            log.info("admin添加文章,无需审核");
            article.setStatus(1);
        }else{
            article.setStatus(0);
        }


        return article;
    }

    public static Article convertFromUpdateDTO(ArticleUpdateDTO dto){
        if (dto==null) return null;

        Article article = new Article();
        article.setId(dto.getId());
        article.setTreeCatalogId(dto.getTreeCatalogId());
        article.setTitle(dto.getTitle());
        List<String> labels = dto.getLabels();
        StringJoiner joiner = new StringJoiner(Constants.SEPARATOR);
        if (!CollectionUtils.isEmpty(labels)){
            labels.forEach(joiner::add);
            article.setLabels(joiner.toString());
        }
        article.setContent(dto.getContent());
        article.setOriginContent(dto.getOriginContent());
        article.setCoverImageUrl(dto.getCoverImageUrl());
        Boolean ifReprinted = dto.getIfReprinted();
        if (ifReprinted!=null && ifReprinted){
            String reprintedUrl = dto.getReprintedUrl();
            if (!StringUtils.hasText(reprintedUrl)) {
                throw new IllegalArgumentException("转载内容的链接不可为空");
            }
            article.setIfReprinted(1);
            article.setReprintedUrl(reprintedUrl);
        }

        Boolean ifTop = dto.getIfTop();
        if (ifTop!=null && ifTop){
            article.setIfTop(1);
        }

        Boolean ifPrivate = dto.getIfPrivate();
        if (ifPrivate!=null && ifPrivate){
            article.setIfPrivate(1);
        }

        article.setRemark(dto.getRemark());

        return article;
    }

    public static ArticleVO convertSelectVO2VO(ArticleSelectVO vo){
        if (vo==null) return null;

        ArticleVO articleVO = new ArticleVO();
        articleVO.setId(vo.getId());
        articleVO.setTreeCatalogId(vo.getTreeCatalogId());
        articleVO.setTitle(vo.getTitle());

        String labels = vo.getLabels();
        if (StringUtils.hasText(labels)){
            String[] split = labels.split(Constants.SEPARATOR);
            List<String> collect = Arrays.stream(split).distinct().collect(Collectors.toList());
            articleVO.setLabels(collect);
        }
        articleVO.setContent(vo.getContent());
        articleVO.setCoverImageUrl(vo.getCoverImageUrl());
        articleVO.setIfReprinted(vo.getIfReprinted()==1);
        articleVO.setReprintedUrl(vo.getReprintedUrl());
        articleVO.setIfTop(vo.getIfTop()==1);
        articleVO.setHeat(vo.getHeat());
        articleVO.setCreateUser(vo.getCreateUser());
        articleVO.setCreateTime(vo.getCreateTime());
        articleVO.setUpdateUser(vo.getUpdateUser());
        articleVO.setUpdateTime(vo.getUpdateTime());
        articleVO.setRemark(vo.getRemark());
        articleVO.setNickName(vo.getNickName());

        return articleVO;
    }
}
