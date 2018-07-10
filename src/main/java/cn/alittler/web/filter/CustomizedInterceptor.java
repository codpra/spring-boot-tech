package cn.alittler.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义拦截器，加上@Component注解后还需要在配置中注册拦截器。
 * 
 * @author LiuDecai
 * @data 2018-07-07
 */
@Slf4j
@Component
public class CustomizedInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle");
		log.info("拦截器类名：{}", ((HandlerMethod) handler).getBean().getClass().getName());
		log.info("拦截器方法名：{}", ((HandlerMethod) handler).getMethod().getName());
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
		Long startTime = (Long) request.getAttribute("startTime");
		log.info("拦截器耗时：{} ms", System.currentTimeMillis() - startTime);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
		Long startTime = (Long) request.getAttribute("startTime");
		log.info("拦截器耗时：{} ms", System.currentTimeMillis() - startTime);
		log.info("异常信息：{}", ex);
	}

}
