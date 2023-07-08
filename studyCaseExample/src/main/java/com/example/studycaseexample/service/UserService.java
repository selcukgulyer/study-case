package com.example.studycaseexample.service;

import com.example.studycaseexample.controller.request.CreateUserRequest;
import com.example.studycaseexample.controller.request.UpdateUserRequest;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.UserResponse;
import com.example.studycaseexample.controller.response.UserUpdateResponse;
import com.example.studycaseexample.entities.User;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    User getByUser(int id);

    void deleteUser(int id);

    UserUpdateResponse updateUser(int id, UpdateUserRequest req);

    List<UserResponse> getAll();

    UserResponse getByIdUser(int id);

    List<CreateExpenseResponse> getExpense(int id);
}
