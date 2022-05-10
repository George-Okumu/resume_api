package models;

import java.util.Objects;

public class Review {
    private int resumeId;
    private int id;
    private String comment;

    public Review(int resumeId, String comment) {
        this.resumeId = resumeId;
        this.comment = comment;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getResumeId() == review.getResumeId() &&
                getId() == review.getId() &&
                Objects.equals(getComment(), review.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResumeId(), getId(), getComment());
    }
}
