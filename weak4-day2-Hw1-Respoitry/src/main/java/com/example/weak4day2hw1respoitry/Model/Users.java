package com.example.weak4day2hw1respoitry.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
public class Users {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @NotEmpty(message = "the name cannot be null")
   @Column(columnDefinition = " varchar(20) not null")
   private String name;

   @NotEmpty(message = "The username cannot be null")
   @Column(columnDefinition = " varchar(20) unique  not null")
   @Max(4)
   private String username;

   @NotEmpty(message = "the password cannot be null")
   @Column(columnDefinition = "varchar(20) not null")
   private  String password;

    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = " varchar(20) not null check(role='user' or role='admin')")
   private String role;
    @Email(message = "write valid email")
    @NotEmpty(message = "email can't be empty")
    @Column(columnDefinition = " varchar(20) unique  not null")
   private String email;
    @NotNull(message = "the password cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
   private  Integer   age;
}
