package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Role;
import com.davidoladeji.park.repository.RoleRepository;
import com.davidoladeji.park.service.interfaces.RoleService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */


@Stateless(name = "RoleServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public Role findByRolename(String rolename) {
        Role role = roleRepository.findByName(rolename);
        return role;
    }

    public List<Role> findAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

    public void updateRoleById(Long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
    }

    public Role findRoleById(Long id) {
        Role role = roleRepository.findOne(id);
        return role;
    }

    public void deleteRoleById(Long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
    }


    public int countAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        int numRoles = roleList.size();
        return numRoles;
    }
}
