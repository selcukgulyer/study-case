package com.example.studycaseexample.repository;

import com.example.studycaseexample.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
  /*  @Query(value = "SELECT * FROM expenses WHERE created_date, :user_id BETWEEN :startDate AND :endDate ",nativeQuery = true)
    List<Expense>  getExpensesBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,@Param("user_id") int id);*/

    @Query(value = "SELECT * FROM expenses WHERE created_date BETWEEN :startDate AND :endDate AND user_id = :userId", nativeQuery = true)
    List<Expense> getExpensesBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("userId") int userId);


    @Query(value = "SELECT * FROM expenses WHERE created_date BETWEEN :startDate AND :endDate AND user_id = :userId", nativeQuery = true)
    List<Expense> getExpensesMonthBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("userId") int userId);

    @Query(value = "SELECT * FROM expenses WHERE created_date BETWEEN :startDate AND :endDate AND user_id = :userId", nativeQuery = true)
    List<Expense> getExpensesWeekBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("userId") int userId);


    @Query(value = "SELECT * FROM expenses WHERE  user_id = :userId", nativeQuery = true)
    List<Expense> getExpensesById( @Param("userId") int userId);

}
