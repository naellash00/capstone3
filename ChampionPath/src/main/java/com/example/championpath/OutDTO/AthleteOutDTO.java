package com.example.championpath.OutDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AthleteOutDTO {

    private String fullName;

    private String phoneNumber;

    private String email;

    private Integer age;

    private String gender;

    private String city;

    private String sportName;
}
