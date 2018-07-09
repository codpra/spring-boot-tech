package cn.alittler.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.alittler.entity.Department;
import cn.alittler.service.DepartmentService;

/**
 * @author LiuDeCai
 *
 */
@RestController
@RequestMapping("/deps")
public class DepartmentRest {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public Department create(@RequestParam String name) {
		Department department = departmentService.save(name);
		return department;
	}

	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam Integer id) {
		departmentService.delete(id);
		return ResponseEntity.ok("删除成功");
	}

	@PutMapping
	public Department updateById(@RequestParam Integer id, @RequestParam String name) {
		Department department = departmentService.update(id, name);
		return department;
	}

	@GetMapping("/{id}")
	public Department getById(@PathVariable Integer id) {
		Department department = departmentService.findById(id);
		return department;
	}

	@GetMapping("/page")
	public Page<Department> getPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		Page<Department> page = departmentService.getPage(pageNo, pageSize);
		return page;
	}

	@GetMapping
	public List<Department> getAll() {
		List<Department> list = departmentService.findAll();
		return list;
	}
}
