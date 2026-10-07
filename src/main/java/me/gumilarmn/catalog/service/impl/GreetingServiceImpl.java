package me.gumilarmn.catalog.service.impl;

import lombok.AllArgsConstructor;
import me.gumilarmn.catalog.config.ApplicationProperties;
import me.gumilarmn.catalog.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreetingServiceImpl implements GreetingService {
	
	private ApplicationProperties applicationProperties;

	@Override
    public String sayGreeting() {
        return applicationProperties.getWelcomeText();
    }

    public String myCurrency(){
        return applicationProperties.getCurrency();
    }
}
