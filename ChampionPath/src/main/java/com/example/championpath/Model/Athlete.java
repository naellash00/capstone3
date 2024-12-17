package com.example.championpath.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Check;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Check(constraints = "(char_length(fullName) > 5) and (char_length(phoneNumber) = 10) and (age >= 13)")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "full name cannot be empty")
    @Size(min = 5, message = "full name cannot be less than 5 letters")
    @Column(columnDefinition = "varchar(30) not null")
    private String fullName;

    @NotEmpty(message = "phone number cannot be empty")
    @Size(min = 10, max = 10, message = "phone number must be 10 digits")
    @Pattern(regexp = "^05\\d+$", message = "phone number must start with '05'")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "enter a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotNull(message = "age cannot be empty")
    @Min(value = 13, message = "age cannot be less than 13")
    @Column(columnDefinition = "int not null")
    private Integer age;

//    @ManyToOne
//    @JsonIgnore
//    private Coach coach;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // will amke athlete id PK and FK in athleteProfile
    private AthleteProfile athleteProfile;

    // ====================GETTERS AND SETTERS====================
}
