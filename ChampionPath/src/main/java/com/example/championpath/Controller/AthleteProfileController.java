package com.example.championpath.Controller;

import com.example.championpath.Api.ApiResponse;
import com.example.championpath.InDTO.AthleteDTO;
import com.example.championpath.Model.AthleteProfile;
import com.example.championpath.Service.AthleteProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/athlete/profile")
@AllArgsConstructor
public class AthleteProfileController {
    private final AthleteProfileService athleteProfileService;

    @GetMapping("/get")
    public ResponseEntity getAllAthleteProfiles(){
        return ResponseEntity.status(200).body(athleteProfileService.getAllAthleteProfiles());
    }

    @PostMapping("/add")
    public ResponseEntity addAthleteProfile(@RequestBody @Valid AthleteDTO athleteDTO){
        athleteProfileService.addAthleteProfile(athleteDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Profile Added Successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAthleteProfile(@RequestBody @Valid AthleteDTO athleteDTO){
        athleteProfileService.updateAthleteProfile(athleteDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Profile Updated Successfully"));
    }
}
