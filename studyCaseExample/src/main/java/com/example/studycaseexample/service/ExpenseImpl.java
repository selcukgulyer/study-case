package com.example.studycaseexample.service;

import com.example.studycaseexample.controller.request.CreateExpenseRequest;
import com.example.studycaseexample.controller.request.UpdateExpenseRequest;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.ExpenseResponse;
import com.example.studycaseexample.entities.Expense;
import com.example.studycaseexample.exception.AsgDataNotFoundException;
import com.example.studycaseexample.exception.ExceptionType;
import com.example.studycaseexample.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    @Override
    public CreateExpenseResponse createExpense(CreateExpenseRequest request) {
        userService.getByUser(request.getUser().getId());
        Expense expense = new Expense(
                request.getId(),
                request.getName(),
                LocalDate.now(),
                request.getPrice(),
                request.getUser()
        );


        expenseRepository.save(expense);

        return CreateExpenseResponse.from(expense);


    }

    @Override
    public List<ExpenseResponse> gunlukMasraf(LocalDate startDate, LocalDate endDate, int id) {

        List<Expense> responses = expenseRepository.getExpensesBetweenDates(startDate, endDate, id);

        return ExpenseResponse.responseList(responses);
    }

    @Override
    public Double gunlukMasrafFiyati(LocalDate startDate, LocalDate endDate, int id) {
        List<Expense> responses = expenseRepository.getExpensesBetweenDates(startDate, endDate, id);
        Double count = 0.0;
        for (Expense response : responses) {
            count = count + response.getPrice();
        }

        return count;
    }

    @Override
    public List<ExpenseResponse> aylikMasraf(LocalDate startDate, LocalDate endDate, int id) {

        List<Expense> responses = expenseRepository.getExpensesMonthBetweenDates(startDate, endDate, id);
        return ExpenseResponse.responseList(responses);
    }

    @Override
    public Double aylikMasrafFiyat(LocalDate startDate, LocalDate endDate, int id) {
        List<Expense> responses = expenseRepository.getExpensesMonthBetweenDates(startDate, endDate, id);
        Double count = 0.0;
        for (Expense response : responses) {
            count = count + response.getPrice();
        }

        return count;
    }

    @Override
    public List<ExpenseResponse> haftalikMasraf(LocalDate startDate, LocalDate endDate, int id) {
        List<Expense> responses = expenseRepository.getExpensesWeekBetweenDates(startDate, endDate, id);
        return ExpenseResponse.responseList(responses);
    }

    @Override
    public Double haftalikMasrafFiyat(LocalDate startDate, LocalDate endDate, int id) {
        List<Expense> responses = expenseRepository.getExpensesWeekBetweenDates(startDate, endDate, id);
        Double count = 0.0;
        for (Expense response : responses) {
            count = count + response.getPrice();
        }

        return count;
    }

    @Override
    public void deleteExpense(int id) {
        getByExpense(id);
        expenseRepository.deleteById(id);
    }

    @Override
    public ExpenseResponse updateExpense(int id, UpdateExpenseRequest req) {
        Expense byExpense = getByExpense(id);
        Expense expense = new Expense(id, req.getName(), byExpense.getCreatedDate(), req.getPrice(), byExpense.getUser());
        expenseRepository.save(expense);
        return ExpenseResponse.from(expense);
    }

    public Expense getByExpense(int id) {
        Optional<Expense> expenseResponse = expenseRepository.findById(id);
        if (expenseResponse.isPresent()) {
            System.out.println(expenseResponse);
            return expenseResponse.get();
        }
        throw new AsgDataNotFoundException(ExceptionType.EXPENSE_DATA_NOT_FOUND);
    }

    @Override
    public List<ExpenseResponse> getAll() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(expense -> ExpenseResponse.from(expense))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseResponse getByIdExpense(int id) {
        Optional<Expense> expenseResponse = expenseRepository.findById(id);
        if (expenseResponse.isPresent()) {
            Expense expense = new Expense(
                    expenseResponse.get().getId(),
                    expenseResponse.get().getName(),
                    expenseResponse.get().getCreatedDate(),
                    expenseResponse.get().getPrice(),
                    expenseResponse.get().getUser()
            );
            return ExpenseResponse.from(expense);
        }
        throw new AsgDataNotFoundException(ExceptionType.EXPENSE_DATA_NOT_FOUND);
    }
}
