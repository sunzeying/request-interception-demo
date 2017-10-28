package com.nextyu.demo.web.interceptor;

import com.nextyu.demo.web.controller.HelloController;
import org.springframework.core.MethodParameter;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2017-10-28 17:13
 *
 * @author nextyu
 */
@Component
public class TimeInterceptor extends HandlerInterceptorAdapter {

    private final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("startTimeThreadLocal");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("time interceptor preHandle");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取处理当前请求的 handler 信息
        System.out.println("handler 类：" + handlerMethod.getBeanType().getName());
        System.out.println("handler 方法：" + handlerMethod.getMethod().getName());

        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            String parameterName = methodParameter.getParameterName();
            // 只能获取参数的名称，不能获取到参数的值
            //System.out.println("parameterName: " + parameterName);
        }

        // 把当前时间放入 threadLocal
        startTimeThreadLocal.set(System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 从 threadLocal 取出刚才存入的 startTime
        Long startTime = startTimeThreadLocal.get();
        long endTime = System.currentTimeMillis();

        System.out.println("time interceptor consume " + (endTime - startTime) + " ms");

        System.out.println("time interceptor afterCompletion");
    }
}
