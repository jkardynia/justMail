package pl.deltacore.justMail.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.deltacore.justMail.core.persistence.repository.api.GroupsRepository;
import pl.deltacore.justMail.core.service.api.MailsService;

@Service
@Transactional
public class MailsServiceImpl implements MailsService{

	@Autowired
    private GroupsRepository groupsRepository;
	
}
