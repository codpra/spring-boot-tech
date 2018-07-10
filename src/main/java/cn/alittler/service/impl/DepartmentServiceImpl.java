package cn.alittler.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.entity.Department;
import cn.alittler.repository.DepartmentRepository;
import cn.alittler.service.DepartmentService;

/**
 * @author LiuDeCai
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department save(String name) {
		Department department = new Department();
		department.setName(name);
		department.setCreateTime(new Date());
		return departmentRepository.save(department);
	}

	@Override
	public void delete(Integer id) {
		departmentRepository.delete(id);
	}

	@Override
	public Department update(Integer id, String name) {
		Department department = departmentRepository.findOne(id);
		department.setName(name);
		return departmentRepository.save(department);
	}

	@Override
	public Department findById(Integer id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public Page<Department> getPage(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize);
		return departmentRepository.findAll(pageRequest);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

}
