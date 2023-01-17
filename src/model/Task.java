package model;

import java.util.Date;

public class Task {

    private int id;
    private int projectId;
    private String taskName;
    private String taskNotes;
    private String taskDesc;
    private boolean isDone;
    private Date createdAt;
    private Date updatedAt;
    private Date deadline;

    public Task(int id, int projectId, String taskName, String taskNotes, String taskDesc, boolean isDone, Date createdAt, Date updatedAt, Date deadline) {
        this.id = id;
        this.projectId = projectId;
        this.taskName = taskName;
        this.taskNotes = taskNotes;
        this.taskDesc = taskDesc;
        this.isDone = isDone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(String taskNotes) {
        this.taskNotes = taskNotes;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", taskName='" + taskName + '\'' +
                ", taskNotes='" + taskNotes + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", isDone=" + isDone +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deadline=" + deadline +
                '}';
    }


}
