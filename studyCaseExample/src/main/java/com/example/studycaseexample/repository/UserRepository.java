package com.example.studycaseexample.repository;

import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.entities.Expense;
import com.example.studycaseexample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


}
