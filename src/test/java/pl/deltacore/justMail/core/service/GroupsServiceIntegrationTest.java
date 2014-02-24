package pl.deltacore.justMail.core.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.deltacore.justMail.config.CoreConfig;
import pl.deltacore.justMail.config.HibernateConfig;
import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.persistence.repository.api.GroupsRepository;
import pl.deltacore.justMail.core.service.api.GroupsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, HibernateConfig.class})
public class GroupsServiceIntegrationTest {

	@Autowired
	GroupsService service;

	@Autowired
	GroupsRepository groupsRepository;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void thatGroupIsCreated() throws Exception {
		// prepare database
		//begin transaction
		//Group group = groupsRepository.createGroup("nowa grupa");
		
		// test
		GroupResponse groupRsp = service.getGroup("1");//group.getId().toString());
		
		assertEquals("PizzaHut", groupRsp.name);
		
		//rollback transaction
	}
}