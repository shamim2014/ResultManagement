/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import WebApp.Model.ExamCommittee;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public class ExamCommitteeMapper implements ObjectRowMapper<ExamCommittee>
{

    @Override
    public ExamCommittee mapRowToObject(ResultSet resultSet) throws SQLException 
    {
        ExamCommittee examCommittee = new ExamCommittee();
        examCommittee.setChairmanEmail(resultSet.getString("chairmanEmail"));
        examCommittee.setFirstMemberEmail(resultSet.getString("firstMemberEmail"));
        examCommittee.setSecondMemberEmail(resultSet.getString("secondMemberEmail"));
        examCommittee.setYear(resultSet.getString("year"));
        examCommittee.setSession(resultSet.getString("session"));
        return examCommittee;
    }
    
}
