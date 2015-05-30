
package de.as.roadRunners.app.journeyCommands;

import de.as.roadRunners.app.entities.City;
import de.as.roadRunners.app.entities.Journey;


public class CityToJourneyContext extends CommandContext{
    private City city;
    private Journey journey;
    private boolean successful;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

}
