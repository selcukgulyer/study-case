package com.example.studycaseexample.controller;

import com.example.studycaseexample.controller.request.*;
import com.example.studycaseexample.controller.response.CreateExpenseResponse;
import com.example.studycaseexample.controller.response.ExpenseResponse;
import com.example.studycaseexample.controller.response.UserResponse;
import com.example.studycaseexample.controller.response.UserUpdateResponse;
import com.example.studycaseexample.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/expense")
@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<CreateExpenseResponse> createExpense(@RequestBody CreateExpenseRequest request) {
        System.out.println(request.getUser());
        return new ResponseEntity<>(expenseService.createExpense(request), HttpStatus.CREATED);
    }

    @GetMapping("/gunlukmasraf/{id}")
    public ResponseEntity<List<ExpenseResponse>> gunlukMasraf(DayExpenseRequest request,@PathVariable int id){
        System.out.println(request.getEndDate());
        System.out.println(request.getStartDate());

        return new ResponseEntity<>(expenseService.gunlukMasraf(request.getStartDate(),request.getEndDate(), id),HttpStatus.OK);
    }

    @GetMapping("/gunlukmasraffiyat/{id}")
    public ResponseEntity<Double> gunlukMasrafFiyati(DayExpenseRequest request,@PathVariable int id){
        return new ResponseEntity<>(expenseService.gunlukMasrafFiyati(request.getStartDate(),request.getEndDate(),id),HttpStatus.OK);
    }
//! Todo :Yapılacak
    @GetMapping("/aylikmasraf/{id}")
    public ResponseEntity<List<ExpenseResponse>> aylikMasraf(@RequestBody  MonthExpenseRequest request,@PathVariable int id){

        System.out.println(request);
        return new ResponseEntity<>(expenseService.aylikMasraf(request.getStartDate(),request.getEndDate(),id),HttpStatus.OK);
    }

    @GetMapping("/aylikmasraffiyat/{id}")
    public ResponseEntity<Double> aylikMasrafFiyat(@RequestBody MonthExpenseRequest request,@PathVariable int id){
        return new ResponseEntity<>(expenseService.aylikMasrafFiyat(request.getStartDate(),request.getEndDate(),id),HttpStatus.OK);
    }
    //! Todo :Yapılacak
    @GetMapping("/haftalikmasraf/{id}")
    public ResponseEntity<List<ExpenseResponse>> haftalikMasraf(@RequestBody WeekExpenseRequest request, @PathVariable  int id){
        return new ResponseEntity<>(expenseService.haftalikMasraf(request.getStartDate(),request.getEndDate(),id),HttpStatus.OK);
    }
    @GetMapping("/haftalikmasraffiyat/{id}")
    public ResponseEntity<Double> haftalikMasrafFiyat(@RequestBody WeekExpenseRequest request,@PathVariable  int id){
        return new ResponseEntity<>(expenseService.haftalikMasrafFiyat(request.getStartDate(),request.getEndDate(),id),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(@PathVariable int id, @RequestBody UpdateExpenseRequest req) {
        return new ResponseEntity<>(expenseService.updateExpense(id, req),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseResponse>> getAll() {
        return new ResponseEntity<>(expenseService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getByIdExpense(@PathVariable int id) {
        return new ResponseEntity<>(expenseService.getByIdExpense(id),HttpStatus.OK);
    }

}
