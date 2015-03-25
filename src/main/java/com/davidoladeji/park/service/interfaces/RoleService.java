package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Role;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface RoleService {

    public void createRole(Role role);

    public Role findByRolename(String username);

    public List<Role> findAllRoles();

    public void updateRoleById(Long id);

    public Role findRoleById(Long id);

    public void deleteRoleById(Long id);

    public int countAllRoles();
}
