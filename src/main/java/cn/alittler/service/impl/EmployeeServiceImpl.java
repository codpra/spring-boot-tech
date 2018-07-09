package cn.alittler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.entity.Employee;
import cn.alittler.repository.EmployeeRepository;
import cn.alittler.service.EmployeeService;
import cn.alittler.utils.DateUtils;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(String name, String birthday) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setBirthday(DateUtils.parseDateStr(birthday, "yyyy-MM-dd"));
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee update(Integer id, String name, String birthday) {
		Employee employee = employeeRepository.findOne(id);
		employee.setName(name);
		employee.setBirthday(DateUtils.parseDateStr(birthday, "yyyy-MM-dd"));
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Page<Employee> getPage(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize);
		return employeeRepository.findAll(pageRequest);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
