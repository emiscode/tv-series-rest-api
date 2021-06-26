package com.emiscode.series.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emiscode.series.restapi.models.Series;

public interface SeriesRepository extends JpaRepository<Series, Long>{
	
	Series findById(long id);
}
