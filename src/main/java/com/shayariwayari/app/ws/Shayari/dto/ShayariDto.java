package com.shayariwayari.app.ws.Shayari.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShayariDto implements Serializable {
    private static final long serialVersionUID = -6247309333174215999L;
    private String shayariId;
    private String title;
    private String message;
    private String imageUrl;
    private String mediaUrl;
    private String mediaType;
    private String authorId;
    private String authorName;
    private int likesCount;
    private String[] categoryTags;
    private int reportCount;
    private String[] reportCategory;
    private Date createdAt;
    private Date updatedAt;
    private Boolean visibility;
    private Boolean isVerified;
}
