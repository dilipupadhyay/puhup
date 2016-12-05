/**
 * 
 */
package com.agr.puhup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agr.puhup.model.User;

/**
 * @author Dilip Upadhyay
 *
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}