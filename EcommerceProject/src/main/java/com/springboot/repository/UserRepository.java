package com.springboot.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	public User findByUserName(String userName);
	public User findByUserNameAndPassword(String userName,String password);

}
