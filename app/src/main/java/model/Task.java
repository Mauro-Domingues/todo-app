package model;

import java.util.Date;

public class Task {
    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Date deadLine;
    private Date creationData;
    private Date updateData;

    public Task(int id, int idProject, String name, String description, String notes, boolean isCompleted, Date deadLine, Date creationData, Date updateData) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadLine = deadLine;
        this.creationData = creationData;
        this.updateData = updateData;
    }
    
    public Task(){
        this.creationData = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreationData() {
        return creationData;
    }

    public void setCreationData(Date creationData) {
        this.creationData = creationData;
    }

    public Date getUpdateData() {
        return updateData;
    }

    public void setUpdateData(Date updateData) {
        this.updateData = updateData;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadLine=" + deadLine + ", creationData=" + creationData + ", updateData=" + updateData + '}';
    }
    
    
}
