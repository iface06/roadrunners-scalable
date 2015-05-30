package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.journeyCommands.JourneyContext;
import de.as.roadRunners.app.journeyCommands.JourneyDao;
import de.as.roadRunners.app.journeyCommands.LoadJourneyCommand;
import de.as.roadRunners.persistence.JourneyMongoDbDao;
import de.as.roadRunners.persistence.JourneyRepository;
import de.as.roadRunners.web.RoadRunnerSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("roadRunnerSession")
@RestController
public class LoadJourneyController {

    @Autowired
    private JourneyRepository repository;
    
    
    @RequestMapping(value="/myJourney/{journeyId}", method=RequestMethod.GET)
    public Journey loadJourney(@PathVariable String journeyId, @ModelAttribute RoadRunnerSession s, Model model) {
        JourneyDao dao = new JourneyMongoDbDao(repository);
        JourneyContext context = new JourneyContext();
        context.setJourneyId(journeyId);
        LoadJourneyCommand command = new LoadJourneyCommand(context, dao);
        command.execute();
        
        s.setJourney(context.getJourney());
        
        return context.getJourney();
    }

}
