package pro.goforit.mvc;

import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.goforit.common.anno.Auth;
import pro.goforit.common.converter.ArticleConverter;
import pro.goforit.common.entity.R;
import pro.goforit.common.entity.domain.Article;
import pro.goforit.common.entity.dto.article.ArticleInsertDTO;
import pro.goforit.common.entity.dto.article.ArticleSelectDTO;
import pro.goforit.common.entity.dto.article.ArticleUpdateDTO;
import pro.goforit.common.entity.vo.article.ArticleVO;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.exceptions.NoPermissionException;
import pro.goforit.common.exceptions.NoSuchDataException;
import pro.goforit.service.base.IArticleService;

import javax.annotation.Resource;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 8:41
 * @desc:
 **/
@RestController
@RequestMapping("article")
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @PostMapping
    @Auth(hasPermission = PermissionEnum.SUBMIT_ARTICLE)
    public R<String> add(@RequestBody @Validated ArticleInsertDTO dto) throws AuthException {
        Article ready2Insert = ArticleConverter.convertFromInsertDTO(dto);
        articleService.insertSelective(ready2Insert);
        return R.success(null,"发布成功");
    }

    @PutMapping
    @Auth(hasPermission = PermissionEnum.SUBMIT_ARTICLE)
    public R<String > update(@RequestBody @Validated ArticleUpdateDTO dto) throws AuthException, NoSuchDataException, NoPermissionException {
        Article ready2Update = ArticleConverter.convertFromUpdateDTO(dto);
        articleService.updateSelective(ready2Update);
        return R.success(null,"更新成功");
    }

    @DeleteMapping("{id}")
    public R<String> delete(@PathVariable Long id) throws AuthException, NoPermissionException {
        articleService.delete(id);
        return R.success(null,"删除成功");
    }

    @GetMapping
    public R<PageInfo<ArticleVO>> select(ArticleSelectDTO dto){
        return R.success(articleService.select(dto));
    }


}
