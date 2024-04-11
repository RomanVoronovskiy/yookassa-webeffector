package com.webeffector.ykassa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorMessage {

    private Date timestamp;
    private String code;
    private String message;

}