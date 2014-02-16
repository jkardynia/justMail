package pl.deltacore.justMail.core.persistence.repository;

import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaBaseRepository<Entity> {
	
	@Autowired
    protected SessionFactory sessionFactory;
	
	private Class<Entity> clazz;
	
	@SuppressWarnings("unchecked")
    public JpaBaseRepository() {
        this.clazz = ((Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
	
	public void save(Entity e) {
		sessionFactory.getCurrentSession().persist(e);
	}

	public void delete(Long id) {
		Entity group = load(id);
		
		sessionFactory.getCurrentSession().delete(group);
	}	
	
	@SuppressWarnings("unchecked")
	public Entity load(Long id) {
		Entity group = (Entity) sessionFactory.getCurrentSession().get(clazz, id);
		
		return group;
	}	
}
