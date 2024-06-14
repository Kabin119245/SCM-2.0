package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Username is required")
    @Size(min =3, message = "Minimum 3 Characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Size(min = 5, message = "Minimum 5 Characters")
    @Email(message= "Invalid Email Address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Minimum 6 Characters")
    private String password;

    @NotBlank(message = "About is required")
    @Size(min = 10, message = "Minimum 10 Characters")
    private String about;

    @NotBlank(message = "Phone Number is required")
    @Size(min = 10, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;


}
