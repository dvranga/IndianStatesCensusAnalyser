package com.bridgelabz.indianStatesCensus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestCSVState {
    @Test
    public void givenNumberOfRecords_whenRecordsMatches_ShouldReturnHappy() {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try {
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        } catch (StateAnalyserException e) {
            System.err.println( e.getMessage() );
            if (!e.getMessage().equals( "THIS_IS_NOT_CSV_FILE" ))
            {
                return;
            }
            Assert.assertEquals( StateAnalyserException.ExceptionType.THIS_IS_NOT_CSV_FILE,e.type );

        }
    }
   @Test
    public void givenStateCSVFile_WhenIncorrectReturn_ShouldReturnSad()  {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try {
            stateCensusAnalyser.csvReader();
        }
            catch (StateAnalyserException e) {
                System.err.println( e.getMessage() );
                if (!e.getMessage().equals( "THIS_IS_NOT_CSV_FILE" ))
                {
                    return;
                }
                //System.out.println(e.getMessage());
                Assert.assertEquals( StateAnalyserException.ExceptionType.THIS_IS_NOT_CSV_FILE,e.type );
            }
        }

    @Test
    public void givenStateCSVFile_WhenCorrect_ButTypeIncorrect_ShouldReturnException() {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try{
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        }catch (StateAnalyserException e)
        {
            System.err.println( e.getMessage() );
            if (!e.getMessage().equals( "THIS_IS_NOT_CSV_FILE" ))
            {
                return;
            }
            System.out.println(e.getMessage());
            Assert.assertEquals( StateAnalyserException.ExceptionType.THIS_IS_NOT_CSV_FILE,e.type );
        }
    }
    @Test
    public void givenStateCSVFile_WhenCorrect_ButDelimiterIncorrect_ShouldReturnException() {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try{
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        }catch (StateAnalyserException e)
        {
            System.err.println( e.getMessage() );
            if (!e.getMessage().equals( "FILE ERROR DUE TO ERROR CONTENT" ))
            {
                return;
            }
            Assert.assertEquals( StateAnalyserException.ExceptionType.FILE_ERROR_DUETO_ERROR_CONTENT, e.type );
        }
    }
    @Test
    public void givenStateCSVFile_WhenCorrect_ButHEADERINCORRECT_ShouldReturnException() throws StateAnalyserException {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try{
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        }catch (StateAnalyserException e)
        {
            System.err.println( e.getMessage() );
            if (!e.getMessage().equals( "Error capturing CSV header!" ))
            {
                return;
            }
            Assert.assertEquals( StateAnalyserException.ExceptionType.Error_capturing_CSV_header, e.type );
        }
    }
}
