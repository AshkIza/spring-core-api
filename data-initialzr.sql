use lms;
delete from course;
delete from topic;


insert into topic values ('containers', 'containarization including docker and kubernetes','containers');
insert into topic values ('Java Core', 'Java Core libraries - collections, streams, concurrent','Java Core');
insert into topic values ('Spring', 'Spring framework - Core/MVC/Data/Security & springBoot','Spring');
insert into topic values ('Frontend', 'Front end technologies - javascript, typescript, AngularJs, RxJs, HTML 5.0, CSS','Frontend');

insert into course values ('k8s', 'kubernetes 101','containers');
insert into course values ('javaCollections', 'Java Collections','Java Core');
insert into course values ('SpringBoot', 'Spring Boot applications','Spring');
insert into course values ('Angular', 'Angular 11 CRUD, Service, Components ','Frontend');
