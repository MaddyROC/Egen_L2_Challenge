package io.egenchallenge.pwtstarter.apiTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import io.egenchallenge.pwtstarter.controller.AController;
import io.egenchallenge.pwtstarter.controller.MController;
import io.egenchallenge.pwtstarter.dao.AlertDao;
import io.egenchallenge.pwtstarter.dao.MetricDao;

public class APITest {
	
	@InjectMocks
	private AController alertC = new AController();
	@InjectMocks
	private MController metricC = new MController();
	@Mock
	MetricDao metricRepoDao = new MetricDao();
	@Mock
	AlertDao alertRepoDao = new AlertDao();
	
	private MockMvc amvc;
	private MockMvc mmvc;
	
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		amvc = MockMvcBuilders.standaloneSetup(alertC).build();
		MockitoAnnotations.initMocks(this);
		mmvc = MockMvcBuilders.standaloneSetup(metricC).build();
	}
	
	
	@Test
	public void MetricReadTest(){
		try {
			mmvc.perform(MockMvcRequestBuilders.get("/metrics/read").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void MetricReadByRangeTest(){
		
		try {
			mmvc.perform(MockMvcRequestBuilders.get("/metrics/readByTimeRange/1499799718221/1499799743322")
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AlertReadTest(){
		try {
			amvc.perform(MockMvcRequestBuilders.get("/alerts/read").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void AlertReadByRangeTest(){
		try {
			amvc.perform(MockMvcRequestBuilders.get("/alerts/readByTimeRange/1499802571384/1499802576407")
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
