package controller;

import model.Project;
import util.ConnectionFactory;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

    public void save(Project project) {
        String sql = "INSERT INTO project (projectName," +
        "projectDescription," +
        "createdAt," +
        "updatedAt) VALUES (?, ?, ?, ?)";

        Connection c = null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);

            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getProjectDesc());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));

            //executando os comandos
            statement.execute();
        } catch(SQLException e) {
            throw new RuntimeException("Erro ao salvar projeto! ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }
    }

    public void update(Project project) {

        String sql = "UPDATE project SET projectName = ?," +
                "projectDescription = ?," +
                "createdAt = ?," +
                "updatedAt = ? WHERE id = ?";

        Connection c =null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);

            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getProjectDesc());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());

            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar projeto! " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }

    }

    public void removeById(int projectId) throws SQLException {
        String sql = "DELETE * FROM project WHERE id = ?";

        Connection c = null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar projeto! ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }


    }

    public List<Project> getAll() {

        String sql = "SELECT * FROM project";

        List<Project> projects = new ArrayList<>();

        Connection c = null;
        PreparedStatement statement = null;
        ResultSet rset = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            rset = statement.executeQuery();

            while (rset.next()) {

                Project project = new Project();

                project.setId(rset.getInt("id"));
                project.setProjectName(rset.getString("projectName"));
                project.setProjectDesc(rset.getString("projectDescription"));
                project.setCreatedAt(rset.getDate("createdAt"));
                project.setUpdatedAt(rset.getDate("updatedAt"));

                projects.add(project);


            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao exibir projetos!", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement, rset);
        }

        return projects;
    }
}
