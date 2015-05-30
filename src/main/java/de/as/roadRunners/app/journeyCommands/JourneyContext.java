
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.entities.Journey;


public class JourneyContext extends CommandContext{
    
    private Journey journey;
    private String journeyId;
    
    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public void setJourneyId(String id) {
        this.journeyId = id;
    }

    public String getJourneyId() {
        return journeyId;
    }
    
}
