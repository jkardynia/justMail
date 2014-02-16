package pl.deltacore.justMail.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.deltacore.justMail.core.service.GroupsServiceImpl;
import pl.deltacore.justMail.core.service.api.GroupsService;

@Configuration
public class CoreConfig {

	@Bean
	public GroupsService createGroupsService(){
		return new GroupsServiceImpl();
	}
}
