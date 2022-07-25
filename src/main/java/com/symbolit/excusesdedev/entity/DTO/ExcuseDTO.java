package com.symbolit.excusesdedev.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * Excuse entity in the form of a DTO (Data Transfer Object)
 *
 * @author Cecile
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcuseDTO implements Serializable {

    private Long id;

    private Long httpCode;

    private String tag;

    private String message;

    @Override
    public String toString() {
        return "{ http_code: " + getHttpCode() + ", tag : " + getTag() + ", message : " + getMessage() + "}";
    }
}
