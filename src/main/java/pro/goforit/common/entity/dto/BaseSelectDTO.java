package pro.goforit.common.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/10 9:22
 * @desc:
 **/
@Data
public class BaseSelectDTO implements Serializable {

    private static final long serialVersionUID = 1469892219958104159L;

    private Integer pageIndex = 1;

    private Integer pageSize = 10;

    private String orderBy;

    private boolean ifAsc;

}
