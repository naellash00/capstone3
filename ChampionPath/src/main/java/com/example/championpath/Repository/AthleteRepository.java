package com.example.championpath.Repository;
import com.example.championpath.Model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
    Athlete findAthleteById(Integer id);
}
