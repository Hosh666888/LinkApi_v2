package pro.goforit.service.base.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.goforit.common.entity.domain.TreeCatalog;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.service.base.ITreeCatalogService;

import javax.annotation.Resource;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 15:09
 * @desc:
 **/
@SpringBootTest
class TreeCatalogServiceTest {
    @Resource
    private ITreeCatalogService iTreeCatalogService;

    @Test
    void insertSelective() throws AuthException {
        TreeCatalog treeCatalog = new TreeCatalog();

        treeCatalog.setName("我的第一个目录");
        treeCatalog.setParentId(0L);

        iTreeCatalogService.insertSelective(treeCatalog);
    }

    @Test
    void delete() {
        iTreeCatalogService.delete(1579006632940621824L);
    }

    @Test
    void updateSelective() throws NoSuchDataException {
        TreeCatalog treeCatalog = new TreeCatalog();
        treeCatalog.setId(1579006632940621824L);
        treeCatalog.setName("update");
        treeCatalog.setParentId(2L);

        iTreeCatalogService.updateSelective(treeCatalog);
    }
}