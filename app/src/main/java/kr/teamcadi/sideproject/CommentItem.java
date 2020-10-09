package kr.teamcadi.sideproject;

public class CommentItem {
    String id;
    String time;
    String comment;
    Integer up;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public CommentItem(String id, String time, String comment, Integer up){
        this.id =id;
        this.time = time;
        this.comment = comment;
        this.up = up;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
