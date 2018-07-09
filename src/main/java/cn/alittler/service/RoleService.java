package cn.alittler.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.alittler.entity.Role;

/**
 * @author LiuDeCai
 *
 */
public interface RoleService {

	Role save(String name);

	void delete(Integer id);

	Role update(Integer id, String name);

	Role findById(Integer id);

	Page<Role> getPage(Integer pageNo, Integer pageSize);

	List<Role> findAll();

}
