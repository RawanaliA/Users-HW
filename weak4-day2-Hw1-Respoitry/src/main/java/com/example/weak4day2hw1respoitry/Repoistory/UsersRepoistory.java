package com.example.weak4day2hw1respoitry.Repoistory;

import com.example.weak4day2hw1respoitry.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepoistory extends JpaRepository<Users,Integer> {
    Users findUsersByUsernameAndPassword(String username,String password);
    @Query("select e from Users e where e.email=?1")
    Users findUsersByEmail(String email);
    List<Users>findUsersByRole(String role);
    @Query("select g from Users g where g.age>=?1")
    List<Users>findUserByAge(Integer age);
}
