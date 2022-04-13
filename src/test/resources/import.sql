-- Projects
insert into project(id,title,short_description,uploader) values (1,'Project1','Omschrijving1','uploader1');
insert into project(id,title,short_description,uploader) values (2,'Project2','Omschrijving2','uploader2');
insert into project(id,title,short_description,uploader) values (3,'Project3','Omschrijving3','uploader3');
insert into project(id,title,short_description,uploader) values (4,'Project4','Omschrijving4','uploader4');
insert into project(id,title,short_description,uploader) values (5,'Project5','Omschrijving5','uploader5');
insert into project(id,title,short_description,uploader) values (6,'Project6','Omschrijving6','uploader6');
insert into project(id,title,short_description,uploader) values (7,'Project7','Omschrijving7','uploader7');
insert into project(id,title,short_description,uploader) values (8,'Project8','Omschrijving8','uploader8');
insert into project(id,title,short_description,uploader) values (9,'Project9','Omschrijving9','uploader9');

--Category
insert into category(id, name) values (1, 'UX/UI')
insert into category(id, name) values (2, 'Video')
insert into category(id, name) values (3, 'Code')
insert into category(id, name) values (4, 'Research')
insert into category(id, name) values (5, 'Concept')

--Project_categories
insert into project_categories(project_id, categories_id) values (1, 1);
insert into project_categories(project_id, categories_id) values (2, 2);
insert into project_categories(project_id, categories_id) values (3, 3);
insert into project_categories(project_id, categories_id) values (4, 4);
insert into project_categories(project_id, categories_id) values (5, 5);
insert into project_categories(project_id, categories_id) values (6, 5);

-- Project_list
insert into project_list(title) values ('Projectlijstnaam1');
insert into project_list(title) values ('Projectlijstnaam2');

-- Project_list_projects
insert into project_list_projects (project_list_id, projects_id) values (1, 1);
insert into project_list_projects (project_list_id, projects_id) values (1, 2);
insert into project_list_projects (project_list_id, projects_id) values (1, 3);
insert into project_list_projects (project_list_id, projects_id) values (1, 4);
insert into project_list_projects (project_list_id, projects_id) values (2, 1);
insert into project_list_projects (project_list_id, projects_id) values (2, 7);

-- Student
insert into student (student_id, name) values (1, 'Piet');

-- Choice
insert into choice (choice, project_id, project_list_id, student_student_id) values (1, 1, 1, 1);
