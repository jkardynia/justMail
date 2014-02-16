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
	group_id bigint,
	PRIMARY KEY (id),
	FOREIGN KEY (group_id) REFERENCES groups(id)
);

drop table if exists mail_contents;

create table mail_contents (
	id bigint auto_increment, 
	name varchar(255),
	content_type ENUM('header', 'body', 'footer'),
	mail_template_id bigint,
	PRIMARY KEY (id),
	FOREIGN KEY (mail_template_id) REFERENCES mail_templates(id)
);

-- Data
insert into groups (id, name) values (1, 'PizzaHut');
insert into mail_templates (id, title, author_name, group_id) values (1, 'Mejl swiąteczny', 'Firma uslugowa J&J&J', 1);
insert into mail_contents (name, content_type, mail_template_id) values ('Zyczenia', 'body', 1);
