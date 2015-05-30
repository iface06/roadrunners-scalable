
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;
import de.as.roadRunners.app.entities.Journey;
import java.util.List;


public class LoadJourniesCommand implements Command {
    
    private JourniesContext context;
    private JourneyDao dao;

    public LoadJourniesCommand(JourniesContext context, JourneyDao dao) {
        this.context = context;
        this.dao = dao;
    }
    
    @Override
    public void execute() {
        List<Journey> journies = dao.findJournies(context.getUser());
        context.setJournies(journies);
    }

}
