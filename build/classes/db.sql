create table books(
	id     int not null auto_increment,
	num    int,
	name   varchar(100),
	catogary varchar(100),
	price  double,
	date timestamp default current_timestamp,
	primary key (id)
)

insert into books(num,name,catogary,price) values(123,"昆虫研究杂志","自然科学",52.1);

select * from books;
select * from books where name like "%十%";