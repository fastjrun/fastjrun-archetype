#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.common;

import ${package}.common.CodeMsgI;

public interface ApiWorldCodeMsgConstants {

    Integer CODE_OK = 20000;

    Integer CODE_ClIENT_NETWORK_NOT_AVAILABLE = 69999;
    Integer CODE_ClIENT_RESPONSE_EMPTY = 69998;
    Integer CODE_ClIENT_RESPONSE_NOT_VALID = 69997;
    Integer CODE_ClIENT_REQUEST_COMPOSE_FAIL = 69990;

    // response
    Integer CODE_CLIENT_RESPONSE_CODE_NULL = 69996;
    Integer CODE_CLIENT_RESPONSE_CODE_EMPTY = 69995;
    Integer CODE_ClIENT_RESPONSE_CODE_VALID = 69994;
    Integer CODE_ClIENT_RESPONSE_MESSAGE_NULL = 69993;
    Integer CODE_ClIENT_RESPONSE_MESSAGE_EMPTY = 69992;
    Integer CODE_ClIENT_RESPONSE_MESSAGE_VALID = 69991;

    public enum SWCodeEnum implements CodeMsgI{
        OK(CODE_OK, "OK"),
        // json
        ClIENT_NETWORK_NOT_AVAILABLE(CODE_ClIENT_NETWORK_NOT_AVAILABLE, "网络异常"),
        ClIENT_RESPONSE_EMPTY(CODE_ClIENT_RESPONSE_EMPTY, "返回数据为空"),
        ClIENT_REQUEST_COMPOSE_FAIL(CODE_ClIENT_REQUEST_COMPOSE_FAIL, "组装报文失败"),
        ClIENT_RESPONSE_NOT_VALID(CODE_ClIENT_RESPONSE_NOT_VALID, "返回数据不是json格式"),


        // response
        CLIENT_RESPONSE_CODE_NULL(CODE_CLIENT_RESPONSE_CODE_NULL, "返回数据没有head节点"),
        CLIENT_RESPONSE_CODE_EMPTY(CODE_CLIENT_RESPONSE_CODE_EMPTY, "返回数据head中code为空"),
        ClIENT_RESPONSE_CODE_VALID(CODE_ClIENT_RESPONSE_CODE_VALID, "返回数据head中code为空值"),
        ClIENT_RESPONSE_MESSAGE_NULL(CODE_ClIENT_RESPONSE_MESSAGE_NULL, "返回数据中body不是约定的报文格式"),
        ClIENT_RESPONSE_MESSAGE_EMPTY(CODE_ClIENT_RESPONSE_MESSAGE_EMPTY, "返回数据中没有msg"),
        ClIENT_RESPONSE_MESSAGE_VALID(CODE_ClIENT_RESPONSE_MESSAGE_VALID, "返回数据中msg节点为空");
        private Integer code;

        private String msg;

        SWCodeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
