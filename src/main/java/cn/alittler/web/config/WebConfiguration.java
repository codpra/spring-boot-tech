package cn.alittler.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.alittler.web.filter.CustomizedFilter;

/**
 * @author LiuDeCai
 *
 */
@Configuration
public class WebConfiguration {

	@Bean
	public FilterRegistrationBean customizedFilter() {
		// 注册filter
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		CustomizedFilter customizedFilter = new CustomizedFilter();
		filterRegistrationBean.setFilter(customizedFilter);
		// 针对哪些url起作用
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		filterRegistrationBean.setUrlPatterns(urls);
		return filterRegistrationBean;
	}

}
