package com.bridgelabz.indianStatesCensus;


public class StateAnalyserException extends Exception {
    public ExceptionType type;

    public StateAnalyserException(ExceptionType type, String s, Throwable throwable) {
        super(s,throwable);
        this.type=type;
    }

    public enum ExceptionType {NO_SUCH_FILE}
}
