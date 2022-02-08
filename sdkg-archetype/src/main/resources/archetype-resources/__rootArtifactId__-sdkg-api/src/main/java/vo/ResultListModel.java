/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultListModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = -4710875926501827304L;

  private List<T> data;

  public ResultListModel(Integer code, String message) {
    this(code,message,null);
  }

  public ResultListModel(Integer code, String message, List<T> result) {
    this.code = code;
    this.message = message;
    this.data = result;
  }
}
