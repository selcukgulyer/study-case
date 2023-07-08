package com.example.studycaseexample.controller.response;

import com.example.studycaseexample.entities.Expense;
import com.example.studycaseexample.entities.User;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateExpenseResponse {
    private int id;
    private String name;
    private LocalDate createdDate;
    private double price;



    public static CreateExpenseResponse from(Expense expense){
        return new CreateExpenseResponse(
                expense.getId(),
                expense.getName(),
                expense.getCreatedDate(),
                expense.getPrice()
        );

    }

    public static List<CreateExpenseResponse> expenseResponseList(List<Expense> expenses){
        return expenses.stream()
                .map(expense -> CreateExpenseResponse.from(expense))
                .collect(Collectors.toList());
    }

}
