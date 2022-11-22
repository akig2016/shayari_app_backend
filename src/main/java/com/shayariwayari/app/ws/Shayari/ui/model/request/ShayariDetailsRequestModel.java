package com.shayariwayari.app.ws.Shayari.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShayariDetailsRequestModel {
    private String shayariId;
    private String title;
    private String message;
    private String imageUrl;
    private String mediaUrl;
    private String mediaType;
    private String authorId;
    private String authorName;
    private String[] categoryTags;
    private Boolean visibility;
}
