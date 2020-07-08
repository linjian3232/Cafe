CREATE SCHEMA `tmxk` ;

/*用户*/
create table if not exists USER(
	userid char(10) primary key not null, /*用户id 系统生成 非敏感*/
    username varchar(20)not null, /*用户名 用户自定义 非敏感*/
    userpwd char(20) not null, /*密码 用户自定义，不超过20位，具体格式与前端用统一 敏感*/
    userphone char(11) not null, /*手机号 用户输入 敏感*/
    usersex char(1), /*用户性别 null值，0=男，1=女 非敏感*/
    useremail char(254) /*电子邮箱 正则表达式规范 非敏感*/

);
/*管理员*/
create table if not exists ADMIN(
	adminid char(10) primary key not null, /*管理员id（同职员id）， 系统生成*/
    adminname varchar(20) not null,/*管理员名字 录入*/
    adminpos varchar(20) not null/*职位*/
);
/*食物*/
create table if not exists FOOD(
	foodid char(4) primary key not null,/*食物代号 系统自动生成*/
    foodname char(20) not null, /*食物名称*/
    foodtype char(1) not null, /*食物类型*/
    foodstock long not null,/*库存量*/
    foodunit varchar(10) not null,/*单位*/
    foodprice double not null,
    foodimg char(100) not null /*食物图片路径*/
);

/*订单*/
create table if not exists ORDERINF(
	orderid char(20) primary key not null,/*订单号 系统自动生成*/
    ordertime datetime not null,/*生成日期*/
    orderstatus char(1) not null/*订单状态 分配中，进行中，已完成，取消*/
);
/*权限*/
create table if not exists AUTHOR(
	authorid int not null, /*权限id*/
    authorname varchar(50)not null /*权限名称*/
);
/*角色*/
create table if not exists ROLETABLE(
	roleid int not null,/*角色id*/
    rolename varchar(20) not null /*角色名称*/
);

/*订单-管理员-用户*/
create table if not exists oa(
	orderid char(20)not null,
    adminid char(10)not null,
    userid char(10) not null
);

/*订单-食物-用户*/
create table if not exists ofu(
	orderid char(20) not null,
    foodid char(4) not null,
    foodnumber int not null /*购买数量*/
);
/*用户-角色*/
create table if not exists ru(
	userid char(12) not null,
    roleid int not null
);
/*管理员-角色*/
create table if not exists au(
	adminid char(12) not null,
    roleid int not null
);
/*角色-权限*/
create table if not exists ra(
	roleid int not null,
    authorid int not null
);