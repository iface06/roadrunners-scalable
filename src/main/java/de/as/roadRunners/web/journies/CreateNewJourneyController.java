
package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.entities.User;
import de.as.roadRunners.app.journeyCommands.CreateJourneyCommand;
import de.as.roadRunners.app.journeyCommands.JourneyContext;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@RestController
@SessionAttributes("roadRunnerSession")
public class CreateNewJourneyController {
    
    @RequestMapping(value="/myJourney/create", method=RequestMethod.GET)
    public Journey index(Model model, @ModelAttribute RoadRunnerSession s){
        JourneyContext context = new JourneyContext();
        context.setUser(s.getUser());
        CreateJourneyCommand command = new CreateJourneyCommand(context);
        command.execute();
        
        s.setJourney(context.getJourney());
        
        return context.getJourney();
    }
    
    
   

}
