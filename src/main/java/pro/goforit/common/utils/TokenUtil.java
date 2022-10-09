package pro.goforit.common.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import pro.goforit.common.config.Constants;
import pro.goforit.common.entity.Accessor;
import pro.goforit.common.entity.domain.User;
import pro.goforit.common.enums.PermissionEnum;
import pro.goforit.common.enums.RoleEnum;
import pro.goforit.common.exceptions.AuthException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/9 16:26
 * @desc:
 **/
@Slf4j
public class TokenUtil {


    public static String generateToken(User user){
        HashMap<String, Object> payload = new HashMap<>(8);
        DateTime now = DateTime.now();
        DateTime expire = now.offset(DateField.HOUR, 2);
        payload.put("uid",user.getId());
        payload.put("nickName",user.getNickName());
        payload.put("role", RoleEnum.valueOf(user.getRole()));
        payload.put("permissions", PermissionEnum.convertFromStr(user.getPermissions()));
        //签发时间
        payload.put(JWTPayload.ISSUED_AT,now);
        //生效时间
        payload.put(JWTPayload.NOT_BEFORE,now);
        //失效时间
        payload.put(JWTPayload.EXPIRES_AT,expire);

        return JWTUtil.createToken(payload, Constants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static Accessor parseToken(String token) throws AuthException {

        try {
            JWTUtil.verify(token, Constants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        } catch (SignatureVerificationException e) {
            throw new AuthException("无效签名");
        } catch (TokenExpiredException e) {
            throw new AuthException("token过期");
        } catch (AlgorithmMismatchException e) {
            throw new AuthException("token算法不一致");
        } catch (Exception e) {
            throw new AuthException("token失效");
        }


        JWT jwt = JWTUtil.parseToken(token);

        JWTPayload payload = jwt.getPayload();
        log.info(String.valueOf(payload));

        Accessor accessor = new Accessor();
        accessor.setUid(Long.parseLong(payload.getClaim("uid").toString()));
        accessor.setNickName(payload.getClaim("nickName").toString());
        accessor.setRole(RoleEnum.valueOf(payload.getClaim("role").toString()));
        accessor.setPermissions((List<PermissionEnum>) payload.getClaim("permissions"));

        return accessor;
    }

    public static void main(String[] args) throws AuthException {

        User user = new User();
        user.setId(111111111111111L);
        user.setNickName("aaaa");
        user.setRole(RoleEnum.ADMIN.name());
        user.setPermissions(PermissionEnum.SUBMIT_ARTICLE.name());

        String s = generateToken(user);

        log.info(s);


        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjExMTExMTExMTExMTExMSwicm9sZSI6IkFETUlOIiwibmJmIjoxNjY1MzEzNTUyLCJuaWNrTmFtZSI6ImFhYWEiLCJwZXJtaXNzaW9ucyI6WyJTVUJNSVRfQVJUSUNMRSJdLCJleHAiOjE2NjUzMTM1NTIsImlhdCI6MTY2NTMxMzU1Mn0.8YqkxZeIJ_E_TeZ2PpdxQ_wjWHx-_PlRwLI8crfuY_E";

        System.out.println(token.equals(s));

        Accessor accessor = parseToken(token);
        //
        System.out.println(accessor);


    }



}
