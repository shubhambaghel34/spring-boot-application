package com.easybytes.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ResponseDto {

//    @Schema(
//            description = "Status code in the response"
//    )
    private String statusCode;

//    @Schema(
//            description = "Status message in the response"
//    )
    private String statusMsg;
}
