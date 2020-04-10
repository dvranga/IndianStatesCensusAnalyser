package com.bridgelabz.indianStatesCensus;


public class StateAnalyserException extends Exception {
    public ExceptionType type;

    public StateAnalyserException(ExceptionType type, String s, Throwable throwable) {
        super(s,throwable);
        this.type=type;
    }

    public StateAnalyserException(ExceptionType type, String s) {
        super(s);
        this.type=type;
    }

    public enum ExceptionType {THIS_IS_NOT_CSV_FILE , FILE_ERROR_DUETO_ERROR_CONTENT, Error_capturing_CSV_header, NO_SUCH_FILE}
}
