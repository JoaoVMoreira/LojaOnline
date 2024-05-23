package com.LojaOnline.LojaOnline.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ReturnExceptionMessageDTO {
    private HttpStatus status;
    private String message;
}
