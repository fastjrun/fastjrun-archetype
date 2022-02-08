#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package ${package}.client.common;
import ${package}.common.BaseException;
import ${package}.common.CodeMsgI;


/**
 * @author fastjrun
 * 响应码和响应消息封装类
 */
public class ClientException extends BaseException {


    private static final long serialVersionUID = -2959355115773679964L;

    public ClientException(Integer code, String msg) {
        super(code,msg);
    }

    public ClientException(CodeMsgI codeMsgI) {
        super(codeMsgI.getCode(), codeMsgI.getMsg());
    }
}