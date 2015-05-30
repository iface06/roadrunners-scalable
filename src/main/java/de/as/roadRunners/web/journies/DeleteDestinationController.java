package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.journeyCommands.CityToJourneyContext;
import de.as.roadRunners.app.journeyCommands.DeleteDestinationCommand;
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
public class DeleteDestinationController {

    @RequestMapping(value = "/myJourney/deleteDestination",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public @ResponseBody
    CityToJourneyContext delete(@RequestBody City city, @ModelAttribute RoadRunnerSession s) {
        CityToJourneyContext context = new CityToJourneyContext();
        context.setUser(s.getUser());
        context.setCity(city);
        context.setJourney(s.getJourney());
        DeleteDestinationCommand c = new DeleteDestinationCommand(context);
        c.execute();

        return context;
    }

}
