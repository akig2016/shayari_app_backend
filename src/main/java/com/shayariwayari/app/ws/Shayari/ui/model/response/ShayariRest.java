package com.shayariwayari.app.ws.Shayari.ui.model.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShayariRest {
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
