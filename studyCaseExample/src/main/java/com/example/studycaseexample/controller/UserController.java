package com.example.studycaseexample.controller;

import com.example.studycaseexample.controller.request.CreateUserRequest;
import com.example.studycaseexample.controller.request.UpdateUserRequest;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.UserResponse;
import com.example.studycaseexample.controller.response.UserUpdateResponse;
import com.example.studycaseexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest req) {
        return new ResponseEntity<>(userService.updateUser(id, req),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @PreAuthorize("USER")
    public ResponseEntity<List<UserResponse>> getAll() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(userService.getByIdUser(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/getAllExpense")
    public ResponseEntity<List<CreateExpenseResponse>> getExpense(@PathVariable int id){
        return new ResponseEntity<>(userService.getExpense(id),HttpStatus.OK);
    }
}
