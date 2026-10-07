package me.gumilarmn.catalog.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gumilarmn.catalog.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloResources {
    private final GreetingService greetingService;

    public HelloResources(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String HelloWorld() {
        return greetingService.sayGreeting();
    }

    @GetMapping("/currency")
    public String MyCurrency() {
        return greetingService.myCurrency();
    }

}
