package com.emiscode.series.restapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emiscode.series.restapi.models.Series;
import com.emiscode.series.restapi.repository.SeriesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="TV Series REST API")
@CrossOrigin(origins="*")
public class SeriesResource {
	
	@Autowired
	SeriesRepository seriesRepository;
	
	@PostMapping("/series")
	@ApiOperation(value="Creates a new TV Series record")
	public Series createSeries(@RequestBody Series series) {
		return seriesRepository.save(series);
	}
	
	@GetMapping("/series")
	@ApiOperation(value="Returns a list of all available TV Series")
	public List<Series> listSeries() {
		return seriesRepository.findAll();
	}
	
	@GetMapping("/series/{id}")
	@ApiOperation(value="Returns a single TV Series record based on its id as a parameter")
	public Series ListSeriesById(@PathVariable(value="id") long id) {
		return seriesRepository.findById(id);
	}
	
	@PatchMapping("/series")
	@ApiOperation(value="Updates the TV Series record information based on its id in the request body")
	public Series updatePatchSeries(@RequestBody Series series) {
		return seriesRepository.save(series);
	}
	
	@PutMapping("/series")
	@ApiOperation(value="Updates the TV Series record information based on its id in the request body")
	public Series updatePutSeries(@RequestBody Series series) {
		return seriesRepository.save(series);
	}
	
	@DeleteMapping("/series")
	@ApiOperation(value="Deletes a single TV Series record based on its id in the request body")
	public void deleteSeries(@RequestBody Series series) {
		seriesRepository.delete(series);
	}
	
	@DeleteMapping("/series/{id}")
	@ApiOperation(value="Deletes a single TV Series record based on its id as a parameter")
	public void deleteSeriesById(@PathVariable(value="id") long id) {
		seriesRepository.deleteById(id);
	}
}
