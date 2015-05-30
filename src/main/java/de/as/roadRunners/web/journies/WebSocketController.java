
package de.as.roadRunners.web.journies;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Answer index(String name) throws InterruptedException{
        Thread.sleep(3000);
        return new Answer("Hello Socket Guy!");
    }
}
