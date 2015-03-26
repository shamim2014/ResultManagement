/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebApp.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shamim
 */
public interface ObjectRowMapper<E>
{
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}
