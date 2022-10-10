package pro.goforit.common.entity.vo.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pro.goforit.common.entity.domain.Article;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 10:32
 * @desc:
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleSelectVO extends Article implements Serializable {
    private static final long serialVersionUID = -4310552252617003916L;

    private String nickName;

}
