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
		jt.update("INSERT INTO student_zyl VALUES(stu_seq.nextval,?,?)", 
				new Object[]{stu.getName(),stu.getAge()});
	}
	public JdbcTemplate getJt() {
		return jt;
	}
	@Resource(name="jt")	//----两个jt没有关系。此行jt是bean的名字
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public Student findById(int id){
		return jt.queryForObject("SELECT * FROM student_zyl WHERE id=?",
				new Object[]{id},new StuRowMapper() );
	}
	
	//----内部类
	class StuRowMapper implements RowMapper<Student>{
		/**
		 * 告诉JdbcTempte,如何将ResultSet中的数据转换成一个Student对象。
		 */
		@Override
		public Student mapRow(ResultSet rst, int arg1) throws SQLException {
			Student s = new Student();
			s.setId(rst.getInt("id"));
			s.setName(rst.getString("name"));
			s.setAge(rst.getInt("age"));
			
			return s;
		}
		
	}
	
	public List<Student> findAll(){
		return jt.query("SELECT * FROM student_zyl",new StuRowMapper());
	}
	public void modify(Student stu){
		jt.update("UPDATE student_zyl SET name=?,age=? WHERE id=?",
					new Object[]{stu.getName(),stu.getAge(),stu.getId()});
	}
	public void delete(int id){
		jt.update("DELETE FROM student_zyl WHERE id=?",new Object[]{id});
	}
	
}
