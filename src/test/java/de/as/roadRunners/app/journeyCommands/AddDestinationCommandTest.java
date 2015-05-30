
package de.as.roadRunners.app.journeyCommands;


import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.entities.Journey;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class AddDestinationCommandTest {
    private City erlangen;
    private Journey journey;
    private AddDestinationCommand interactor;

    @Test
    public void addDestination_successful() {
        
        CityToJourneyContext context = createRequest(erlangen, journey);
        interactor = new AddDestinationCommand(context);
        interactor.execute();
        assertEquals(1, context.getJourney().numberOfDestinations());
    }
    
    @Test
    public void addSameDestinationAgain_notSuccessful() {
        
        CityToJourneyContext context = createRequest(erlangen, journey);
        
        interactor = new AddDestinationCommand(context);
        interactor.execute();
        
        assertEquals(1, context.getJourney().numberOfDestinations());
        
        interactor = new AddDestinationCommand(context);
        interactor.execute();
        assertEquals(1, context.getJourney().numberOfDestinations());
        
    }

    private CityToJourneyContext createRequest(City erlangen, Journey journey) {
        CityToJourneyContext r = new CityToJourneyContext();
        r.setCity(erlangen);
        r.setJourney(journey);
        return r;
    }
    
     @Before
    public void before() {
        erlangen = new City("Erlangen", 49.123f, 7.444f);
        erlangen.setGeodataEntityId(1);
        journey = new Journey();
    }

}