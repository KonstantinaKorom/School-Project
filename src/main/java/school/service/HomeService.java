package school.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
    
    public String getWelcomeMessage(){
        String message = "Welcome to School Web Application!";
        return message;
    }
    
}
