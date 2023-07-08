package com.example.studycaseexample.controller.response;

import com.example.studycaseexample.entities.Expense;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExpenseResponse {
    private int id;
    private String name;
    private LocalDate createdDate;
    private double price;

    public static ExpenseResponse from(Expense expense){
        return  new ExpenseResponse(
                expense.getId(),
                expense.getName(),
                expense.getCreatedDate(),
                expense.getPrice()
        );
    }

    public static List<ExpenseResponse> responseList(List<Expense> expenses){
        return expenses.stream()
                .map(expense -> ExpenseResponse.from(expense))
                .collect(Collectors.toList());
    }

}
