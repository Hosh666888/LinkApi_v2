package pro.goforit.common.enums;

import org.springframework.util.StringUtils;
import pro.goforit.common.config.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:40
 * @desc:
 **/
public enum PermissionEnum {

    SUBMIT_ARTICLE,
    REVIEW_ARTICLE;


    public static List<PermissionEnum> convertFromStr(String permission){
        if (StringUtils.hasText(permission)){
            String[] split = permission.split(Constants.SEPARATOR);
            return Arrays.stream(split).map(PermissionEnum::valueOf).distinct().collect(Collectors.toList());
        }else{
            return null;
        }
    }




}
