package model;

import java.util.Date;

public class Project {
    private int id;
    private String name;
    private String description;
    private Date creationData;
    private Date updateData;

    public Project(int id, String name, String description, Date creationData, Date updateData) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationData = creationData;
        this.updateData = updateData;
    }

    public Project() {
        this.creationData = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "project{" + "id=" + id + ", name=" + name + ", description=" + description + ", creationData=" + creationData + ", updateData=" + updateData + '}';
    }
    
    
}
