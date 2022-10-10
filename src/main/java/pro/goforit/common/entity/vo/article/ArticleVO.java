package pro.goforit.common.entity.vo.article;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 9:09
 * @desc:
 **/
@Data
public class ArticleVO implements Serializable {
    private static final long serialVersionUID = 6114520292739922980L;



    private Long id;

    private Long treeCatalogId;


    private String title;

    /**
     * 标签 逗号分隔
     */
    private List<String> labels;

    /**
     * 富文本原始字符
     */
    private String content;

    /**
     * 封面图片地址
     */
    private String coverImageUrl;

    /**
     * 是否转载
     */
    private Boolean ifReprinted;

    /**
     * 转载链接
     */
    private String reprintedUrl;

    /**
     * 是否置顶
     */
    private Boolean ifTop;

    /**
     * 是否公开
     */
    private Boolean ifPrivate;


    private Long heat;


    private Long createUser;


    private Date createTime;


    private Long updateUser;


    private Date updateTime;

    private String remark;

    private String nickName;

}
