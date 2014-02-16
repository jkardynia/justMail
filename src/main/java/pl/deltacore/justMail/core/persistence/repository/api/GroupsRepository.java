package pl.deltacore.justMail.core.persistence.repository.api;

import java.util.List;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.dto.MailTemplateResponse;
import pl.deltacore.justMail.core.persistence.entity.Group;

public interface GroupsRepository {
	public List<GroupResponse> getAllGroups();
	public List<MailTemplateResponse> getMailTemplatesFromGroup(Long id);
	public Group getGroup(Long id);
	public void updateGroup(Long id, String name);
	public Group createGroup(String name);
	public void delete(Long id);
}
