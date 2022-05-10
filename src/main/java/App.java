import dao.ResumeConnection;
import dao.ReviewConnection;
import models.Resume;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import com.google.gson.Gson;

import java.util.List;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        ReviewConnection reviewConnection = new ReviewConnection(sql2o);
        ResumeConnection resumeConnection = new ResumeConnection(sql2o);

        conn = sql2o.open();

        post("/resumes/new", "application/json", (req, res) -> {
            Resume resume = gson.fromJson(req.body(), Resume.class);
            resumeConnection.add(resume);
            res.status(201);
            res.type("application/json");
            return gson.toJson(resume);
        });
        get("/resumes", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(resumeConnection.getAll());
        });

        get("/resumes/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int resumeId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(resumeConnection.findById(resumeId));
        });

        //post review
        post("/resumes/:resumeId/reviews/new", "application/json", (req, res) -> {
            int resumeId = Integer.parseInt(req.params("resumeId"));
            Review review = gson.fromJson(req.body(), Review.class);

            review.setResumeId(resumeId);
            reviewConnection.add(review);
            res.status(201);
            return gson.toJson(review);
        });


        //get all resumes review
        get("/resumes/:id/reviews", "application/json", (req, res) -> {
            int resumeId = Integer.parseInt(req.params("id"));
            List<Review> allReviews;

            allReviews = reviewConnection.getAllResumesReview(resumeId);

            return gson.toJson(allReviews);
        });


    }
}

