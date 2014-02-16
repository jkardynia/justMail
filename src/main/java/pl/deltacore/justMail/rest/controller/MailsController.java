package pl.deltacore.justMail.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.service.api.GroupsService;

@RestController
public class MailsController {
	
	@Autowired
	GroupsService groupsService;
	
	@RequestMapping(method = RequestMethod.GET, value="/mails")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupResponse> list() {

    	return groupsService.getAllGroups();
    } 
}
