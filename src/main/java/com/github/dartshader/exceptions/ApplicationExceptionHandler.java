package com.github.dartshader.exceptions;

import com.github.dartshader.dto.ApplicationExceptionResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.CustomLog;

import javax.inject.Singleton;

@CustomLog
@Produces
@Singleton
@Requires(classes = {ApplicationException.class, ExceptionHandler.class})
public class ApplicationExceptionHandler implements
        ExceptionHandler<ApplicationException, HttpResponse<ApplicationExceptionResponse>> {

    @Override
    public HttpResponse<ApplicationExceptionResponse> handle(HttpRequest request, ApplicationException exception) {
        log.warn(exception.getMessage());
        return HttpResponse.status(HttpStatus.OK).body(new ApplicationExceptionResponse(exception.getMessage()));
    }

}
