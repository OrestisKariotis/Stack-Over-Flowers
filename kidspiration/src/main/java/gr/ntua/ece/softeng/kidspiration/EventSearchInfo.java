package gr.ntua.ece.softeng.kidspiration;

import java.util.List;

public class EventSearchInfo {

    String description;
    List<String> categories;
    Long distanceInKm;
    String fromLoc;
    Long age;
    Long upperCost;
    Long lowerCost;
    String dateUpper;
    String dateLower;

    public EventSearchInfo(String description, List<String> categories, Long distanceInKm, String fromLoc, Long age, Long upperCost, Long lowerCost, String dateUpper, String dateLower) {
        this.description = description;
        this.categories = categories;
        this.distanceInKm = distanceInKm;
        this.fromLoc = fromLoc;
        this.age = age;
        this.upperCost = upperCost;
        this.lowerCost = lowerCost;
        this.dateUpper = dateUpper;
        this.dateLower = dateLower;
    }

    public EventSearchInfo() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Long getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Long distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        this.fromLoc = fromLoc;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getUpperCost() {
        return upperCost;
    }

    public void setUpperCost(Long upperCost) {
        this.upperCost = upperCost;
    }

    public Long getLowerCost() {
        return lowerCost;
    }

    public void setLowerCost(Long lowerCost) {
        this.lowerCost = lowerCost;
    }

    public String getDateUpper() {
        return dateUpper;
    }

    public void setDateUpper(String dateUpper) {
        this.dateUpper = dateUpper;
    }

    public String getDateLower() {
        return dateLower;
    }

    public void setDateLower(String dateLower) {
        this.dateLower = dateLower;
    }
}