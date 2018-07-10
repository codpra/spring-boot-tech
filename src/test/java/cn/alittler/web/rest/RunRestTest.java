package cn.alittler.web.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author LiuDeCai
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({RoleRestTest.class, DepartmentRestTest.class, EmployeeRestTest.class})
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {RoleRestTest.class, DepartmentRestTest.class, EmployeeRestTest.class})
public class RunRestTest {
	
    @Test
    public void contextLoads() {

    }
}
