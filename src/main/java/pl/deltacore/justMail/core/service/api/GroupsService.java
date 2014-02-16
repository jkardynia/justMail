package pl.deltacore.justMail.core.service.api;

import java.util.List;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.dto.MailTemplateResponse;

public interface GroupsService {
	public List<GroupResponse> getAllGroups();
	public GroupResponse getGroup(String id);
	public void updateGroup(String id, String name);
	public GroupResponse createGroup(String name);
	public void deleteGroup(String id);
	public List<MailTemplateResponse> getMailTemplatesFromGroup(String id);
}
