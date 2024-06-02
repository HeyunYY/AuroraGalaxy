package com.chasexi.config.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/4/26 16:45
 * @Description:
 */

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        if (isResourceFile(removeJSessionID(requestURI))) {
            // 是资源文件，直接放行
//            System.out.println("发现资源请求：[" + requestURI + "] - 处理方式：放行");
            return true;
        }
        if (requestURI.equals("/disclaimers_privacy.html")){
//            System.out.println("发现请求：[" + requestURI + "] - 处理方式：放行");
            return true;
        }
        if (requestURI.equals("/error")){
            return true;
        }
        if (requestURI.equals("/")) {
//            System.out.println("发现请求：[" + requestURI + "] - 处理方式：放行");
            return true;
        }
        if (requestURI.equals("/Not_disclaimers")) {
            return true;
        }
        if (requestURI.equals("/disclaimers_finish")){
//            System.out.println("发现请求：[" + requestURI + "] - 处理方式：放行");
            return true;
        }

//        //增加对disclaimers_state属性的非空检查
//        String state = (String) session.getAttribute("disclaimers_state");
//        if (state == null || state.isEmpty()) {
////            System.err.println("发现请求：[" + requestURI + "] - 处理方式：拦截");
//            response.sendRedirect("/Not_disclaimers");
//            return false;
//        }
//        if (!("true").equals(state)) {
////            System.err.println("发现请求：[" + requestURI + "] - 处理方式：拦截");
//            response.sendRedirect("/Not_disclaimers");
//            return false;
//        }

        if (requestURI.contains("/admin")) {
            if(requestURI.equals("/admin/verifyLogin")){
                return true;
            }
            if(requestURI.equals("/admin/logout")){
                return true;
            }
            if (session.getAttribute("username") != null) {
                if(requestURI.contains("/admin/data")){
                    String checkKeyValue = (String)session.getAttribute("checkKey");
                    if (checkKeyValue != null && checkKeyValue.equals("true")) {
                        session.setAttribute("checkKey_error", "");
                        return true;
                    }else {
                        session.setAttribute("checkKey_error", "密钥验证失败或密钥已经过期！");
                        response.sendRedirect("/admin/index.html");
                        return false;
                    }
                }
                return true;
            }
            response.sendRedirect("/index.html");
            return false;
        }

        return true; // 允许请求通过
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 在处理程序执行后调用，但在视图被渲染之前
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 在视图渲染完成后调用
    }

    private boolean isResourceFile(String requestURI) {
        // 资源文件后缀列表，可以根据需要添加其他类型的资源文件后缀
//        String[] resourceExtensions = { ".css", ".js", ".jpg", ".jpeg", ".png", ".gif" ,".ico"};
        String[] resourceExtensions = { ".css", ".js", ".jpg", ".jpeg", ".png", ".gif", ".ico", ".svg", ".mp4", ".pdf",
                                        ".doc", ".xls", ".ppt", ".zip", ".txt" };
        // 遍历资源文件后缀列表，判断请求URI是否以该后缀结尾
        for (String extension : resourceExtensions) {
            if (requestURI.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * 1.首先，使用 indexOf 方法查找请求URI中是否包含了 ;jsessionid= 字符串。如果找到了，会返回该字符串在请求URI中的索引位置；
     *      如果没有找到，则返回 -1。
     * 2.如果找到了会话标识符的索引位置（即 jsessionIDIndex != -1），则使用 substring 方法将请求URI截断，
     *      从字符串开头截取到会话标识符的索引位置，即截取了会话标识符之前的部分。
     * 3.最后，返回截断后的请求URI。
     *
     */
    // 截断请求路径中的jsessionid值
    private String removeJSessionID(String requestURI) {
        int jsessionIDIndex = requestURI.indexOf(";jsessionid=");
        if (jsessionIDIndex != -1) {
            requestURI = requestURI.substring(0, jsessionIDIndex);
//            System.out.println("截断后的请求路径：" + requestURI);
        }
        return requestURI;
    }
}