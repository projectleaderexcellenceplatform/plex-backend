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

-- Project_list
insert into project_list(id,title) values (1, 'Projectlijstnaam1');


-- Project_list_projects
insert into project_list_projects(project_lists_id, projects_id) values (1, 5);