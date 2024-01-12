package Com.Spring.Jdbc;

import java.util.List;

public interface studentimpl {
	public int insert(student s);
	public int change(student s);
	public int delete(int id);
	public student getstudent(int studentId);
	public List<student> getAll();

}
 