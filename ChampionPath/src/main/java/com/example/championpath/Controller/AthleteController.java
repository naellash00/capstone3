package com.example.championpath.Controller;
import com.example.championpath.Api.ApiResponse;
import com.example.championpath.Model.Athlete;
import com.example.championpath.Service.AthleteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/athlete")
//@AllArgsConstructor
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllAthletes(){
        return ResponseEntity.status(200).body(athleteService.getAllAthletes());
    }

    @PostMapping("/add")
    public ResponseEntity addAthlete(@RequestBody @Valid Athlete athlete){
        athleteService.addAthlete(athlete);
        return ResponseEntity.status(200).body(new ApiResponse("Athlete Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAthlete(@PathVariable Integer id, @RequestBody @Valid Athlete athlete){
        athleteService.updateAthlete(id, athlete);
        return ResponseEntity.status(200).body(new ApiResponse("Athlete Updated Successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAthlete(@PathVariable Integer id){
        athleteService.deleteAthlete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Athlete Deleted Successfully"));
    }

}
