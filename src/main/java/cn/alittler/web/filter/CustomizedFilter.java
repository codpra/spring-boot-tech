package cn.alittler.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义过滤器，取消@Component注解后需要在配置类中注册filter才能生效，如WebConfiguration
 * 
 * @author LiuDecai
 * @data 2018-07-07
 */
@Slf4j
// @Component
public class CustomizedFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("自定义过滤器初始化");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("自定义过滤器开始");
		long startTime = new Date().getTime();
		chain.doFilter(request, response);
		log.info("过滤器耗时：{} ms", new Date().getTime() - startTime);
		log.info("自定义过滤器结束");
	}

	@Override
	public void destroy() {
		log.info("自定义过滤器销毁");

	}

}
