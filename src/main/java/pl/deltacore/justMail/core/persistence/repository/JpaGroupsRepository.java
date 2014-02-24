package pl.deltacore.justMail.core.persistence.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import pl.deltacore.justMail.core.dto.GroupResponse;
import pl.deltacore.justMail.core.dto.MailTemplateResponse;
import pl.deltacore.justMail.core.persistence.entity.Group;
import pl.deltacore.justMail.core.persistence.repository.api.GroupsRepository;

@Repository
public class JpaGroupsRepository extends JpaBaseRepository<Group> implements GroupsRepository{

	@SuppressWarnings("unchecked")
	public List<GroupResponse> getAllGroups() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("select new pl.deltacore.justMail.core.dto.GroupResponse(g.id, g.name) from Group g")
				.setReadOnly(true)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MailTemplateResponse> getMailTemplatesFromGroup(Long id){
		return sessionFactory
				.getCurrentSession()
				.createQuery("select new pl.deltacore.justMail.core.dto.MailTemplateResponse(mt.id, mt.title, mt.authorName) "
						+ "from Group g, MailTemplate mt "
						+ "where g.id=" + id)
				.setReadOnly(true)
				.list();
	}

	public Group getGroup(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.setDefaultReadOnly(true);
		
		Group group = load(id);
		
		session.setDefaultReadOnly(false);
		
		return group;
	}

	public void updateGroup(Long id, String name) {
		Group group = load(id);
		
		group.setName(name);
		
		save(group);
	}

	public Group createGroup(String name) {
		Group group = new Group();
		
		group.setName(name);
		
		save(group);
		
		return group;
	}
}
