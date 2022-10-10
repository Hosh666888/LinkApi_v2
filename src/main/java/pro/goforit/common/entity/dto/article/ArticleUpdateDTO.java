package pro.goforit.common.entity.dto.article;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 9:00
 * @desc:
 **/
@Data
public class ArticleUpdateDTO implements Serializable {
    private static final long serialVersionUID = 6473408897327210875L;


    @NotNull(message = "更新时id不可为空")
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
     * 用于检索的文本
     */
    private String originContent;

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



    private String remark;
}
