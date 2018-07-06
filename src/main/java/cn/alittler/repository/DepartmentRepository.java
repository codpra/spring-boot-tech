package cn.alittler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.alittler.entity.Department;

/**
 * @author LiuDeCai
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
