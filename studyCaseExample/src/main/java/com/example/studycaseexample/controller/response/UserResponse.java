package com.example.studycaseexample.controller.response;

import com.example.studycaseexample.entities.Expense;
import com.example.studycaseexample.entities.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {

    private String name;
    private String lastName;
    private LocalDate birth;
    private int age;
    private List<CreateExpenseResponse> expenses;


    public static UserResponse from(User user) {
        return new UserResponse(
                user.getName(),
                user.getLastName(),
                user.getBirth(),
                user.getAge(),
                user.getExpenses().stream().map(CreateExpenseResponse::from).collect(Collectors.toList())
                );
    }
}