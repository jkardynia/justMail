package pl.deltacore.justMail.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.dto.MailTemplateResponse;
import pl.deltacore.justMail.core.persistence.repository.api.GroupsRepository;
import pl.deltacore.justMail.core.service.api.GroupsService;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService{

	@Autowired
    private GroupsRepository groupsRepository;
	
	public List<GroupResponse> getAllGroups() {
		return groupsRepository.getAllGroups();
	}

	public List<MailTemplateResponse> getMailTemplatesFromGroup(String id) {
		return groupsRepository.getMailTemplatesFromGroup(Long.parseLong(id));
	}

	public GroupResponse getGroup(String id) {
		return new GroupResponse(groupsRepository.getGroup(Long.parseLong(id)));
	}

	public void updateGroup(String id, String name) {
		groupsRepository.updateGroup(Long.parseLong(id), name);
	}

	public GroupResponse createGroup(String name) {
		return new GroupResponse(groupsRepository.createGroup(name));
	}

	public void deleteGroup(String id) {
		groupsRepository.delete(Long.parseLong(id));
	}

}
