
package WebApp.repository;

import WebApp.Model.CourseMarks;
import WebApp.Model.CourseSemester;
import WebApp.Model.Tabulation;
import java.util.List;

public interface TabulationDAO 
{
   public void saveTabulation(List<Tabulation>tabulations, CourseSemester courseSemester);
   public List<CourseMarks> getTablutionByCourseCode(String courseCode,String session,String batch);
   public List<CourseMarks> getTablutionByCourseCodeLab(String courseCode,String session,String batch);
   public List<Tabulation> getTabulationByStudent(String registration,String registrationSession);
   public Tabulation getTabulationByStudent(String registration,String registrationSession,String year,String semester);
   public CourseMarks getTablutionByCourseCodeAndStudent(String courseCode,String session,String batch,String examRoll);
   public CourseMarks getTablutionByCourseCodeLabAndStudent(String courseCode,String session,String batch,String examRoll);
}
