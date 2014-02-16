package pl.deltacore.justMail.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.dto.MailTemplateResponse;
import pl.deltacore.justMail.core.service.api.GroupsService;

@RestController
@RequestMapping(value="/groups")
public class GroupsController {
	
	@Autowired
	GroupsService groupsService;
	
	@RequestMapping(method = RequestMethod.GET, value={"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<GroupResponse> list() {

    	return groupsService.getAllGroups();
    } 
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GroupResponse> getGroup(@PathVariable String id) {
		GroupResponse group = groupsService.getGroup(id);
		
		if (group.isEmpty()) {
            return new ResponseEntity<GroupResponse>(HttpStatus.NOT_FOUND);
        }
		
    	return new ResponseEntity<GroupResponse>(group, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateGroup(@PathVariable String id, 
    		@RequestParam String name) {

    	groupsService.updateGroup(id, name);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value={"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public GroupResponse createGroup(@RequestParam String name) {

    	return groupsService.createGroup(name);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGroup(@PathVariable String id) {

    	groupsService.deleteGroup(id);
    }
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}/mail-templates")
    @ResponseStatus(HttpStatus.OK)
    public List<MailTemplateResponse> getMailTemplates(@PathVariable String id) {

    	return groupsService.getMailTemplatesFromGroup(id);
    } 
}
