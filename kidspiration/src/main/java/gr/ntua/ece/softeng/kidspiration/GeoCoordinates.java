package gr.ntua.ece.softeng.kidspiration;

import java.util.List;

public class GeoCoordinates {
    private String status;
    private List<GResult> results;
    public String error_message;

    GeoCoordinates() {
        status = null;
        results = null;
        error_message = null;
    }

    public String getFormattedAddress() {
        return this.results.get(0).formatted_address;
    }

    public double getLongitude() {
        return Double.parseDouble(this.results.get(0).geometry.location.lng);
    }

    public double getLatitude() {
        return Double.parseDouble(this.results.get(0).geometry.location.lat);
    }

    public boolean isValid() {
        return status != null && this.status.equals("OK") && this.results != null && this.results.size() > 0;
    }

    /* overrides method in java.lang.Object */
    public String toString() {
        if ( this.isValid()) {
            return this.status + "\n" + this.getFormattedAddress() + "\n" + this.getLatitude() + "\n"
                    + this.getLongitude() + "\n";
        } else {
            return this.status + ": " + this.error_message;
        }
    }
}
