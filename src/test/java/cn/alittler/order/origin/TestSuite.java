package cn.alittler.order.origin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author LiuDeCai
 *
 */
@RunWith(Suite.class) // 标记已经指明了这个类是junit，故做为junit来运行
@Suite.SuiteClasses({ ClassA.class, // 将要测试的多个类放到这里即可
		ClassA.class })
public class TestSuite { // 类不用写东西即可
}