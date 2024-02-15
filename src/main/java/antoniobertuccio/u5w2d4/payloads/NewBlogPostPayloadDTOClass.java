package antoniobertuccio.u5w2d4.payloads;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class NewBlogPostPayloadDTOClass {

  @NotEmpty(message = "La categoria è obbligatoria!")
  @Size(min = 4, max = 20, message = "In nome della categoria dev'essere compresa tra 4 e 20 caratteri!")
  private String category;

  @NotEmpty(message = "Il contenuto è obbligatorio!")
  @Min(value = 100, message = "Il contenuto deve contenere almeno 100 caratteri!")
  private String content;

  @NotEmpty(message = "Il reading time è obbligatorio!")
  @Size(min = 1, max = 120, message = "Il reading time dev'essere un numero compresa tra 1 e 120 minuti!")
  private double readingTime;

  private String title;

  private int authorId;
}
