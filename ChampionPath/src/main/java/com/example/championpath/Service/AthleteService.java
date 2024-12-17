package com.example.championpath.Service;

import com.example.championpath.Api.ApiException;
import com.example.championpath.InDTO.AthleteDTO;
import com.example.championpath.Model.Athlete;
import com.example.championpath.Model.AthleteProfile;
import com.example.championpath.OutDTO.AthleteOutDTO;
import com.example.championpath.Repository.AthleteProfileRepository;
import com.example.championpath.Repository.AthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final AthleteProfileRepository athleteProfileRepository;

    public AthleteService(AthleteRepository athleteRepository, AthleteProfileRepository athleteProfileRepository) {
        this.athleteRepository = athleteRepository;
        this.athleteProfileRepository = athleteProfileRepository;
    }

//    public List<Athlete> getAllAthletes(){
//        return athleteRepository.findAll();
//    }

//    public List<AthleteOutDTO> getAllAthletes(){
//        List<Athlete> athletes = athleteRepository.findAll();
//        List<AthleteOutDTO> athleteOutDTOS = new ArrayList<>();
//        for(Athlete a : athletes){
//            AthleteOutDTO athleteOutDTO = new AthleteOutDTO(a.getFullName(), a.getPhoneNumber(), a.getEmail(), a.getAge(), )
//        }
//    }

    public void addAthlete(Athlete athlete){
        athleteRepository.save(athlete);
    }

    public void updateAthlete(Integer id, Athlete athlete){
        Athlete oldAthlete = athleteRepository.findAthleteById(id);
        if(oldAthlete==null){
            throw new ApiException("athlete not found");
        }
        oldAthlete.setFullName(athlete.getFullName());
        oldAthlete.setPhoneNumber(athlete.getPhoneNumber());
        oldAthlete.setEmail(athlete.getEmail());
        oldAthlete.setAge(athlete.getAge());
        athleteRepository.save(oldAthlete);
    }

    public void deleteAthlete(Integer id){
        Athlete athlete = athleteRepository.findAthleteById(id);
        if(athlete == null){
            throw  new ApiException("athlete not found");
        }
        AthleteProfile athleteProfile = athleteProfileRepository.findAthleteProfileById(athlete.getId());
        athlete.setAthleteProfile(null);
        athleteProfileRepository.delete(athleteProfile);
        athleteRepository.delete(athlete);
    }

    //public void requestCoach
}






