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
            Assert.assertEquals( StateAnalyserException.ExceptionType.NO_SUCH_FILE,e.type );
        }
    }
   @Test
    public void givenStateCSVFile_WhenIncorrectReturn_ShouldReturnSad()  {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try {
            stateCensusAnalyser.csvReader();
        } catch (StateAnalyserException e) {
                Assert.assertEquals( "ERROR DUE TO FILE",e.getMessage() );
            System.out.println(e.getMessage());
            }
        }
   /* @Test
    public void givenStateCSVFile_WhenIncorrectReturn_ShouldReturnSad1()  {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try {
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals( StateAnalyserException.ExceptionType.NO_SUCH_FILE,e.type );
        }
    }*/

    @Test
    public void givenStateCSVFile_WhenCorrect_ButTypeIncorrect_ShouldReturnException() {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try{
            Assert.assertEquals( 29,stateCensusAnalyser.csvReader() );
        }catch (StateAnalyserException e)
        {
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
            System.out.println(e.getMessage());
            Assert.assertEquals( StateAnalyserException.ExceptionType.FILE_ERROR_DUETO_DELIMETR,e.type );
        }
    }
}
