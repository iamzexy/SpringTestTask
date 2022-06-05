package com.iamzexy.SpringTestTask.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Demin Artem
 */
@AllArgsConstructor
@Getter
@Setter
public class UserException extends RuntimeException {

    private final String message;
}
