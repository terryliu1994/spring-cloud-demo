package com.terry.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     *
     * @return String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     *
     * @return Object
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write("没有Token");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
