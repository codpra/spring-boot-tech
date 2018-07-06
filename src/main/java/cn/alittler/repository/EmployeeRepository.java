package cn.alittler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.alittler.entity.Employee;

/**
 * @author LiuDeCai
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
