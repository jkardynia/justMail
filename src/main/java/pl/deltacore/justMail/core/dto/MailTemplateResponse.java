package pl.deltacore.justMail.core.dto;


public class MailTemplateResponse {

	public Long id;
	public String title;
	public String authorName;
	
	public MailTemplateResponse(Long id, String title, String authorName){
		this.id = id;
		this.title = title;
		this.authorName = authorName;
	}
	
}
