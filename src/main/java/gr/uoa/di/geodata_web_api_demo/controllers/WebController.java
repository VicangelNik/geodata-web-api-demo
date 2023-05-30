package gr.uoa.di.geodata_web_api_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gr.uoa.di.geodata_web_api_demo.model.Credentials;
import gr.uoa.di.geodata_web_api_demo.model.DataResult;
import gr.uoa.di.geodata_web_api_demo.model.SearchInput;
import gr.uoa.di.geodata_web_api_demo.model.SearchResponse;
import gr.uoa.di.geodata_web_api_demo.model.WebToken;

@RestController
@RequestMapping("/demo")
public class WebController {

  @GetMapping("/hello")
  public String salutation() {
    return "Hello world!";
  }

  /**
   * This is a simple login controller as an example.
   *
   * @param credentials username and password.
   *
   * @return a generated token indicating a successful response with an HTTP status code of 200 (OK)
   * and the generated token in json format.
   *
   * @implNote {@code @RequestBody} indicates a JSON payload representing username and password.
   * <p>
   * By using ResponseEntity, you have fine-grained control over the HTTP response,
   * allowing you to set the status code, headers, and body according to the requirements of your application.
   * </p>
   * By specifying consumes = {MediaType.APPLICATION_JSON_VALUE}, it means that the endpoint can only consume requests
   * with a content type of JSON (application/json).
   * This informs the client that it should send the request body in JSON format.
   * By specifying produces = {MediaType.APPLICATION_JSON_VALUE}, it means that the endpoint will generate responses
   * with a content type of JSON.
   */
  @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<WebToken> login(@RequestBody Credentials credentials) {
    // some process of credentials ...
    return new ResponseEntity<>(new WebToken(), HttpStatus.OK);
  }

  @PostMapping(path = "/import", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<DataResult> importPoisCategories(@RequestHeader("x-api-token") String xApiToken,
                                                         @RequestParam MultipartFile csvFile) {
    // some process of input ...
    return new ResponseEntity<>(new DataResult(), HttpStatus.OK);
  }

  @PostMapping(path = "/search/pois", consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<SearchResponse> importPoisCategories(@RequestHeader("x-api-token") String xApiToken,
                                                         @RequestBody SearchInput searchInput) {
    // some process of input ...
    return new ResponseEntity<>(new SearchResponse(), HttpStatus.OK);
  }
}
