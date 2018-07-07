package cn.alittler.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.alittler.web.filter.CustomizedInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private CustomizedInterceptor customizedInterceptor;

	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(customizedInterceptor);
	}

}
