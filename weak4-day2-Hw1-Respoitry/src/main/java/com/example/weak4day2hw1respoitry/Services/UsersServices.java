package com.example.weak4day2hw1respoitry.Services;

import com.example.weak4day2hw1respoitry.ApiExeption.ApiExeption;
import com.example.weak4day2hw1respoitry.Model.Users;
import com.example.weak4day2hw1respoitry.Repoistory.UsersRepoistory;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServices {

    private final UsersRepoistory usersRepoistory;

    public List<Users> getUsers() {

        return usersRepoistory.findAll();
    }

    public void addUsers(Users users) {

        usersRepoistory.save(users);
    }

    public boolean updateUsers(Integer id, Users users) {
        Users oldUsers = usersRepoistory.getById(id);
        if (oldUsers == null) {
            return false;
        }
        oldUsers.setName(users.getName());
        oldUsers.setAge(users.getAge());
        oldUsers.setUsername(users.getUsername());
        oldUsers.setEmail(users.getEmail());
        oldUsers.setPassword(users.getPassword());
        oldUsers.setRole(users.getRole());
        return true;
    }

    public boolean deleteUsers(Integer id) {
        Users oldusers = usersRepoistory.getById(id);
        if (oldusers == null) {
            return false;
        }
        usersRepoistory.delete(oldusers);
        return true;
    }

    public Users findUsersByUsernameAndPassword(String username, String password) {
        Users checked = usersRepoistory.findUsersByUsernameAndPassword(username, password);
        if (username == null & password == null) {
            throw new ApiExeption("The password and username Not correct Try again");

        }
        return checked;
    }

    public Users findUsersByEmail(String email) {
        Users gEmail =usersRepoistory.findUsersByEmail(email);
        if(email==null){
            throw new ApiExeption("Sorry Wrong Email");
    }return gEmail;
    }
public List<Users> findUsersByRole(String role){
    List<Users> gEmail =usersRepoistory.findUsersByRole(role);
    if(role==null){
        throw new ApiExeption(" Wrong Role");
    }return gEmail;
}
public List<Users> findUserByAge(Integer age){
    List<Users> gAge =usersRepoistory.findUserByAge(age);
    if(age==null){
        throw new ApiExeption(" Enter an age");
    }return  gAge;
}
}

