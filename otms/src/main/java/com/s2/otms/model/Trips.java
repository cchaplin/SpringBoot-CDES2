package com.s2.otms.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple domain object representing a list of trips. Mostly here to be used for the 'trips' {@link
 * org.springframework.web.servlet.view.xml.MarshallingView}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trips {

    private List<Trip> trips;

    public List<Trip> getTripList() {
        if (trips == null) {
            trips = new ArrayList<>();
        }
        return trips;
    }

    public void setTripList(List<Trip> trips) {
        this.trips.addAll(trips);
    }
}
