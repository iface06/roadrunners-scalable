
package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.journeyCommands.CalculateJourneyCommand;
import de.as.roadRunners.app.journeyCommands.JourneyOptimizationContext;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@RestController
@SessionAttributes("roadRunnerSession")
public class OptimizeJourneyController {
    
    @RequestMapping(value="/myJourney/optimize", method=RequestMethod.GET)
    public Journey optimize(@ModelAttribute RoadRunnerSession s){
        JourneyOptimizationContext context = new JourneyOptimizationContext(s.getJourney());
        CalculateJourneyCommand command = new CalculateJourneyCommand(context);
        command.execute();
        
        return context.getOptimizedJourney();
    }

}
