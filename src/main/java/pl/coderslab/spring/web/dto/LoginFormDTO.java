package pl.coderslab.spring.web.dto;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginFormDTO {

    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
