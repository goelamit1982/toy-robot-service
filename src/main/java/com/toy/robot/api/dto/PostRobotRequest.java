package com.toy.robot.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;


public class PostRobotRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("x")
  private Integer x;

  @JsonProperty("y")
  private Integer y;

  @JsonProperty("direction")
  private String direction;

  public PostRobotRequest x(Integer x) {
    this.x = x;
    return this;
  }


  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public PostRobotRequest y(Integer y) {
    this.y = y;
    return this;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public PostRobotRequest direction(String direction) {
    this.direction = direction;
    return this;
  }


  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostRobotRequest inlineObject = (PostRobotRequest) o;
    return Objects.equals(this.x, inlineObject.x) &&
        Objects.equals(this.y, inlineObject.y) &&
        Objects.equals(this.direction, inlineObject.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, direction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

