package pl.deltacore.justMail.core.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pl.deltacore.justMail.config.CoreConfig;
import pl.deltacore.justMail.config.HibernateConfig;
import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.persistence.entity.Group;
import pl.deltacore.justMail.core.persistence.repository.api.GroupsRepository;
import pl.deltacore.justMail.core.service.api.GroupsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, HibernateConfig.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class GroupsServiceIntegrationTest {

	@Autowired
	GroupsService service;

	@Autowired
	GroupsRepository groupsRepository;
	
	@Test
	public void thatGroupIsCreated() throws Exception {
		String groupName = "Group-test";
		
		// prepare database
		Long newGroupId = groupsRepository.createGroup(groupName).getId();
		
		// test
		GroupResponse groupRsp = service.getGroup(newGroupId.toString());
		
		assertEquals(groupName, groupRsp.name);
		
	}
}