#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.common;

/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
public interface CodeMsgI {

    Integer CODE_OK = 2000;

    String CODE_OK_MSG = "OK";

    Integer getCode();

    String getMsg();
}
