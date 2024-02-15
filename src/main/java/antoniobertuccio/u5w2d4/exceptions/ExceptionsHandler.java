package antoniobertuccio.u5w2d4.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorsPayload handleBadRequest(BadRequestException ex) {
    if (ex.getErrorsList() != null) {
      List<String> errorsList = ex.getErrorsList().stream().map(objectError -> objectError.getDefaultMessage()).toList();
      return new ErrorsPayloadWithList(ex.getMessage(), LocalDateTime.now(), errorsList);
    } else {
      return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorsPayload handleNotFound(NotFoundException ex) {
    return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorsPayload handleGenericErrors(Exception ex) {
    ex.fillInStackTrace();
    return new ErrorsPayload("Problema lato server ⚠", LocalDateTime.now());
  }

}
