package com.giangbb.microservices.cqrs.cmd.api.dto;

import com.giangbb.microservices.cqrs.common.dto.BaseResponse;
import lombok.Data;

@Data
public class OpenAccountResponse extends BaseResponse {
    private String id;

    public OpenAccountResponse(String message, String id) {
        super(message);
        this.id = id;
    }
}
