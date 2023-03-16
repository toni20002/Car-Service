package com.carservice.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class User {
    private Long user_id;
    @NotEmpty(message = "Username field is required!")
    private String username;
    @NotEmpty(message = "Email field is required!")
    private String email;
    @NotEmpty(message = "Password field is required!")
    private String password;
    @NotEmpty(message = "First Name field is required!")
    private String firstName;
    @NotEmpty(message = "Last Name field is required!")
    private String lastName;
    @NotEmpty(message = "PhoneNumber field is required!")
    private String phoneNumber;
    private Timestamp creationTime;
    private String role;
}
