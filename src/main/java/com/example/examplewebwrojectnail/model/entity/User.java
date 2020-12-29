package com.example.examplewebwrojectnail.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.time.LocalDate.of;

@Entity
@Data
@Builder
//@NoArgsConstructor  //нужна или нет, ведь @Data не генерит такой конструктор
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate DateOfBirth;

    @Column
 //   @Email как это работает
    private String email;

    private List<Role> listRoles;

    public static void main(String[] args) {
        User safia = User.builder()
         .id(1)
         .firstName("Safia")
         .lastName("Safia")
         .DateOfBirth(of(1984, Month.AUGUST,20))
         .email("fsafia-yandex.ru")
        .build();

        System.out.println(safia);


        List<Role> listR = new LinkedList<>();
       Role role1 = Role.builder()
               .id(1)
               .role("ROLE_ADMIN")
               .build();
        Role role2 = Role.builder()
                .id(1)
                .role("ROLE_USER")
                .build();
        listR.add(role1);
        listR.add(role2);
        safia.builder()
            .listRoles(listR)
        .build();

        User a = User.builder()
                .firstName("Amina")
                .lastName("Hapu")
                .email("amina@yandex.ru")
                .listRoles(new ArrayList<>(Arrays.asList(Role.builder().id(1).role("ROLE_ADMIN").build(), Role.builder().id(1).role("ROLE_USER").build()))).build();
//                .listRoles(new ArrayList<>(Arrays.asList(new Role(1, "ROLE_ADMIN"), new Role(2, "ROLE_USER")))).build();
        System.out.println(a);
    }
}
