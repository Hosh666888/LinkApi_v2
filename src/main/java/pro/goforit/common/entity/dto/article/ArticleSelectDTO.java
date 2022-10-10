package pro.goforit.common.entity.dto.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pro.goforit.common.entity.dto.BaseSelectDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 9:13
 * @desc:
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleSelectDTO extends BaseSelectDTO implements Serializable {
    private static final long serialVersionUID = -7533925998599693686L;

    private List<Long> ids;

    private Long treeCatalogId;

    private String title;
    /**
     * 标签 逗号分隔
     */
    private String label;

    private String keywords;

    private Boolean ifReprinted;

    private Boolean ifTop;

    private boolean ifPrivate;

    private Long createUser;

    //已发布时间为基准
    private Date begin;

    private Date end;


}
