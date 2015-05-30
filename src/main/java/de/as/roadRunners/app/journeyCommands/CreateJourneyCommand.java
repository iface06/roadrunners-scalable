
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;
import de.as.roadRunners.app.entities.Journey;
import java.util.Date;


public class CreateJourneyCommand implements Command{
    
    private JourneyContext context;

    public CreateJourneyCommand(JourneyContext context) {
        this.context = context;
    }
    
    @Override
    public void execute() {
        Journey j = new Journey();
        j.setUser(context.getUser());
        j.setCreatedDate(new Date());
        context.setJourney(j);
    }
    
}
