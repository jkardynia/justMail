package pl.deltacore.justMail.core.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mail_templates")
public class MailTemplate {

	@Id
    @Column(name="id")
    @GeneratedValue
    private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author_name")
	private String authorName;
	
	@OneToMany(mappedBy="mailTemplate", cascade = {CascadeType.REMOVE})
    private Set<MailContent> mailContents;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<MailContent> getMailContents() {
		return mailContents;
	}

	public void setMailContents(Set<MailContent> mailContents) {
		this.mailContents = mailContents;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
