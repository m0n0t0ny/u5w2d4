package antoniobertuccio.u5w2d4.controllers;

import antoniobertuccio.u5w2d4.entities.Blogpost;
import antoniobertuccio.u5w2d4.exceptions.BadRequestException;
import antoniobertuccio.u5w2d4.payloads.NewBlogPostPayloadDTOClass;
import antoniobertuccio.u5w2d4.services.BlogsService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
  @Autowired
  BlogsService blogsService;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Blogpost saveBlogPost(@RequestBody @Validated NewBlogPostPayloadDTOClass newBlogPost, @NotNull BindingResult validation) {
    if (validation.hasErrors()) {
      throw new BadRequestException(validation.getAllErrors());
    }
    return this.blogsService.saveBlogPost(newBlogPost.getAuthorId(), newBlogPost);
  }

  @GetMapping("")
  public List<Blogpost> getBlogs(@RequestParam(required = false) Integer authorId) {
    if(authorId != null) return blogsService.findByAuthor(authorId);
    else return blogsService.getBlogs();
  }

  @GetMapping("/{blogId}")
  public Blogpost findById(@PathVariable int blogId) {
    return blogsService.findById(blogId);
  }

  @PutMapping("/{blogId}")
  public Blogpost findAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPostPayloadDTOClass body) {
    return blogsService.findByIdAndUpdate(blogId, body);
  }

  @DeleteMapping("/{blogId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findAndDelete(@PathVariable int blogId) {
    blogsService.findByIdAndDelete(blogId);
  }
}

