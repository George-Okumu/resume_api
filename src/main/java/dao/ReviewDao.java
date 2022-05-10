package dao;

import models.Review;

import java.util.List;

public interface ReviewDao {
    void add (Review review);

    //read
    List<Review> getAll();
    List<Review> getAllResumesReview(int resumeId);

    //delete
    void deleteById(int id);
    void clearAll();
}
