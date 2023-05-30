import com.fasterxml.jackson.databind.ObjectMapper
import gr.uoa.di.geodata_web_api_demo.controllers.WebController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author Nikiforos Xylogiannopoulos
 */
@SpringBootTest(classes = [WebController.class, ObjectMapper.class])
@AutoConfigureMockMvc
@EnableWebMvc
class LoadContextTest extends Specification {

  @Autowired
  private WebController webController;
  @Autowired
  private MockMvc mvc
  @Autowired
  private ObjectMapper objectMapper

  def "when context is loaded then all expected beans are created"() {
    expect: "the WebController is created"
    webController
  }

  def "when post login is performed then the response has status 200"() {
    given:
    String request = """
                    { 
                        "username": "demoUser", 
                        "password" : "demoPass"
                    }
                    """

    when:
    def results = mvc.perform(post('/demo/login')
                                .contentType(APPLICATION_JSON)
                                .content(request))

    then:
    results.andExpect(status().isOk())
  }

  def "when post import is performed then the response has status 200"() {
    given:
    MockMultipartFile file = new MockMultipartFile(
      "csvFile",
      "hello.csv",
      TEXT_PLAIN_VALUE,
      "Hello, World!".getBytes()
    );

    when:
    def results = mvc.perform(multipart('/demo/import')
                                .file(file)
                                .header("x-api-token", "XXX"))

    then:
    results.andExpect(status().isOk())
  }

  def "when post search/pois is performed then the response has status 200"() {
    given:
    String request = """
                    {
  "start": 75,
  "count": 72,
  "freeText": "test_261903e9380e",
  "filters": {
    "distance": {
      "lat": 43.00,
      "lon": 9.71,
      "km": 32
    },
    "keywords": [
      "test_0239a698fb74"
    ],
    "categories": [
      {
        "id": 82,
        "name": "test_35179e55a96b"
      }
    ]
  }
}
                    """

    when:
    def results = mvc.perform(post('/demo/search/pois')
                                .contentType(APPLICATION_JSON)
                                .header("x-api-token", "XXX")
                                .content(request))

    then:
    results.andExpect(status().isOk())
  }
}
