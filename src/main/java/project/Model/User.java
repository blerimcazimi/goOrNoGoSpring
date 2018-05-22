package project.Model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users") // set table name, we're going to use.
public class User
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String facebook;

    public void setFacebook(String facebook) { this.facebook = facebook; }

    public int getID() { return this.id; }

}