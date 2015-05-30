
package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.journeyCommands.CommandContext;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("roadRunnerSession")
public class MyJourniesController {
    
    @ModelAttribute
    public RoadRunnerSession roadRunnerSession(){
        RoadRunnerSession s = new RoadRunnerSession();
        s.setUser(CommandContext.DEFAULT_USER);
        return s;
    }
    
    
     @RequestMapping("/myJournies")
    public String index(Model model){
        return "journies";
    }

}
