package Com.Spring.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class rowMapper implements RowMapper<student> {

	@Override
	public student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		student s=new student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setAddress(rs.getString(3));
		
		// TODO Auto-generated method stub
		return s;
	}

}
