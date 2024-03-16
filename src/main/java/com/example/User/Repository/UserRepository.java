package com.example.User.Repository;
 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findUserByEmail(String email);

	User findFirstByEmail(String email);
	
	

	

}
