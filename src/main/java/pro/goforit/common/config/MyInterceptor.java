package pro.goforit.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pro.goforit.common.entity.Accessor;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.AuthException;
import pro.goforit.common.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 16:05
 * @desc:
 **/
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String ip = request.getRemoteAddr();
        log.info("\n");
        log.info("ip来源[{}],正在访问url:[{}]",ip,requestURI);
        inject(request);
        log.info("当前请求用户:[{}],当前请求用户角色:[{}]",ContextConfig.getNickName(),ContextConfig.getRole());
        return super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    void inject(HttpServletRequest request) throws AuthException {
        String token = request.getHeader(Constants.AUTH_HEADER);

        if (StringUtils.hasText(token)){
            Accessor accessor = TokenUtil.parseToken(token);
            ContextConfig.set(accessor);
        }else{
            Accessor accessor = new Accessor();
            accessor.setRole(RoleEnum.VISITOR);
            accessor.setPermissions(null);
            accessor.setUid(null);
            accessor.setNickName("游客");
            ContextConfig.set(accessor);
        }

    }
}
