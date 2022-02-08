#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helper;


import ${package}.common.CodeMsgI;
import ${package}.vo.PageResult;
import ${package}.vo.ResultListModel;
import ${package}.vo.ResultModel;
import ${package}.vo.ResultPageModel;

import java.util.List;

public class ResultHelper {

    public static <T> ResultModel<T> ok() {
        return new ResultModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultModel<T> ok(T result) {
        return new ResultModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultModel<T> fail(CodeMsgI codeMsgI) {
        return result(codeMsgI);
    }

    public static <T> ResultModel<T> result(CodeMsgI codeMsgI) {
        return result(codeMsgI, null);
    }

    public static <T> ResultModel<T> result(CodeMsgI codeMsgI, T result) {
        return new ResultModel(codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultModel<T> fail(Integer code, String msg) {
        return new ResultModel(code, msg);
    }

    public static <T> ResultListModel<T> okList() {

        return new ResultListModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultListModel<T> okList(List<T> result) {
        return new ResultListModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultListModel<T> failList(CodeMsgI code) {
        return resultList(code);
    }

    public static <T> ResultListModel<T> resultList(CodeMsgI code) {
        return resultList(code, null);
    }

    public static <T> ResultListModel<T> resultList(CodeMsgI codeMsgI, List<T> result) {
        return new ResultListModel(codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultListModel<T> failList(Integer code, String msg) {
        return new ResultListModel(code, msg);
    }

    public static <T> ResultPageModel<T> okPage() {
        return new ResultPageModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG);
    }

    public static <T> ResultPageModel<T> okPage(PageResult<T> result) {
        return new ResultPageModel(CodeMsgI.CODE_OK, CodeMsgI.CODE_OK_MSG, result);
    }

    public static <T> ResultPageModel<T> failPage(CodeMsgI codeMsgI) {
        return resultPage(codeMsgI);
    }

    public static <T> ResultPageModel<T> resultPage(CodeMsgI codeMsgI) {
        return resultPage(codeMsgI, null);
    }

    public static <T> ResultPageModel<T> resultPage(CodeMsgI codeMsgI, PageResult<T> result) {
        return new ResultPageModel(codeMsgI.getCode(), codeMsgI.getMsg(), result);
    }

    public static <T> ResultPageModel<T> failPage(Integer code, String msg) {
        return new ResultPageModel(code, msg);
    }
}
