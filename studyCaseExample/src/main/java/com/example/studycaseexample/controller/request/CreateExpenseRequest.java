package com.example.studycaseexample.controller.request;

import com.example.studycaseexample.entities.User;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpenseRequest {
    private int id;
    private String name;
    private LocalDate createdDate= LocalDate.now();
    private double price;
    private User user;

}
