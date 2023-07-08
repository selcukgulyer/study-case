package com.example.studycaseexample.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthExpenseRequest {
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = LocalDate.now();
}
