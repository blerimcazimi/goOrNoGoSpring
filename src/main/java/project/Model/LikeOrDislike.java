package project.Model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "post_likes_or_dislikes") // set table name, we're going to use.
public class LikeOrDislike
{


    //primary key hibernate
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private int post_id;

    private int like_or_dislike;

    private int userid;

    public void setPost_id(int post_id) { this.post_id = post_id; }

    public void setLike_or_dislike(int like_or_dislike) { this.like_or_dislike = like_or_dislike; }

    public void setUserid(int userid) { this.userid = userid; }

}