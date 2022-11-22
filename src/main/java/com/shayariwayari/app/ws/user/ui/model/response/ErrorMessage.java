package com.shayariwayari.app.ws.user.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {
    private Date timeStamp;
    private String message;
}
