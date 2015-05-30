
package de.as.roadRunners.app.journeyCommands;



import de.as.roadRunners.app.journeyCommands.DeleteDestinationCommand;
import de.as.roadRunners.app.journeyCommands.CityToJourneyContext;
import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.entities.Journey;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class DeleteDestinationCommandTest {
    private City erlangen;
    private Journey journey;
    private DeleteDestinationCommand interactor;

    
        @Before
    public void before() {
        
        erlangen = new City("Erlangen", 49.123f, 7.444f);
        erlangen.setGeodataEntityId(1);
        journey = new Journey();
        journey.addDestination(erlangen);
    }
    
    @Test
    public void deleteDestination() {
        CityToJourneyContext ctx = new CityToJourneyContext();
        ctx.setCity(erlangen);
        ctx.setJourney(journey);
        
        interactor = new DeleteDestinationCommand(ctx);
        interactor.execute();
        
        assertEquals(0, ctx.getJourney().numberOfDestinations());
    }

}