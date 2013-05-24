package com.github.springmvcjapid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
@WebAppConfiguration
@ContextConfiguration(locations="/META-INF/application-context.xml")
public class ViewIntegrationTest extends AbstractJUnit4SpringContextTests{
	@Autowired
    private ApplicationContext applicationContext;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	  
	@Before
	public void setup() {
	  this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testSomething() throws Exception{
		Assert.assertNotNull("application context should not be null", applicationContext);
		this.mockMvc.perform(get("/foo").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"name\":\"Lee\"}"))
        .andExpect(jsonPath("$.name").value("Lee"));
		
	}
    

}
