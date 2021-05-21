
package com.cg.sprintproject.CustomerModule;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.fleetmanagement.customermodule.model.CustomerUnit;
import com.cg.fleetmanagement.customermodule.service.CustomerUnitService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private CustomerUnitService userServiceMock;

	@Test
	public void getAllCustomers_thenStatus200() throws Exception {
		mvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].customerId", is(1)));
	}

	@Test
	public void getCustomerIdStatus202() throws Exception {
		mvc.perform(get("/customers/customer/{cid}", 1)).andExpect(status().is(202));
	}

	List<CustomerUnit> getMockUsers(String condition) {

		CustomerUnit obj2 = new CustomerUnit();
		obj2.setCustomerFirstName("Sharukh");
		obj2.setCustomerLastName("Khan");
		obj2.setCustomerId(1);
		if (condition == "Create") {
			return Arrays.asList(obj2);
		} else if (condition == "Update") {
			return Arrays.asList(obj2);
		}

		else {
			// returns all users
			return Arrays.asList(obj2);
		}
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
