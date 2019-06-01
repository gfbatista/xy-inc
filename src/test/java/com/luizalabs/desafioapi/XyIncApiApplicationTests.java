package com.luizalabs.desafioapi;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.luizalabs.desafioapi.controller.PoiController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class XyIncApiApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private PoiController poiController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(poiController).build();
	}
		
	@Test
	public void testGetMapping() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .get("/poi")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void testGetMappingParameters() throws Exception
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .get("/poi/proximidade")
	      .param("x", "10")
	      .param("y", "20")
	      .param("d", "10")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void testPostMapping() throws Exception {
		JSONObject json = new JSONObject();
		json.put("id", 1);
		json.put("nome", "teste");
		json.put("coordenadaX", 0);
		json.put("coordenadaY", 0);

			
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/poi")
				.contentType(MediaType.APPLICATION_JSON).content(json.toString())
				)
	      .andDo(print())
	      .andExpect(status().isCreated());
	}
	
}
