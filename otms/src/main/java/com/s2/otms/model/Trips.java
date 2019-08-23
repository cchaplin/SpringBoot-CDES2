package otms.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of trips. Mostly here to be used for the 'trips' {@link
 * org.springframework.web.servlet.view.xml.MarshallingView}.
 */
@XmlRootElement
public class Trips {

    private List<Trip> trips;

    @XmlElement
    public List<Trip> getTripList() {
        if (trips == null) {
            trips = new ArrayList<>();
        }
        return trips;
    }
}
