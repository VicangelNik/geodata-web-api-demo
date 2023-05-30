package gr.uoa.di.geodata_web_api_demo.model;

import java.util.List;

public class SearchResponse {

  private int start;
  private int count;
  private int total;
  private List<PointOfInterest> data;

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<PointOfInterest> getData() {
    return data;
  }

  public void setData(List<PointOfInterest> data) {
    this.data = data;
  }
}
