package dao;

import models.Resume;

import java.util.List;

public interface ResumeDao {
    //create
    void add(Resume resume);

    //read
    List<Resume> getAll();
    Resume findById(int id);




    //delete
    void deleteById(int id);
    void clearAll();
}
