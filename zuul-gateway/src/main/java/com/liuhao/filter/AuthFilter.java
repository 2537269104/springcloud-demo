package com.liuhao.filter;

import com.netflix.discovery.util.StringUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AuthFilter extends ZuulFilter {

    /**
     * filterType:返回字符串代表了过滤器的类型
     * pre  路由之前
     * routing 路由之时
     * post 路由之后
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 在zuul网关里面是有多个过滤器  过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {

        return 0;
    }

    /**
     * 添加是否过滤的条件
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //业务逻辑判断
        //首先获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求路径的url
        String uri = request.getRequestURI();
        System.out.println(uri);
      //放行user的请求
        if(uri.startsWith("/user")){
            //false 放行
            return false;
        }
        return true;
    }
    /** 过滤器的具体逻辑。
     * 可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     **/
    @Override
    public Object run() throws ZuulException {
        //首先获取request对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.err.println("run:"+request.getRequestURI());
        //是否授权
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            //设置为false 就不会路由到后端的服务
            requestContext.setSendZuulResponse(false);
            //设置http响应的状态码 401代表未授权
            requestContext.setResponseStatusCode(401);
            //返回响应信息
            HttpServletResponse response = requestContext.getResponse();

            //response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            try{
                response.getWriter().write("{\"code\":401,\"msg:\":\"未授权\"}");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }
}
