package com.leo.mockito.controllers.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class StandardError {

	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String path;
}
