package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Repo extends JpaRepository<clients,String>{
    boolean existsByEmailid(String emailid);
    List<clients> findByEmailid(String emailid);
}