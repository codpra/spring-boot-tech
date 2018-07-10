package cn.alittler.order.origin;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author LiuDeCai
 *
 */
public class ClassA extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.loglogic.logapp.webtest.testcase.users");
		suite.addTest(new ClassA("setUpBeforeClass"));
		suite.addTest(new ClassA("test3"));
		suite.addTest(new ClassA("test1"));
		suite.addTest(new ClassA("test2"));
		suite.addTest(new ClassA("tearDownAfterClass"));
		return suite;
	}

	public ClassA(String name) {
		super(name);
	}

	public static void setUpBeforeClass() throws Exception {
		System.out.println("setup method....");
	}

	public void test1() {
		System.out.println("this is the first method...");
	}

	public void test2() {
		System.out.println("this is the second method...");
	}

	public void test3() {
		System.out.println("this is the third method...");
	}

	public static void tearDownAfterClass() throws Exception {
		System.out.println("teardown method.....");
	}

}
