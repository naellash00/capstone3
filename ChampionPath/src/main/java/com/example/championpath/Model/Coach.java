package com.example.championpath.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "age >= 18")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "full name cannot be empty")
    @Size(min = 5, message = "full name cannot be less than 5 letters")
    @Column(columnDefinition = "varchar(30) not null")
    private String fullName;

    @NotNull(message = "age cannot be empty")
    @Min(value = 18, message = "age cannot be less than 18")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "city cannot be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String city;

    @NotEmpty(message = "phone number cannot be empty")
    @Size(min = 10, max = 10, message = "phone number must be 10 digits")
    @Pattern(regexp = "^05\\d+$", message = "phone number must start with '05'")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "enter a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "sport discipline cannot be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String sportDiscipline;

    @NotEmpty(message = "license cannot be empty")
    @Column(columnDefinition = "varchar(30) not null unique") // check correct length
    private String license;

    @Future(message = "end date must be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate licenseEndDate;

//    //PERSIST --> to allow saving new athletes.
//    //MERGE --> to allow updating existing athletes.
//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "coach")
//    private Set<Athlete> athlete;

    // ====================GETTERS AND SETTERS====================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "full name cannot be empty") @Size(min = 5, message = "full name cannot be less than 5 letters") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty(message = "full name cannot be empty") @Size(min = 5, message = "full name cannot be less than 5 letters") String fullName) {
        this.fullName = fullName;
    }

    public @NotNull(message = "age cannot be empty") @Min(value = 18, message = "age cannot be less than 18") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "age cannot be empty") @Min(value = 18, message = "age cannot be less than 18") Integer age) {
        this.age = age;
    }

    public @NotEmpty(message = "city cannot be empty") String getCity() {
        return city;
    }

    public void setCity(@NotEmpty(message = "city cannot be empty") String city) {
        this.city = city;
    }

    public @NotEmpty(message = "phone number cannot be empty") @Size(min = 10, max = 10, message = "phone number must be 10 digits") @Pattern(regexp = "^05\\d+$", message = "phone number must start with '05'") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotEmpty(message = "phone number cannot be empty") @Size(min = 10, max = 10, message = "phone number must be 10 digits") @Pattern(regexp = "^05\\d+$", message = "phone number must start with '05'") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotEmpty(message = "email cannot be empty") @Email(message = "enter a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "email cannot be empty") @Email(message = "enter a valid email") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "sport discipline cannot be empty") String getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(@NotEmpty(message = "sport discipline cannot be empty") String sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    public @NotEmpty(message = "license cannot be empty") String getLicense() {
        return license;
    }

    public void setLicense(@NotEmpty(message = "license cannot be empty") String license) {
        this.license = license;
    }

    public @Future(message = "end date must be in the future") LocalDate getLicenseEndDate() {
        return licenseEndDate;
    }

    public void setLicenseEndDate(@Future(message = "end date must be in the future") LocalDate licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }
}
