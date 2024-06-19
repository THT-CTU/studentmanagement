package com.tht.studentmanagement.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseBody {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Long timestamp;

  public ResponseBody(String message, Long timestamp) {
    this.message = message;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
