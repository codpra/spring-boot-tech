package cn.alittler.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.alittler.entity.Role;

/**
 * @author LiuDeCai
 *
 */
public interface RoleService {

	/**
	 * 保存
	 * 
	 * @param name
	 * @return
	 */
	Role save(String name);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 更新
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	Role update(Integer id, String name);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	Role findById(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Role> getPage(Integer pageNo, Integer pageSize);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Role> findAll();

}
