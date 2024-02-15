package antoniobertuccio.u5w2d4.controllers;

import antoniobertuccio.u5w2d4.entities.Author;
import antoniobertuccio.u5w2d4.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
  @Autowired
  AuthorsService authorsService;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Author saveAuthor(@RequestBody Author body) throws Exception {
    return authorsService.save(body);
  }

  @GetMapping("")
  public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String sortBy) {
    return authorsService.getAuthors(page, size, sortBy);
  }

  @GetMapping("/{authorId}")
  public Author findById(@PathVariable int authorId){
    return authorsService.findById(authorId);
  }

  @PutMapping("/{authorId}")
  public Author findAndUpdate(@PathVariable int authorId, @RequestBody Author body){
    return authorsService.findByIdAndUpdate(authorId, body);
  }

  @DeleteMapping("/{authorId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findAndDelete(@PathVariable int authorId) {
    authorsService.findByIdAndDelete(authorId);
  }

}
