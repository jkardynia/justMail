package pl.deltacore.justMail.rest.controller.fixture;

import java.util.LinkedList;
import java.util.List;

import pl.deltacore.justMail.core.dto.GroupResponse;

public class RestDataFixtures {
	public static List<GroupResponse> getAllGroups(){
		List<GroupResponse> groups = new LinkedList<GroupResponse>();
		
		groups.add(new GroupResponse(1L, "Grupa1"));
		
		return groups;
	}
	
	public static GroupResponse getSingleGroup(){
		return new GroupResponse(1L, "Grupa1");
	}
}
