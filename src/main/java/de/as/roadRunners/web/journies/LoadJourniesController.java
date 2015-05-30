
package de.as.roadRunners.web.journies;

import de.as.roadRunners.app.entities.Journey;
import de.as.roadRunners.app.journeyCommands.JourniesContext;
import de.as.roadRunners.app.journeyCommands.LoadJourniesCommand;
import de.as.roadRunners.persistence.JourneyMongoDbDao;
import de.as.roadRunners.persistence.JourneyRepository;
import de.as.roadRunners.web.RoadRunnerSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes("roadRunnerSession")
public class LoadJourniesController {
    
    @Autowired
    private JourneyRepository journeyRepository;
    
    @RequestMapping(value = "/myJournies/load")
    public List<Journey> loadJournies(@ModelAttribute RoadRunnerSession s, Model model){
        
        JourniesContext context = new JourniesContext();
        context.setUser(s.getUser());
        JourneyMongoDbDao dao = new JourneyMongoDbDao(journeyRepository);
        LoadJourniesCommand command = new LoadJourniesCommand(context, dao);
        command.execute();
        
        return context.getJournies();
    }

}
