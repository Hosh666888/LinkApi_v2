package pro.goforit.service.base.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoPermissionException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.service.base.IArticleService;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 14:53
 * @desc:
 **/
@SpringBootTest
class ArticleServiceImplTest {
    @Resource
    private IArticleService iArticleService;

    @Test
    void insertSelective() throws AuthException {
        Article article = new Article();
        article.setContent("anduijahdiauhduaihduaihdauihahad");
        article.setContent("adakjdadiajhdiahda\n" +
                "                ajkdhsaudhauhduia\n" +
                "                askdnauijdhuaid\n" +
                "                amdjkandiandaidna");
        article.setCoverImageUrl("https://disposal.goforit.pro/files/hausdhauda.jpg");
        article.setLabels("测试");
        article.setRemark("asdadada");
        article.setTitle("akjhsduiahduahda");
        article.setTreeCatalogId(1241414L);
        iArticleService.insertSelective(article);
    }

    @Test
    void delete() throws AuthException, NoPermissionException {
        iArticleService.delete(1579003503050305536L);
    }

    @Test
    void updateSelective() throws AuthException, NoSuchDataException, NoPermissionException {
        Article article = new Article();
        article.setId(1579003503050305536L);
        iArticleService.updateSelective(article);
    }

    @Test
    void selectByPrimaryKey() {

    }

    @Test
    void selectByTreeCatalogIds() {

    }
}