package com.example.championpath.Repository;

import com.example.championpath.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    Coach findCoachById(Integer id);
}
