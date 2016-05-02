package com.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.weather.controller.WeatherController;
import com.weather.service.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {WeatherWebappApplication.class, TestContext.class, WeatherController.class})
@WebAppConfiguration
public class WeatherWebappApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	@Autowired
	private WeatherService weatherService;


	@Before
	  public void setUp() throws Exception {

	    MockitoAnnotations.initMocks(this);
	    WeatherController instance = new WeatherController();
	    ReflectionTestUtils.setField(instance, "weatherService", weatherService);

	    mockMvc = MockMvcBuilders.standaloneSetup(instance).setViewResolvers(new StandaloneMvcTestViewResolver()).build();
	  }
	
	  @Test
	  public void testWeatherHome() throws Exception {

		  mockMvc.perform(get("/weather"))
          .andExpect(status().isOk());
      }
	  
	  @Test
	  public void testWeatherResult() throws Exception {

		  mockMvc.perform(get("/weather?location=Sydney,Au"))
          .andExpect(status().isOk());
      }

}
