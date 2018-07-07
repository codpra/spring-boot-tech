package cn.alittler.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuDeCai
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloRest {

	@GetMapping("/filter")
	public ResponseEntity<String> testFilter(@RequestParam String name) {
		return ResponseEntity.ok("测试一下自定义Filter");
	}

	@GetMapping("/int")
	public ResponseEntity<String> testInterceptor(@RequestParam String name) {
		return ResponseEntity.ok("测试一下自定义Interceptor");
	}

	@GetMapping("/except")
	public ResponseEntity<String> testException(@RequestParam String name) {
		throw new RuntimeException("出错了");
	}

	@GetMapping("/aspect")
	public ResponseEntity<String> testAspect(@RequestParam String name) {
		return ResponseEntity.ok("测试一下自定义Aspect");
	}

	@GetMapping("/test")
	protected ResponseEntity<String> test(@RequestParam String name) {
		return ResponseEntity.ok("测试一下自定义Aspect");
	}

}
