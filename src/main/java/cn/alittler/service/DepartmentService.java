package cn.alittler.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.alittler.entity.Department;

/**
 * @author LiuDeCai
 *
 */
public interface DepartmentService {

	Department save(String name);

	void delete(Integer id);

	Department update(Integer id, String name);

	Department findById(Integer id);

	Page<Department> getPage(Integer pageNo, Integer pageSize);

	List<Department> findAll();

}
