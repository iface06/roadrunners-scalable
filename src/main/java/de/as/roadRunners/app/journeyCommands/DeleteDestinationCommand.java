
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.Command;
import de.as.roadRunners.app.entities.City;


public class DeleteDestinationCommand implements Command{
    private final CityToJourneyContext context;
    

    public DeleteDestinationCommand(CityToJourneyContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        City cityForDeleting = context.getCity();
        context.setSuccessful(context.getJourney().removeCity(cityForDeleting));
    }

}
