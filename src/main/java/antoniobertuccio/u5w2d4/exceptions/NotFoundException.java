package antoniobertuccio.u5w2d4.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
  public NotFoundException(int id) {
    super("L'utente con id " + id + " non è stato trovato");
  }
}
