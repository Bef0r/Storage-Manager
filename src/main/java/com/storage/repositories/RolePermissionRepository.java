/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories;

import com.storage.repositories.entities.RolePermission;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolePermissionRepository extends CrudRepository<RolePermission, Long> {

    public List<RolePermission> findAllByRoleId(Long roleId);

    @Modifying
    @Query(value = "delete from RolePermission c where c.roleId = ?1")
    public int deleteByRoleId(long roleId);
}
