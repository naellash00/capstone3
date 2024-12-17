package com.example.championpath.Service;

import com.example.championpath.Api.ApiException;
import com.example.championpath.Model.Coach;
import com.example.championpath.Repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllCoaches(){
        return coachRepository.findAll();
    }

    public void addCoach(Coach coach){
        coachRepository.save(coach);
    }

    public void updateCoach(Integer id, Coach coach){
        Coach oldCoach = coachRepository.findCoachById(id);
        if(oldCoach==null){
            throw new ApiException("coach not found");
        }
        oldCoach.setFullName(coach.getFullName());
        oldCoach.setAge(coach.getAge());
        oldCoach.setCity(coach.getCity());
        oldCoach.setPhoneNumber(coach.getPhoneNumber());
        oldCoach.setEmail(coach.getEmail());
        oldCoach.setSportDiscipline(coach.getSportDiscipline());
        oldCoach.setLicense(coach.getLicense());
        oldCoach.setLicenseEndDate(coach.getLicenseEndDate());
        coachRepository.save(oldCoach);
    }

    public void deleteCoach(Integer id){
        Coach coach = coachRepository.findCoachById(id);
        if(coach==null){
            throw new ApiException("coach not found");
        }
        coachRepository.delete(coach);
    }
}


