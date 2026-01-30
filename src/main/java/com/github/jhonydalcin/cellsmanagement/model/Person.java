package com.github.jhonydalcin.cellsmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{general.attribute.blank}")
    @Size(min = 3, message = "{person.name.size}")
    private String name;

    @NotBlank(message = "{general.attribute.blank}")
    @Size(min = 11, max = 11, message = "{person.cpf.size}")
    private String cpf;

    @NotBlank(message = "{general.attribute.blank}")
    @Past(message = "{person.birthdate.past}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @NotBlank(message = "{general.attribute.blank}")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "{general.attribute.blank}")
    @Enumerated(EnumType.STRING)
    private Marital_Status maritalStatus;

    private Integer numberOfChildren;

    @NotBlank(message = "{general.attribute.blank}")
    private String phoneNumber;

    @NotBlank(message = "{general.attribute.blank}")
    @Email(message = "{person.email.valid}")
    private String email;

}
