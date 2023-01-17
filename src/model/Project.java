package model;

import java.util.Date;

public class Project {
    private int id;
    private String projectName;
    private String projectDesc;
    private Date createdAt;
    private Date updatedAt;

    public Project(int id, String projectName, String projectDesc, Date createdAt, Date updatedAt) {
        this.id = id;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project() {
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectObs) {
        this.projectDesc = projectObs;
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectDesc='" + projectDesc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
