package models;

import java.util.Objects;

public class Resume {
    private String title;
    private String companyName;
    private String location;
    private  String educationLevel;
    private String description;
    private int id;

    public Resume(String title, String companyName, String location, String educationLevel, String description) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.educationLevel = educationLevel;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return getId() == resume.getId() &&
                getTitle().equals(resume.getTitle()) &&
                getCompanyName().equals(resume.getCompanyName()) &&
                getLocation().equals(resume.getLocation()) &&
                getEducationLevel().equals(resume.getEducationLevel()) &&
                getDescription().equals(resume.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCompanyName(), getLocation(), getEducationLevel(), getDescription(), getId());
    }
}
