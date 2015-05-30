
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.entities.Journey;
import java.util.ArrayList;
import java.util.List;


public class JourniesContext extends CommandContext{
    
    private List<Journey> journies = new ArrayList<Journey>();

    public List<Journey> getJournies() {
        return journies;
    }

    public void setJournies(List<Journey> journies) {
        this.journies = journies;
    }
}
