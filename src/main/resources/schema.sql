drop table if exists groups;

-- Tables
create table groups (
	id bigint auto_increment, 
	name varchar(255), 
	primary key (id)
);

drop table if exists mail_templates;

create table mail_templates (
	id bigint auto_increment, 
	title varchar(255),
	author_name varchar(255),
	groups_id bigint,
	PRIMARY KEY (id),
	FOREIGN KEY (groups_id) REFERENCES groups(id)
);

drop table if exists mail_content;

create table mail_content (
	id bigint auto_increment, 
	name varchar(255),
	content_type ENUM('header', 'body', 'footer'),
	mail_templates_id bigint,
	PRIMARY KEY (id),
	FOREIGN KEY (mail_templates_id) REFERENCES mail_templates(id)
);

-- Data
insert into groups (id, name) values (1, 'PizzaHut');
insert into mail_templates (id, title, author_name, groups_id) values (1, 'Mejl swiąteczny', 'Firma uslugowa J&J&J', 1);
insert into mail_content (name, content_type, mail_templates_id) values ('Zyczenia', 'body', 1);
