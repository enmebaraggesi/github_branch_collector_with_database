package com.github_branch_collector_with_database.error;

import com.github_branch_collector_with_database.response.error.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestControllerAdvice()
public class ClientErrorHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public UserNotFoundExceptionResponseDto handleUserNotFoundExceptionException(UserNotFoundException e) {
        log.error(e);
        return new UserNotFoundExceptionResponseDto(HttpStatus.valueOf(404),
                                                    e.getMessage());
    }
    
    @ExceptionHandler(OwnerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public OwnerNotFoundExceptionResponseDto handleOwnerNotFoundException(OwnerNotFoundException e) {
        log.error(e);
        return new OwnerNotFoundExceptionResponseDto(HttpStatus.valueOf(404),
                                                     e.getMessage());
    }
    
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public IdNotFoundExceptionResponseDto handleOwnerNotFoundException(IdNotFoundException e) {
        log.error(e);
        return new IdNotFoundExceptionResponseDto(HttpStatus.valueOf(404),
                                                  e.getMessage());
    }
    
    @ExceptionHandler(XmlFormatException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public AcceptFormatExceptionResponseDto handleXmlFormatException(XmlFormatException e) {
        log.error(e);
        return new AcceptFormatExceptionResponseDto(HttpStatus.NOT_ACCEPTABLE,
                                                    "Your Accept header is invalid. Our client accepts only application/json");
    }
}
