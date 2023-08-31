
package cn.springboot.blog.config.handler;

import cn.springboot.blog.common.Constants;
import cn.springboot.blog.common.MallException;
import cn.springboot.blog.common.ServiceResultEnum;
import cn.springboot.blog.config.annotation.TokenToMallUser;
import cn.springboot.blog.dao.UserTokenMapper;
import cn.springboot.blog.dao.UsersMapper;
import cn.springboot.blog.entity.UserInfoAndRegisterInfo;
import cn.springboot.blog.entity.UserToken;
import cn.springboot.blog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenToMallUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UsersMapper UserMapper;
    @Autowired
    private UserTokenMapper UserTokenMapper;

    public TokenToMallUserMethodArgumentResolver() {
    }

    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToMallUser.class)) {
            return true;
        }
        return false;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToMallUser.class) instanceof TokenToMallUser) {
            UserInfoAndRegisterInfo mallUser = null;
            String token = webRequest.getHeader("token");
            System.err.println("token:"+token);
            if (null != token && !"".equals(token) && token.length() == Constants.TOKEN_LENGTH) {
                UserToken userToken = UserTokenMapper.selectByToken(token);
                System.out.println(userToken);
                if (userToken == null || userToken.getExpireTime().getTime() <= System.currentTimeMillis()) {
                    MallException.fail(ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult());
                }
                mallUser = UserMapper.selectById(userToken.getUserId());
                if (mallUser == null) {
                    MallException.fail(ServiceResultEnum.USER_NULL_ERROR.getResult());
                }
                if (mallUser.getLockedflag().intValue() == 1) {
                    MallException.fail(ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult());
                }
                return mallUser;
            } else {
                MallException.fail(ServiceResultEnum.NOT_LOGIN_ERROR.getResult());
            }
        }
        return null;
    }

    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

}
