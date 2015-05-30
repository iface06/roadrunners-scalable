package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.journeyCommands.AddDestinationCommand;
import de.as.roadRunners.app.journeyCommands.CityToJourneyContext;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@RestController
@SessionAttributes("roadRunnerSession")
public class AddDestinationController {
    
        
    @RequestMapping(value="/myJourney/addDestination",
            method=RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public @ResponseBody CityToJourneyContext apply(@RequestBody City city, @ModelAttribute RoadRunnerSession s){
        CityToJourneyContext context = new CityToJourneyContext();
        context.setUser(s.getUser());
        context.setCity(city);
        context.setJourney(s.getJourney());
        AddDestinationCommand c = new AddDestinationCommand(context);
        c.execute();
        
        return context;
    }
    
}
