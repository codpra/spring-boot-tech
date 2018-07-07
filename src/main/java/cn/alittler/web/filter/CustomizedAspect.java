package cn.alittler.web.filter;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class CustomizedAspect {

	/**
	 * 针对cn.alittler.web.rest下的所有类的public方法有效
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(public * cn.alittler.web.rest.*.*(..))")
	public Object handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info("自定义过滤器开始");
		long startTime = new Date().getTime();
		Object object = proceedingJoinPoint.proceed();
		Object[] args = proceedingJoinPoint.getArgs();
		// TODO 如何获取参数名
		for (Object arg : args) {
			log.info("参数：{}", arg);
		}
		log.info("过滤器耗时：{} ms", new Date().getTime() - startTime);
		log.info("自定义过滤器结束");
		return object;
	}

}
