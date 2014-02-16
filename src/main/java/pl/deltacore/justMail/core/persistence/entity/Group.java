package pl.deltacore.justMail.core.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Group {

	@Id
    @Column(name="id")
    @GeneratedValue
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="group", cascade = {CascadeType.REMOVE})
	private Set<MailTemplate> mailTemplates;
	
	public Set<MailTemplate> getMailTemplates() {
		return mailTemplates;
	}

	public void setMailTemplates(Set<MailTemplate> mailTemplates) {
		this.mailTemplates = mailTemplates;
	}

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
}
