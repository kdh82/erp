package kr.or.dgit.ncs_erp;

public class Config {
	public static final String DB_NAME = "ncs_erp_kdh";
	public static final String USER = "root";
	public static final String PWD = "rootroot";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String[] TABLE_NAMES = { "title", "department", "employee" };
	public static final String[] CREATE_SQL_TABLE = {
			/* 직책 */
			"CREATE TABLE title ( " + "tcode INT(11)     NOT NULL COMMENT '직책번호', "
					+ "tname VARCHAR(10) NULL     COMMENT '직책명', " + "primary key (tcode)); ",
			/* 부서 */
			"CREATE TABLE department ( " + "dcode INT(11)  NOT NULL COMMENT '부서번호', "
					+ "dname CHAR(10) NOT NULL COMMENT '부서명', " + "floor INT(11)  NULL     COMMENT '위치', "
					+ "primary key(dcode)); ",
			/* 사원 */
			"CREATE TABLE employee ( " + "eno      INT(11)     NOT NULL COMMENT '사번', "
					+ "ename    VARCHAR(20) NOT NULL COMMENT '사원명', " + "salary   INT(11)     NULL     COMMENT '급여', "
					+ "dno      INT(11)     NULL     COMMENT '부서', " + "gender   TINYINT(1)  NULL     COMMENT '성별', "
					+ "joindate DATE        NULL     COMMENT '입사일', " + "title    INT(11)     NULL     COMMENT '직책', "
					+ "primary key (eno), " + "foreign key (dno) references department(dcode), "
					+ "foreign key (title) references title(tcode) " + "on delete cascade " + "on update cascade); " };
	public static final String KDH_USER = "ncs_erp";
	public static final String KDH_USER_PASSWD = "rootroot";
	public static final String CREATE_USER = String.format(
			"grant select, insert, update, delete on %s.* to '%s' identified by '%s' ", DB_NAME, KDH_USER,
			KDH_USER_PASSWD);

	public static final String[] EXPORT_SQL = { "select tcode, tname from title",
			"select dcode, dname, floor from department",
			"select eno, ename, salary, dno, gender, joindate, title from employee"};
	public static final String IMPORT_SQL = "load data local infile '%s' " + "IGNORE " + "into table %s "
			+ "character set 'utf8' " + "fields terminated by ',' " + "lines terminated by '\n';";

	public static final String EXPORT_DIR = System.getProperty("user.dir") + "\\BackupFiles\\";
	public static final String IMPORT_DIR = System.getProperty("user.dir") + "\\DataFiles\\";
}
