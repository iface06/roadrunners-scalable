package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.journeyCommands.JourneyContext;
import de.as.roadRunners.app.journeyCommands.SaveJourneyCommand;
import de.as.roadRunners.persistence.JourneyMongoDbDao;
import de.as.roadRunners.persistence.JourneyRepository;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes("roadRunnerSession")
public class SaveJourneyController {

    @Autowired
    private JourneyRepository journeyRepository;
    
    @RequestMapping(value = "/myJourney/save", method = RequestMethod.POST)
    public @ResponseBody
    Journey save(@RequestBody Journey journey, @ModelAttribute RoadRunnerSession s, Model model) {
        JourneyContext context = new JourneyContext();
        s.getJourney().setTitle(journey.getTitle());
        context.setJourney(s.getJourney());
        context.setUser(s.getUser());
        
        SaveJourneyCommand c = new SaveJourneyCommand(context, new JourneyMongoDbDao(journeyRepository));
        c.execute();

        return context.getJourney();
    }

}
