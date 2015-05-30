
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;
import de.as.roadRunners.app.entities.Journey;


public class LoadJourneyCommand implements Command{
    private final JourneyContext context;
    private final JourneyDao dao;

    public LoadJourneyCommand(JourneyContext context, JourneyDao dao) {
        this.context = context;
        this.dao = dao;
    }

    @Override
    public void execute() {
        Journey j = dao.findJourney(context.getJourneyId());
        context.setJourney(j);
    }

}
