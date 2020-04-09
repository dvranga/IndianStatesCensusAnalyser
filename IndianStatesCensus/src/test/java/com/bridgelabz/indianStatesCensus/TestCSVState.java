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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
