package gr.uoa.di.geodata_web_api_demo.model;

import java.util.List;
import java.util.Optional;

public class PointOfInterest {

  private long timestampAdded; // unix epoch
  private String title;
  private Optional<String> description;
  private double latitude;
  private double longitude;
  private Optional<List<String>> keywords;
  private Optional<List<String>> categories;

  public void setTimestampAdded(long timestampAdded) {
    this.timestampAdded = timestampAdded;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(Optional<String> description) {
    this.description = description;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setKeywords(Optional<List<String>> keywords) {
    this.keywords = keywords;
  }

  public void setCategories(Optional<List<String>> categories) {
    this.categories = categories;
  }

  public long getTimestampAdded() {
    return timestampAdded;
  }

  public String getTitle() {
    return title;
  }

  public Optional<String> getDescription() {
    return description;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public Optional<List<String>> getKeywords() {
    return keywords;
  }

  public Optional<List<String>> getCategories() {
    return categories;
  }
}
