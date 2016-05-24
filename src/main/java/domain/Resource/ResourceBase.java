package domain.Resource;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="ResourceBase")
public class ResourceBase {

	@Id
	@GenericGenerator(name="resource_hilo" ,strategy="hilo")
	@GeneratedValue(generator="resource_hilo")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_id")
	private Integer id;

	@Column(name="filename")
	private String filename;

	@Column(name="createTime")
	private String createTime;

	@Enumerated(EnumType.STRING)
	@Column(name="typeOfResourceType")
	private ResourceType typeOfResourceType;

	@Column(name="md5")
	private String md5;

	@Column(name="points")
	private Integer points;

	@Column(name="downloads")
	private Integer downloads;

	@Column(name="fileSize")
	private double fileSize;

	@Column(name="reliability")
	private Integer reliability;

	@Column(name="likes")
	private Integer likes;

	@Column(name="dislike")
	private Integer dislike;

	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="comment_info",joinColumns=@JoinColumn(name="resource_id",nullable=true))
	@Column(name="comments_id")
	private List<String> comments;


	@Column(name="creatorUserId")
	private String creatorUserId;

	@Column(name="description")
	private String description;

	/*资源所在链接*/
	@Column(name="url")
	private String url;

	public ResourceBase(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}







	public String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getReliability() {
		return reliability;
	}

	public void setReliability(Integer reliability) {
		this.reliability = reliability;
	}

	public Integer getLike() {
		return likes;
	}

	public void setLike(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislike() {
		return dislike;
	}

	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}



	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceType getTypeOfResourceType() {
		return typeOfResourceType;
	}

	public void setTypeOfResourceType(ResourceType typeOfResourceType) {
		this.typeOfResourceType = typeOfResourceType;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
