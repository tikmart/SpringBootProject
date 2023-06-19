package am.hitech.controller;

import am.hitech.model.dto.TestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{age}")
    public String test(@PathVariable Integer age) {

        return "age = " + age;
    }

    @GetMapping()
    public String test1(@RequestParam(required = false) Integer age) {

        return "age = " + age;
    }

    @PostMapping()
    public String test2(@RequestBody TestDto s) {

        return s.name;
    }



}
 