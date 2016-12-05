/**
 * 
 */
package com.agr.puhup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agr.puhup.model.Role;

/**
 * @author Dilip Upadhyay
 *
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}