package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Task;

public class TaskController {
    public void save(Task task) throws RuntimeException{
        String sql = "INSERT INTO tasks (id_project, name, description, completed, notes, deadline, creation_data, update_data)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationData().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateData().getTime()));
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao adicionar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Task task){
        String sql = "UPDATE tasks SET id_project = ?, name = ?, description = ?, completed = ?, notes = ?, deadline = ?, creation_data = ?, update_data =?"
                + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationData().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateData().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        } 
    }
    
    public void deleteById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
                
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Task> getAll(int idProject) throws SQLException{
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;   
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("id_project"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setCreationData(resultSet.getDate("creation_data"));
                task.setUpdateData(resultSet.getDate("update_data")); 
                tasks.add(task);
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao consultar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return tasks;
    }
}