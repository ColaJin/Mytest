package hikversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截重定向请求处理
 */
public class ReirectInteceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(ReirectInteceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getServletPath();
        String requestURI = request.getRequestURI();
        if (url.contains("/redirect/")) {
            String[] split = url.split("/");
            int index = split.length;
            if (index < 5) {
                return false;
            }
            String dest = split[index - 1];
            response.setStatus(org.springframework.http.HttpStatus.TEMPORARY_REDIRECT.value());
            response.setHeader("Location", "/dms/v1/path?dest=" + dest);
            return true;
        }

        throw new Exception("request url error");
    }

}
