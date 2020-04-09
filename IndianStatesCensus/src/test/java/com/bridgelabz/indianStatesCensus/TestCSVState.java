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
            e.printStackTrace();
        }
    }
    @Test
    public void givenStateCSVFile_WhenIncorrectReturn_ShouldReturnSad()  {
        StateCensusAnalyser stateCensusAnalyser=new StateCensusAnalyser();
        try {
            stateCensusAnalyser.csvReader();
        } catch (StateAnalyserException e) {
                Assert.assertEquals( "ENTER PROPER FILE",e.getMessage() );
            System.out.println(e.getMessage());
            }
        }

}
