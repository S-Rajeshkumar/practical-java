package com.course.practicaljava.api.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.elasticsearch.client.indexlifecycle.DeleteAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.entity.Car;
import com.course.practicaljava.service.CarService;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Delete;

@RestController
@RequestMapping(value = "/api/car/v1")
public class CarApi {

	private static final Logger LOG = LoggerFactory.getLogger(CarApi.class);
	@Autowired
	private CarService carService;

	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Car Random() {
		
		return carService.generateCar();
		
	}

	@PostMapping(value = "/echo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String echo(@RequestBody Car car) {
		
		LOG.info("Car is {}", car);
		return car.toString();
		
	}
	
	@GetMapping(value = "/randomCars", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> randomCars(){
		
		List<Car> randomCars = new ArrayList<Car>();
		
		for(int i=0; i<ThreadLocalRandom.current().nextInt(1, 10); i++) {
			randomCars.add(carService.generateCar());
		}
		
		return randomCars;
	}
	
	@PostMapping(value = "/delete", consumes = MediaType.ALL_VALUE)
	public String docIds(@RequestParam List<String> ids){
		JestClient jestClient = null;
		try {
			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
			jestClient = factory.getObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Bulk.Builder builder = new Bulk.Builder();
			for(String id:ids) {
				builder.addAction(new Delete.Builder(id).index("practical-java").type("_doc").build());
			}
			Bulk bulk = builder.build();
			JestResult jestResult = jestClient.execute(bulk);
			
			if(!jestResult.isSucceeded()) {
				LOG.info("Failed to delete documents {}", jestResult);
			}
			else {
				LOG.info("Documents Deleted Successfully");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Deletion Successful";
	}
}
