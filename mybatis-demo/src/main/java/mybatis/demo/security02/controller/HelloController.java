package mybatis.demo.security02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/teacher")
    public String admin() {
        return "hello admin";
    }
    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba";
    }
    @GetMapping("/student")
    public String user() {
        return "hello user";
    }
}
