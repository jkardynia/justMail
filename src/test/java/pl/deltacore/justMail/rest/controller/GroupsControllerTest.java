package pl.deltacore.justMail.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import pl.deltacore.justMail.core.service.api.GroupsService;
import pl.deltacore.justMail.rest.controller.fixture.RestDataFixtures;

public class GroupsControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	GroupsController controller;

	@Mock
	GroupsService groupsService;

	@Before
	public void setup() {
	  MockitoAnnotations.initMocks(this);

	  this.mockMvc = standaloneSetup(controller)
	            .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}
	
	@Test
	public void thatViewGroupUsesHttpOK() throws Exception {

		when(groupsService.getAllGroups()).thenReturn(RestDataFixtures.getAllGroups());

		this.mockMvc.perform(
	            get("/groups")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	  }
	
	@Test
	public void thatViewGroupsRendersCorrectly() throws Exception {

	    when(groupsService.getAllGroups()).thenReturn(RestDataFixtures.getAllGroups());
	
	    this.mockMvc.perform(
	            get("/groups")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.items['id']").value(1))
	            .andExpect(jsonPath("$.name").value("grupa1"));
	}
}
