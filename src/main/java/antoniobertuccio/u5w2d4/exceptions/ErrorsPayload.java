package antoniobertuccio.u5w2d4.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayload {
  private String message;
  private LocalDateTime timestamp;
}
