package com.prakhar.demo.StudentServer.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
public class ExceptionResponseDTO
{
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private StringBuffer path;

    //No need to write this cause of @AllArgsConstructor Annotation
    public ExceptionResponseDTO(LocalDateTime timestamp, int statusCode, String error, String message, StringBuffer path)
    {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
