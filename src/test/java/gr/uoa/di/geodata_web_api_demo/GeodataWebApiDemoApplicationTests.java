package gr.uoa.di.geodata_web_api_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gr.uoa.di.geodata_web_api_demo.controllers.WebController;

@SpringBootTest
class GeodataWebApiDemoApplicationTests {

  @Autowired(required = false)
  private WebController webController;

  @Test
  void contextLoads() {

  }
}