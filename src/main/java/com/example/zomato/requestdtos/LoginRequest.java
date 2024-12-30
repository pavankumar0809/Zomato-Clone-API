package com.example.zomato.requestdtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.IMessage;

@Getter
@Setter
public class LoginRequest {
    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(gmail|googlemail)\\.com$")
    private String email;
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
