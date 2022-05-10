package dao;

import models.Resume;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class ResumeConnection implements ResumeDao {
    private final Sql2o sql2o;
    public ResumeConnection(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Resume resume) {
        String sql = "INSERT INTO resumes (title, companyName, location, educationLevel, description) VALUES (:title, :companyName, :location, :educationLevel, :description)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(resume)
                    .executeUpdate()
                    .getKey();
            resume.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Resume> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM resumes")
                    .executeAndFetch(Resume.class);
        }
    }

    @Override
    public Resume findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM resumes WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Resume.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from resumes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from resumes";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
