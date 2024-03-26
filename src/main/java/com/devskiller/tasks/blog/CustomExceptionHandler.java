package com.devskiller.tasks.blog;

import com.devskiller.tasks.blog.model.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({
		IllegalArgumentException.class
	})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody
	ErrorResponseDto handleBadRequestException(final Exception ex) {
		return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ErrorResponseDto handleUnexpectedException(final Exception ex) {
		return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage());
	}
}
