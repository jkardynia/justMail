package pl.deltacore.justMail.core.persistence.repository;

import org.springframework.stereotype.Repository;

import pl.deltacore.justMail.core.persistence.entity.MailTemplate;
import pl.deltacore.justMail.core.persistence.repository.api.MailsRepository;

@Repository
public class JpaMailsRepository extends JpaBaseRepository<MailTemplate> implements MailsRepository{

}
