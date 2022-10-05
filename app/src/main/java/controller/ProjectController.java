package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Project;

public class ProjectController {
    
    public void save(Project project) throws RuntimeException{
        String sql = "INSERT INTO projects (name, description, creation_data, update_data)"
                + " VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreationData().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateData().getTime()));
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao adicionar o projeto" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Project project){
        String sql = "UPDATE projects SET name = ?, description = ?, creation_data = ?, update_data =?"
                + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreationData().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateData().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao atualizar o projeto" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        } 
    }
    
    public void deleteById(int projectId) throws SQLException{
        String sql = "DELETE FROM projects WHERE id = ?";
                
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        }catch (Exception ex){
            throw new RuntimeException("Erro ao deletar o projeto" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Project> getAll(int idProject) throws SQLException{
        String sql = "SELECT * FROM projects";
        
        Connection conn = null;
        PreparedStatement statement = null;   
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<Project>();
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreationData(resultSet.getDate("creation_data"));
                project.setUpdateData(resultSet.getDate("update_data")); 
                projects.add(project);
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao consultar o projeto" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        return projects;
    }
}