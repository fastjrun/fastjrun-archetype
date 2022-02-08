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

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultPageModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = -4710875926501827304L;

  private PageResult<T> data;


  public ResultPageModel(Integer code, String message) {
    this(code,message,null);
  }

  public ResultPageModel(Integer code, String message, PageResult<T> result) {
    this.code = code;
    this.message = message;
    this.data = result;
  }
}
