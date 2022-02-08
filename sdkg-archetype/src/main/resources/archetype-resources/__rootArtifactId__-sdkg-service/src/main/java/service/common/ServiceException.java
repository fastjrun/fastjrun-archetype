#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.service.common;


import ${package}.common.BaseException;
import ${package}.common.CodeMsgI;

public class ServiceException extends BaseException {

    private static final long serialVersionUID = 1511421458976623065L;

    public ServiceException(Integer code, String msg) {
        super(code, msg);
    }


    public ServiceException(CodeMsgI codeMsgI) {
        super(codeMsgI.getCode(), codeMsgI.getMsg());
    }
}