package com.example.authuser.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView {
        public static interface RegistrationPost {}
        public static interface UserPut {}
        public static interface PasswordPut {}
        public static interface ImagePut {}

    }

    private UUID userId;

    @NotBlank(groups = UserView.RegistrationPost.class)
    @Size(min=4, max=50)
    @JsonView(UserView.RegistrationPost.class)  //Username não poderá ser atualizado apenas inserido POST
    private String username;

    @NotBlank
    @Size(min=4, max=50)
    @Email(groups = UserView.RegistrationPost.class)
    @JsonView(UserView.RegistrationPost.class)  // email não poderá ser atualizado Apenas inserido POST
    private String email;

    @NotBlank(groups = {UserView.RegistrationPost.class,UserView.PasswordPut.class})
    @Size(min=6, max=20)
    @JsonView({UserView.RegistrationPost.class,UserView.PasswordPut.class})  // password poderá ser inserido POST. e também Atualizado PUT
    private String password;

    @NotBlank(groups = UserView.PasswordPut.class)
    @JsonView({UserView.PasswordPut.class})
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String cpf;

    @NotBlank(groups = UserView.ImagePut.class)
    @JsonView({UserView.ImagePut.class})     // Só vai atualizar a imagem , não vai aparecer o "campo imagem"
    private String imageUrl;


}
