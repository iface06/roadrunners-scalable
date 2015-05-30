
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.entities.User;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


public class CreateJourneyCommandTest {

    @Test
    public void testJourneyCreation() {
        
        
        JourneyContext context = new JourneyContext();
        context.setUser(CommandContext.DEFAULT_USER);
        CreateJourneyCommand c = new CreateJourneyCommand(context);
        c.execute();
        
        assertEquals(CommandContext.DEFAULT_USER, context.getJourney().getUser());
        assertNotNull(context.getJourney().getCreatedDate());
    }

    

}