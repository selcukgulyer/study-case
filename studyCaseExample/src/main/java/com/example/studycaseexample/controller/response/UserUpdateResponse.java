package com.example.studycaseexample.controller.response;

import com.example.studycaseexample.entities.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateResponse {
    private String name;
    private String lastName;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birth;
    private int age;

    public static UserUpdateResponse from(User user) {
        return new UserUpdateResponse(
                user.getName(),
                user.getLastName(),
                user.getBirth(),
                user.getAge()
        );
    }
}
