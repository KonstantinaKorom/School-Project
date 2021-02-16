-- drop schema school;

create schema if not exists school;
use school;

-- trainer: id, tfirstname, tlastname,tsubject
create table trainer(
	id int primary key auto_increment,
    tfirstname varchar(30) not null,
    tlastname varchar(30) not null,
    tsubject varchar(30)
);
-- course: id, ctitle, cstream, cstartdate, cenddate
create table course(
	id int primary key auto_increment, 
    ctitle varchar(30),
    cstream varchar(30) ,
    cstartdate date,
    cenddate date
    
);
-- assignment: id, title, description, submission date time , max total marks, max oral marks, fk: course id
create table assignment(
	id int primary key auto_increment,
    atitle varchar(30) not null,
    adescription varchar(30) , 
    subdatetime datetime not null,
    totalmax int not null,
    oralmax int not null,
    c_id int,
    constraint c_id foreign key(c_id) references course(id) 
);
-- student: id, firstname, lastname, date of birth, tuition fees
create table student(
	id int primary key auto_increment,
    sfirstname varchar(30) not null,
    slastname varchar(30) not null,
    dob date ,
    tuitionfees int
);
-- grade: id, oralmark, totalmark, student id, assignment id
create table grade(
	id int primary key auto_increment,
    oralmark int not null,
    totalmark int not null,
    s_id int,
    a_id int,
    constraint grade_sid foreign key(s_id) references student(id),
    constraint grade_aid foreign key(a_id) references assignment(id)
);

-- trainerpercourse: trainer id, course id
create table trainerpercourse(
	t_id int , 
    c_id int ,
    constraint tpc_tid foreign key(t_id) references trainer(id),
    constraint tpc_cid foreign key(c_id) references course(id)
);
-- studentpercourse: student id, course id
create table studentpercourse(
    s_id int, 
    c_id int, 
   constraint spc_sid foreign key(s_id) references student(id),
    constraint spc_cid foreign key(c_id) references course(id)
);

