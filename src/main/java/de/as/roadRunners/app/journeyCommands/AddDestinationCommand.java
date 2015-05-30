package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;
import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.entities.Journey;
import java.util.List;

public class AddDestinationCommand implements Command {

    private CityToJourneyContext context;
    

    public AddDestinationCommand(CityToJourneyContext context) {
        this.context = context;
    }
    

    @Override
    public void execute() {
        Journey journey = context.getJourney();
        City newDestination = context.getCity();
        context.setSuccessful(journey.addDestination(newDestination));
        
    }

}
