package gr.uoa.di.geodata_web_api_demo.model;

public class DataResult {

  private PointOfInterest pointOfInterest;
  private Category category;

  public PointOfInterest getPointOfInterest() {
    return pointOfInterest;
  }

  public void setPointOfInterest(PointOfInterest pointOfInterest) {
    this.pointOfInterest = pointOfInterest;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
