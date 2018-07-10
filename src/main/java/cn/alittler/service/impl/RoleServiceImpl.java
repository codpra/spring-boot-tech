package cn.alittler.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.alittler.entity.Role;
import cn.alittler.repository.RoleRepository;
import cn.alittler.service.RoleService;

/**
 * @author LiuDeCai
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role save(String name) {
		Role role = new Role();
		role.setName(name);
		role.setCreateTime(new Date());
		return roleRepository.save(role);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.delete(id);
	}

	@Override
	public Role update(Integer id, String name) {
		Role role = roleRepository.findOne(id);
		role.setName(name);
		return roleRepository.save(role);
	}

	@Override
	public Role findById(Integer id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Page<Role> getPage(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize);
		return roleRepository.findAll(pageRequest);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
