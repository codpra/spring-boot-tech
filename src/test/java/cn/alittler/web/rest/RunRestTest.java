package cn.alittler.web.rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	RoleRestTest.class, 
	DepartmentRestTest.class, 
	EmployeeRestTest.class 
})
public class RunRestTest {

}
