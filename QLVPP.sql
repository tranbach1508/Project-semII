Create database qlvpp
go
use qlvpp
go

Create table Category
(
	id int primary key identity(1,1) not null,
	name nvarchar(250) not null
)
go

Create table Product
(
	id int primary key identity(1,1) not null,
	name nvarchar(250) not null,
	cat_id int foreign key references Category(id),
	quantity int default(0) not null,
	price float not null,
	created_date datetime not null
)
go

Create table Account
(
	id int primary key identity(1,1) not null,
	name nvarchar(250),
	username varchar(64) unique not null,
	password varchar(64) not null
)
go

insert into Account(name,username,password) values
(N'Trần Văn Bách','tranbach1508','tranbach123'),
(N'Nguyễn Hữu Hiền','huuhien','123456'),
(N'Lê Văn Sơn','leson','123456')
go

Create table Department
(
	id int primary key identity(1,1) not null,
	name nvarchar(250) not null,
)
go

Create table Orders
(
	id int primary key identity(1,1) not null,
	dep_id int foreign key references Department(id) not null,
	created_date datetime not null,
	acc_id int foreign key references Account(id) not null,
)
go

Create table Order_detail
(
	order_id int foreign key references orders(id) not null,
	pro_id int foreign key references Product(id) not null,
	quantity int default(0) not null
)
go

Create table Pro_management
(
	dep_id int foreign key references Department(id) not null,
	pro_id int foreign key references Product(id) not null,
	quantity int default(0) not null,
	note nvarchar(500)
)
go