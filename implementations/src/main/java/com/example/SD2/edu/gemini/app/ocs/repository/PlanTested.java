package com.example.SD2.edu.gemini.app.ocs.repository;

import com.example.SD2.edu.gemini.app.ocs.model.AstronomicalDataAdapter;
import com.example.SD2.edu.gemini.app.ocs.model.ImageStar;
import org.springframework.data.repository.CrudRepository;

public interface PlanTested extends CrudRepository<AstronomicalDataAdapter, Integer> {

}
