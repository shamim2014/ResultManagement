
package WebApp.Util;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseTemplate
{
    private static Connection connection;
    
    public static void setTransaction()
    {
        try
        {
          DatabaseTemplate.connection=DatabaseConnectionPool.getConnection();
          DatabaseTemplate.connection.setAutoCommit(false);
        }
        catch(SQLException sQLException)
        {
            throw new RuntimeException(sQLException);
        }
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
    }
    public static void execute(String query) throws RuntimeException
    {
        Connection connection = null;
        Statement statement = null;
        
        try 
        {
            connection = DatabaseConnectionPool.getConnection();
            statement = connection.createStatement();
            statement.execute(query);
        } 
        catch (SQLException sQLException)
        {
            throw new RuntimeException(sQLException);
        } 
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally 
        {
            try 
            {
                if (statement != null) 
                {
                    statement.close();
                }
            } catch (SQLException sQLException)
            {
                closeConnection(connection);
                throw new RuntimeException(sQLException);
            }
        }
    }
    
    public static void executeTransaction(String... SqlQuery)
    {
        Connection connection = null;
        Statement statement = null;
        
        try
        {
            connection = DatabaseConnectionPool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            for (String sql : SqlQuery)
            {
                statement.executeUpdate(sql);
            }
            connection.commit();
        }
        catch (SQLException sQLException)
        {
            try
            {
                connection.rollback();
            }
            catch(SQLException sqLException)
            {
                throw new RuntimeException(sqLException);
            }
        } 
        catch (ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally 
        {
            try 
            {
                if (statement != null) 
                {
                    statement.close();
                }
                if(connection!=null)
                {
                    connection.close();
                }
            } 
            catch (SQLException sQLException)
            {
                throw new RuntimeException(sQLException);
            }
        }
    }
    public static <E> List<E> executeQuery(String query, Object parameters[],ObjectRowMapper<E> objectRowMapper)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<E> listOfE = new ArrayList<E>();
        
        try
        {
            connection = DatabaseConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) 
            {
                if (parameter instanceof String) 
                {
                    preparedStatement.setString(i, (String) parameter);
                } 
                else if (parameter instanceof Integer) 
                {
                    preparedStatement.setInt(i, (Integer) parameter);
                }
                else if (parameter instanceof Long) 
                {
                    preparedStatement.setLong(i, (Long) parameter);
                }
                else if (parameter instanceof Float) 
                {
                    preparedStatement.setFloat(i, (Float) parameter);
                } 
                else if (parameter instanceof Double) 
                {
                    preparedStatement.setDouble(i, (Double) parameter);
                } 
                else if (parameter instanceof Date) 
                {
                    preparedStatement.setDate(i, (Date) parameter);
                } 
                else if (parameter instanceof Blob) 
                {
                    preparedStatement.setBlob(i, (Blob) parameter);
                }
                i++;
            }
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next())
            {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        } 
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally
        {
            try 
            { 
                resultSet.close();
                preparedStatement.close();
            } 
            catch (SQLException sQLException)
            {
                closeConnection(connection);
                throw new RuntimeException(sQLException);
            }
        }
        return listOfE;
    }

    public static void executeTransactionQuery(String query, Object... parameters)
    {
        PreparedStatement preparedStatement = null;
        
        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) 
            {
                if (parameter instanceof String) 
                {
                    preparedStatement.setString(i, (String) parameter);
                } 
                else if (parameter instanceof Integer) 
                {
                    preparedStatement.setInt(i, (Integer) parameter);
                }
                else if (parameter instanceof Long) 
                {
                    preparedStatement.setLong(i, (Long) parameter);
                }
                else if (parameter instanceof Float) 
                {
                    preparedStatement.setFloat(i, (Float) parameter);
                } 
                else if (parameter instanceof Double) 
                {
                    preparedStatement.setDouble(i, (Double) parameter);
                } 
                else if (parameter instanceof Date) 
                {
                    preparedStatement.setDate(i, (Date) parameter);
                } 
                else if (parameter instanceof Blob) 
                {
                    preparedStatement.setBlob(i, (Blob) parameter);
                }
                i++;
            }
            preparedStatement.executeUpdate();
        } 
        catch (SQLException e) 
        {
             try
            {
                connection.rollback();
            }
            catch(SQLException sqLException)
            {
                throw new RuntimeException(sqLException);
            }
        } 
        finally
        {
            try 
            {
                preparedStatement.close();
            } 
            catch (SQLException sQLException)
            {
                closeConnection(connection);
                throw new RuntimeException(sQLException);
            }
        }
    }

    public static void commit()
    {
        if(DatabaseTemplate.connection!=null)
        {
            try
            {
                DatabaseTemplate.connection.commit();
            }
            catch(SQLException sQLException)
            {
                try
               {
                   DatabaseTemplate.connection.rollback();
               }
               catch(SQLException sqLException)
               {
                 throw new RuntimeException(sqLException);
               }
            }
            finally
            {
                closeConnection(DatabaseTemplate.connection);
            }
        }
    }

    public static <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper) 
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try 
        {
            connection = DatabaseConnectionPool.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next())
            {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } 
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } 
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally 
        {
            try 
            {
                resultSet.close();
                statement.close();
            } 
            catch (SQLException sQLException) 
            {
                closeConnection(connection);
                throw new RuntimeException(sQLException);
            }
        }
        return listOfE;
    }

    public static void executeInsertQuery(String query, Object... parameters)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try
        {
            connection = DatabaseConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) 
            {
                if (parameter instanceof String) 
                {
                    preparedStatement.setString(i, (String) parameter);
                } 
                else if (parameter instanceof Integer) 
                {
                    preparedStatement.setInt(i, (Integer) parameter);
                }
                else if (parameter instanceof Long) 
                {
                    preparedStatement.setLong(i, (Long) parameter);
                }
                else if (parameter instanceof Float) 
                {
                    preparedStatement.setFloat(i, (Float) parameter);
                } 
                else if (parameter instanceof Double) 
                {
                    preparedStatement.setDouble(i, (Double) parameter);
                } 
                else if (parameter instanceof Date) 
                {
                    preparedStatement.setDate(i, (Date) parameter);
                } 
                else if (parameter instanceof Blob) 
                {
                    preparedStatement.setBlob(i, (Blob) parameter);
                }
                else if(parameter instanceof Object)
                {
                    preparedStatement.setObject(i, (Object) parameter);
                }
                i++;
            }
            preparedStatement.executeUpdate();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        } 
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally
        {
            try 
            {
                preparedStatement.close();
            } 
            catch (SQLException sQLException)
            {
                closeConnection(connection);
                throw new RuntimeException(sQLException);
            }
        }
    }

    public static void delete(String query) 
    {
        Connection connection = null;
        Statement statement = null;
       
        try 
        {
            connection = DatabaseConnectionPool.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        } 
        catch(ClassNotFoundException classNotFoundException)
        {
            throw new RuntimeException(classNotFoundException);
        }
        finally 
        {
            try 
            {
                if (statement != null) 
                {
                    statement.close();
                }
            } 
            catch (SQLException e) 
            {
                closeConnection(connection);
                throw new RuntimeException(e);
            }
        }
    }

    private static void closeConnection(Connection conToClose)
    {
        try 
        {
            conToClose.close();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
}
