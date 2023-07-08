package com.example.studycaseexample.service;

import com.example.studycaseexample.controller.request.CreateExpenseRequest;
import com.example.studycaseexample.controller.request.UpdateExpenseRequest;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.ExpenseResponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ExpenseService {
    CreateExpenseResponse createExpense(CreateExpenseRequest request);

    List<ExpenseResponse> gunlukMasraf(LocalDate startDate, LocalDate endDate,int id);

    Double gunlukMasrafFiyati(LocalDate startDate, LocalDate endDate,int id);

    List<ExpenseResponse> aylikMasraf(LocalDate startDate, LocalDate endDate,int id);

    Double aylikMasrafFiyat(LocalDate startDate, LocalDate endDate, int id);

    List<ExpenseResponse> haftalikMasraf(LocalDate startDate, LocalDate endDate,int id);

    Double haftalikMasrafFiyat(LocalDate startDate, LocalDate endDate,int id);

    void deleteExpense(int id);

    ExpenseResponse updateExpense(int id, UpdateExpenseRequest req);

    List<ExpenseResponse> getAll();

    ExpenseResponse getByIdExpense(int id);
}
