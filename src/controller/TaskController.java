package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO task (projectId," +
        "taskName," +
        "taskDescription," +
        "taskNotes," +
        "taskStatus," +
        "taskDeadline," +
        "createdAt," +
        "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection c = null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getTaskName());
            statement.setString(3, task.getTaskDesc());
            statement.setString(4, task.getTaskNotes());
            statement.setBoolean(5, task.isDone());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));

            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar tarefa! ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE task SET projectId = ?," +
                "taskName = ?," +
                "taskDescription = ?," +
                "taskNotes = ?," +
                "taskStatus = ?," +
                "taskDeadline = ?," +
                "createdAt = ?," +
                "updatedAt = ? WHERE id = ?";

        Connection c = null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getTaskName());
            statement.setString(3, task.getTaskDesc());
            statement.setString(4, task.getTaskNotes());
            statement.setBoolean(5, task.isDone());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt (9, task.getId());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar tarefa! ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }
    }

    public void removeById(int taskId) throws SQLException {

        String sql = "DELETE FROM task WHERE id = ?";

        Connection c = null;
        PreparedStatement statement = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar tarefa. ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }

    }

    public List<Task> getAll() {

        String sql = "SELECT * FROM task";

        List<Task> tasks = new ArrayList<>();

        Connection c = null;
        PreparedStatement statement = null;
        //Mecanismo de busca
        ResultSet rset = null;

        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            rset = statement.executeQuery();

            while(rset.next()) {

                Task task = new Task();

               task.setId(rset.getInt("id"));
               task.setProjectId(rset.getInt("projectId"));
               task.setTaskName(rset.getString("taskName"));
               task.setTaskDesc(rset.getString("taskDescription"));
               task.setTaskNotes(rset.getString("taskNotes"));
               task.setDone(rset.getBoolean("taskStatus"));
               task.setDeadline(rset.getDate("taskDeadline"));
               task.setCreatedAt(rset.getDate("createdAt"));
               task.setUpdatedAt(rset.getDate("updatedAt"));

               tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao pesquisar tarefa! ", e);
        } finally {
            ConnectionFactory.closeConnection(c, statement, rset);
        }
        //Retornando o resoltado da busca
        return tasks;
    }

}
