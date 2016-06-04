package domain;

import domain.User.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Comment")
public class Comment {

	/*评论主键*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="comment_id")
	private String id;

	/*评论者*/
	@ManyToOne(targetEntity=User.class)
	@JoinTable(name="comment_user",
			joinColumns=@JoinColumn(name="comment_id"
					,referencedColumnName="comment_id",unique=true),
			inverseJoinColumns=@JoinColumn(name="user_id",referencedColumnName="user_id"))

	private User user;
	/*评论日期*/
	@Column(name="commentDate")
	private Date commentDate;

	/*评论内容*/
	@Column(name="commentBody")
	private String commentBody;


	public Comment(){}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}



}
