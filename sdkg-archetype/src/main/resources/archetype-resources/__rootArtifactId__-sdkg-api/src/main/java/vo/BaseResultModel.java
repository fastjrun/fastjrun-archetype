/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import lombok.Data;

@Data
public abstract class BaseResultModel {
  protected Integer code;

  protected String message = "";
}
