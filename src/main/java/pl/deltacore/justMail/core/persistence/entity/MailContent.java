package pl.deltacore.justMail.core.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.deltacore.justMail.core.domain.TemplateType;

@Entity
@Table(name="mail_contents")
public class MailContent {

	@Id
    @Column(name="id")
    @GeneratedValue
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private TemplateType contentType;
	
	@ManyToOne
	@JoinColumn(name="mail_template_id")
	private MailTemplate mailTemplate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TemplateType getContentType() {
		return contentType;
	}

	public void setContentType(TemplateType contentType) {
		this.contentType = contentType;
	}

	public MailTemplate getMailTemplateId() {
		return mailTemplate;
	}

	public void setMailTemplateId(MailTemplate mailTemplateId) {
		this.mailTemplate = mailTemplateId;
	}
}
