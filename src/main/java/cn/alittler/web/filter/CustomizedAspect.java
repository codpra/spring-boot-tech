package cn.alittler.web.filter;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuDeCai
 *
 */
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
		log.info("自定义切面开始");
		long startTime = System.currentTimeMillis();
		Object object = proceedingJoinPoint.proceed();
		log.info("getName: {}, getDeclaringType: {}, getDeclaringTypeName: {}",
				proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getSignature().getDeclaringType(),
				proceedingJoinPoint.getSignature().getDeclaringTypeName());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		String classType = proceedingJoinPoint.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(classType);
		String clazzName = clazz.getName();
		String methodName = proceedingJoinPoint.getSignature().getName(); // 获取方法名称
		Object[] argsValues = proceedingJoinPoint.getArgs();// 参数
		Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, argsValues);// 获取被切参数名称及参数值

		Object[] args = proceedingJoinPoint.getArgs();
		// TODO 如何获取参数名
		for (Object arg : args) {
			log.info("参数：{}", arg);
		}

		log.info("过滤器耗时：{} ms", System.currentTimeMillis() - startTime);
		log.info("自定义切面结束");
		return object;
	}

	private Map<String, Object> getFieldsName(Class<?> clazz, String clazzName, String methodName, Object[] argsValues)
			throws NotFoundException {
		Map<String, Object> map = new HashMap<String, Object>();

		ClassPool pool = ClassPool.getDefault();
		// ClassClassPath classPath = new ClassClassPath(this.getClass());
		ClassClassPath classPath = new ClassClassPath(clazz);
		pool.insertClassPath(classPath);

		CtClass cc = pool.get(clazzName);
		CtMethod cm = cc.getDeclaredMethod(methodName);
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			// exception
		}
		// String[] paramNames = new String[cm.getParameterTypes().length];
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < cm.getParameterTypes().length; i++) {
			map.put(attr.variableName(i + pos), argsValues[i]);// paramNames即参数名
		}
		return map;
	}

}
