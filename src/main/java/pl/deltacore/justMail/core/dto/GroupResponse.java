package pl.deltacore.justMail.core.dto;

import pl.deltacore.justMail.core.persistence.entity.Group;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GroupResponse {
	public Long id;
	public String name;
	private boolean isEmpty;
	
	public GroupResponse(Group group){
		if(null == group){
			isEmpty = true;
		}else{
			this.id = group.getId();
			this.name = group.getName();
		}
	}
	
	public GroupResponse(Long id, String name){
		this.id = id;
		this.name = name;
	}
	
	@JsonIgnore
	public boolean isEmpty(){
		return isEmpty;
	}
}
