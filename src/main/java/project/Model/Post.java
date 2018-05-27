package project.Model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "posts") // set table name, we're going to use.
public class Post
{

    //key hibernate
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private int userid;

    private String image_path;

    private String question;

    public void setUserid(int userid) { this.userid = userid; }

    public void setQuestion(String question) { this.question = question; }

    public void setImage_path(String image_path) { this.image_path = image_path; }

    //getters..
    public int getID() { return this.id; }
    public int getUserid() { return this.userid; }
    public String getImage_path() { return this.image_path; }
    public String getQuestion() { return this.question; }

}