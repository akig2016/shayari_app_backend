package com.shayariwayari.app.ws.Shayari.io.document;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "ShayariCollection")
public class ShayariDocumentModel {
	private static final long serialVersionUID = -7792659426138962108L;
	@Id
	private ObjectId shayariId;
	private String title;
	private String message;
	private String imageUrl="";
	private String mediaUrl="";
	private String mediaType="";
	private String authorId="";
	private String authorName="";
	private int likesCount=0;
	private String[] categoryTags= new String[0];
	private int reportCount = 0;
	private String[] reportCategory = new String[0];
	private Date createdAt;
	private Date updatedAt;
	private Boolean visibility = false;
	private Boolean isVerified = false;

	public String getShayariId() {
		return shayariId.toString();
	}

	public void setShayariId(ObjectId shyariId) {
		this.shayariId = shyariId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public String[] getCategoryTags() {
		return categoryTags;
	}

	public void setCategoryTags(String[] categoryTags) {
		this.categoryTags = categoryTags;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public String[] getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(String[] reportCategory) {
		this.reportCategory = reportCategory;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	public Boolean getVerified() {
		return isVerified;
	}

	public void setVerified(Boolean verified) {
		isVerified = verified;
	}

}
