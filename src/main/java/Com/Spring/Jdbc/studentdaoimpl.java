package Com.Spring.Jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("studentdao")
public class studentdaoimpl implements studentimpl{
	
	private JdbcTemplate jdbctemplate;

	public int insert(student s) {
		
		String query="insert into student(id,name,address) values(?,?,?)";
		int r=this.jdbctemplate.update(query,s.getId(),s.getName(),s.getAddress());
		
		// TODO Auto-generated method stub
		return r;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public int change(student s) {
		try {
			String query="update student set name=?, address=? where id=?";
		int update = this.jdbctemplate.update(query,s.getName(),s.getAddress(),s.getId());
		return update;
		
		} catch (Exception e) {
			System.out.println("Invalid Student Value!!");
			// TODO: handle exception
		}
		return 0;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id) {
		try {
		String query="delete from student where id=?";
		int update = this.jdbctemplate.update(query,id);
		// TODO Auto-generated method stub
		return update;
		}catch (Exception e) {
			System.out.println("Student does not exist!!");
			// TODO: handle exception
		}
		return id;
	}

	@Override
	public student getstudent(int studentId) {
		String query="select * from student where id=?";
		
		RowMapper<student> rowMap = new rowMapper();
		student queryForObject = this.jdbctemplate.queryForObject(query, rowMap,studentId);
		
		// TODO Auto-generated method stub
		return queryForObject;
	}

	@Override
	public List<student> getAll() {
		String Query="select * from student";
		List<student> students = this.jdbctemplate.query(Query, new rowMapper());
		// TODO Auto-generated method stub
		return students;
	}
	

}
