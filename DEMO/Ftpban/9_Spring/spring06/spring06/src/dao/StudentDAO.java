package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Student;
@Repository("studentDAO")
public class StudentDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	public void save(Student stu){
		jt.update(
		"INSERT INTO student " +
		"VALUES(stu_seq.nextval,?,?)", 
		new Object[]{stu.getName(),stu.getAge()});
		
	}
	
	public Student findById(int id){
		return jt.queryForObject(
				"SELECT * FROM student " +
				"WHERE id=?", new Object[]{id},
				new StuRowMapper());
	}
	
	public List<Student> findAll(){
		return jt.query(
				"SELECT * FROM student",
				new StuRowMapper());
	}
	
	public void modify(Student stu){
		jt.update("UPDATE student " +
				"SET name=?,age=? WHERE " +
				"id=?", new Object[]{
				stu.getName(),stu.getAge(),
				stu.getId()});
	}
	
	public void delete(int id){
		jt.update("DELETE FROM student " +
				"WHERE id=?",new Object[]{id});
	}
	
	class StuRowMapper implements 
	RowMapper<Student>{
		//告诉JdbcTempte,如何将ResultSet
		//中的数据转换成一个Student对象。
		public Student mapRow(ResultSet rst, 
				int arg1) throws SQLException {
			Student s = new Student();
			s.setId(rst.getInt("id"));
			s.setName(rst.getString("name"));
			s.setAge(rst.getInt("age"));
			return s;
		}
		
	}
}
