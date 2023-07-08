package com.example.studycaseexample.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeekExpenseRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
