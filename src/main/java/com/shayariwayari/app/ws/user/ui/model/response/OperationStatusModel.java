package com.shayariwayari.app.ws.user.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperationStatusModel {
    private String operationResult;
    private String operationName;
}
