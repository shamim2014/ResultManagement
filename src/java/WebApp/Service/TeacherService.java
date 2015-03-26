
package WebApp.Service;

import WebApp.Model.Teacher;
import java.util.List;

public interface TeacherService 
{
    public void saveTeacher(Teacher teacher);
    public List<Teacher> getAllTeacher();
    public Teacher getTeacherByEmail(String email);
    public void updateTeacher(Teacher teacher, String email);
}
