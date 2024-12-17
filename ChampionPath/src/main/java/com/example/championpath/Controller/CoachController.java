package com.example.championpath.Controller;

import com.example.championpath.Api.ApiException;
import com.example.championpath.Api.ApiResponse;
import com.example.championpath.Model.Coach;
import com.example.championpath.Service.CoachService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coach")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllCoaches(){
        return ResponseEntity.status(200).body(coachService.getAllCoaches());
    }

    @PostMapping("/add")
    public ResponseEntity addCoach(@RequestBody @Valid Coach coach){
        coachService.addCoach(coach);
        return ResponseEntity.status(200).body(new ApiResponse("Coach Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoach(@PathVariable Integer id, @RequestBody @Valid Coach coach){
        coachService.updateCoach(id, coach);
        return ResponseEntity.status(200).body(new ApiResponse("Coach Updated Successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoach(@PathVariable Integer id){
        coachService.deleteCoach(id);
        return ResponseEntity.status(200).body(new ApiResponse("Coach Deleted Successfully"));
    }
}





