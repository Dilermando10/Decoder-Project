package com.example.authuser.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
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

    @JsonView(UserView.RegistrationPost.class)  //Username não poderá ser atualizado apenas inserido POST
    private String username;

    @JsonView(UserView.RegistrationPost.class)  // email não poderá ser atualizado Apenas inserido POST
    private String email;

    @JsonView({UserView.RegistrationPost.class,UserView.PasswordPut.class})  // password poderá ser inserido POST. e também Atualizado PUT
    private String password;

    @JsonView({UserView.PasswordPut.class})
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
    private String cpf;

    @JsonView({UserView.ImagePut.class})     // Só vai atualizar a imagem , não vai aparecer o "campo imagem"
    private String imageUrl;


}
