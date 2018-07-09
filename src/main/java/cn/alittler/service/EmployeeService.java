package cn.alittler.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.alittler.entity.Employee;

/**
 * @author LiuDeCai
 *
 */
public interface EmployeeService {

	Employee save(String name, String birthday);

	void delete(Integer id);

	Employee update(Integer id, String name, String birthday);

	Employee findById(Integer id);

	Page<Employee> getPage(Integer pageNo, Integer pageSize);

	List<Employee> findAll();

}
