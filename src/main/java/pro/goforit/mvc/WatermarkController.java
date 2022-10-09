package pro.goforit.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 10:07
 * @desc:
 **/
@RestController
@RequestMapping("mark")
public class WatermarkController {

    @GetMapping
    public String test(){
        return "Design in 2022/10/9 --> github : https://github.com/Hosh666888/LinkApi_v2.git";
    }


}
