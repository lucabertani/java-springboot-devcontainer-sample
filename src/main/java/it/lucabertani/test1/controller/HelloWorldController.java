package it.lucabertani.test1.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  /*
   * @GetMapping("/greeting") public String greeting(@RequestParam(value = "name",
   * defaultValue = "World") String name) { // return new
   * Greeting(counter.incrementAndGet(), String.format(template, // name)); return
   * String.format(template, name); }
   */

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format(template, name);
  }

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
    System.out.println("Greeting 123: " + greeting.toString());
    return greeting;
  }
}
