
#搭建数据库

create database `ssmbuild`;

use ssmbuild;

drop table if exists `books_three`;

create table books_three(
      bookID int(10) not null  auto_increment comment '书id',
      bookName varchar(100) not null  comment '书名',
      bookCounts int(11) not null  comment '数量',
      details varchar(200) not null  comment '描述',
      key bookID(bookID)
)engine=innodb default charset=utf8;

# 插入几条数据
insert into books_three()
values (1,'Java',2,'速成Java'),
       (2,'Mysql',5,'删库跑路！'),
       (3,'Linux',10,'入门到入狱'),
       (4,'JavaWeb',11,'SSM基础');
#数据库搭建到此告一段落



在网页中向数据库插入数据库时，插入的内容一直乱码，而用数据库软件进行插入时，则不乱码，
纠结了半个小时后，发现没有在web.xml中添加乱码过滤。

更新SQL一直出现错误
看下面更新SQL的mybatis代码
<update id="updateBook" parameterType="Books">
    update books_three
    set bookName=${bookName},bookCounts=${bookCounts},details=${details}
    where bookID=${bookID};
</update>
    是不是想呼自己
