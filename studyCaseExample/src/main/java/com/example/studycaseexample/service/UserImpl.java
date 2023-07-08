package com.example.studycaseexample.service;

import com.example.studycaseexample.controller.request.CreateUserRequest;
import com.example.studycaseexample.controller.request.UpdateUserRequest;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.UserResponse;
import com.example.studycaseexample.controller.response.UserUpdateResponse;
import com.example.studycaseexample.entities.Expense;
import com.example.studycaseexample.entities.User;
import com.example.studycaseexample.exception.AsgDataNotFoundException;
import com.example.studycaseexample.exception.ExceptionType;
import com.example.studycaseexample.repository.ExpenseRepository;
import com.example.studycaseexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService{

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    @Override
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User(
                request.getId(),
                request.getName(),
                request.getLastName(),
                request.getBirth(),
                request.getAge(),
                new ArrayList<>()
        );

        userRepository.save(user);

        return UserResponse.from(user);
    }

    @Override
    public void deleteUser(int id) {
        getByUser(id);
        userRepository.deleteById(id);
    }

    public User getByUser(int id) {
        Optional<User> userResponse = userRepository.findById(id);
        if (userResponse.isPresent()) {
            System.out.println(userResponse);
            return userResponse.get();
        }
        throw new AsgDataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND);
    }

    @Override
    public UserUpdateResponse updateUser(int id, UpdateUserRequest req) {
        User byUser = getByUser(id);
        User user = new User(id,req.getName(), req.getLastName(), req.getBirth(), req.getAge(), byUser.getExpenses());
        userRepository.save(user);
        return UserUpdateResponse.from(user);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> user = userRepository.findAll();
        return user.stream()
                .map(user1 -> UserResponse.from(user1))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getByIdUser(int id) {
        Optional<User> userResponse = userRepository.findById(id);
        if (userResponse.isPresent()) {
            User user = new User(
                    userResponse.get().getId(),
                    userResponse.get().getName(),
                    userResponse.get().getLastName(),
                    userResponse.get().getBirth(),
                    userResponse.get().getAge(),
                    userResponse.get().getExpenses()
            );
            return UserResponse.from(user);
        }
        throw new AsgDataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND);
    }

    @Override
    public List<CreateExpenseResponse> getExpense(int id) {
           List<Expense> responses= expenseRepository.getExpensesById(id);

            return  CreateExpenseResponse.expenseResponseList(responses);
    }
}
