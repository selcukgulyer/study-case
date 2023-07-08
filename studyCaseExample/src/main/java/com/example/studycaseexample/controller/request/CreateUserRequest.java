package com.example.studycaseexample.controller.request;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private int id;
    private String name;
    private String lastName;
    private LocalDate birth;
    private int age;


   /* public static User deneme(CreateRequest request){
        return new User(
                request.getId(),
                request.getName(),
                request.getLastName(),
                request.getBirth(),
                request.getAge()

        );
    }*/
}