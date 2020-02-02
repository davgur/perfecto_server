package com.perfecto.davgur;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
   @MessageMapping("/socket")
    @SendTo("/processes")
    public ProcessResult run(ProcessResult result) {
        return result;
    }
}
