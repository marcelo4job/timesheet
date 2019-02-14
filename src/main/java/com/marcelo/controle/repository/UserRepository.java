package com.marcelo.controle.repository;

import com.marcelo.controle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
