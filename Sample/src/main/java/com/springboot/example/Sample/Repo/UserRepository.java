package com.springboot.example.Sample.Repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.example.Sample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmailAndPassword(String emailId, String password);
	public Optional<User> findByEmail(String emailId);

}

