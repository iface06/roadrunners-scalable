
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;

public class SaveJourneyCommand implements Command{

    private JourneyContext context;
    private JourneyDao dao;
    

    public SaveJourneyCommand(JourneyContext context, JourneyDao dao) {
        this.context = context;
        this.dao = dao;
    }
    
    @Override
    public void execute() {
        dao.save(context.getJourney());
    }

    
}
