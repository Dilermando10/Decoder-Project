package com.example.authuser.models;

import com.example.authuser.enums.UserStatus;
import com.example.authuser.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)    //TODOS OS ATRIBUTOS QUE NÃO FOREM PRENCHCIDOS ,OU SEJA NULOS, ELE NÃO VAI MOSTRAR
@Entity
@Table(name = "TB_USERS")
public class UserModel extends RepresentationModel<UserModel> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @JsonIgnore                                 // ocultar o passorword
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false,length = 150)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 20)
    private String cpf;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'" )
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'" )
    private LocalDateTime lastUpdateDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserCourseModel> usersCourses;


}