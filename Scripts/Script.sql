-- 사원관리프로그램
DROP SCHEMA IF EXISTS ncs_erp_kdh;

-- 사원관리프로그램
CREATE SCHEMA ncs_erp_kdh;

-- 직책

CREATE TABLE title (
	tcode INT(11)     NOT NULL COMMENT '직책번호',
	tname VARCHAR(10) NULL     COMMENT '직책명',
	primary key (tcode)
);

-- 부서
CREATE TABLE department (
	dcode INT(11)  NOT NULL COMMENT '부서번호',
	dname CHAR(10) NOT NULL COMMENT '부서명',
	floor INT(11)  NULL     COMMENT '위치',
	primary key(dcode)
);

-- 사원

CREATE TABLE employee (
	eno      INT(11)     NOT NULL COMMENT '사번',
	ename    VARCHAR(20) NOT NULL COMMENT '사원명',
	salary   INT(11)     NULL     COMMENT '급여',
	dno      INT(11)     NULL     COMMENT '부서',
	gender   TINYINT(1)  NULL     COMMENT '성별',
	joindate DATE        NULL     COMMENT '입사일',
	title    INT(11)     NULL     COMMENT '직책',
	primary key (eno),
	foreign key (dno) references department(dcode),
	foreign key (title) references title(tcode)
	on delete cascade
	on update cascade
);

select tcode, tname from title;

select dcode, dname, floor from department;

select eno, ename, salary, dno, gender, joindate, title from employee;

grant select, insert, update, delete 
on ncs_erp_kdh.*
to user_kdh;

create user user_kdh identified by 'rootroot';

grant select, insert, update, delete 
on ncs_erp_kdh.*
to user_kdh;

drop user user_kdh;

grant select, insert, update, delete 
on ncs_erp_kdh.* to 'user_kdh' identified by 'rootroot';