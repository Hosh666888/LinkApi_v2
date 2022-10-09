package pro.goforit.common.entity.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 14:45
 * @desc:
 **/
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -6497591805919552366L;

    private Long id;

    private Long articleId;

    private String content;

    private Long replyId;

    private Long createUser;

    private Date createTime;

    private Integer flag;

}
