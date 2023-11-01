package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

}
