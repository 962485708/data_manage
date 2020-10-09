package network.request;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */


import com.google.gson.Gson;
import jwt.JWTUtil;
import network.response.BaseResponse;
import network.response.ResponseCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LogInInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token != null) {
            try {
                String subject = JWTUtil.parseJWT(token).getSubject();
                return true;
            } catch (Exception e) {
                response.setStatus(405);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");

                Gson gson = new Gson();
                PrintWriter out = null;
                out = response.getWriter();
                out.write(gson.toJson(new BaseResponse<>(ResponseCode.AUTH_ERROR, "没有token或者token格式错误")));
                out.flush();
                out.close();
                return false;
            }

        }
        response.setStatus(405);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        Gson gson = new Gson();
        PrintWriter out = null;
        out = response.getWriter();
        out.write(gson.toJson(new BaseResponse<>(ResponseCode.AUTH_ERROR, "没有token或者token格式错误")));
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
