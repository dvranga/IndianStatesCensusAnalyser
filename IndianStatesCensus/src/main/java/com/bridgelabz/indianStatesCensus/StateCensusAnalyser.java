package com.bridgelabz.indianStatesCensus;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String SAMPLE_CSV_FILE_PATH="IndiaStateCensusData.csv";

    /*public static void main(String[] args){
        System.out.println("welcome to indiaStates census analyser simulator");
       int numberOfRecords= csvReader();
        System.out.println("numberOfRecords "+numberOfRecords);
    }*/

    public static int csvReader()throws StateAnalyserException  {
        if(!SAMPLE_CSV_FILE_PATH.contains( ".csv" ))
        {
            throw new StateAnalyserException( StateAnalyserException.ExceptionType.INVALID_EXCEPTION,"PLEASE ENTER PROPER EXTENSION FILE" );
        }
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader( Paths.get( SAMPLE_CSV_FILE_PATH ) );

            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder( reader )
                    .withType( CSVStateCensus.class )
                    .withIgnoreLeadingWhiteSpace( true )
                    .build();
            Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
            while (csvStateCensusIterator.hasNext()) {
                CSVStateCensus csvUser = csvStateCensusIterator.next();
                System.out.println( "State:" + csvUser.getState() );
                System.out.println( "State:" + csvUser.getPopulation() );
                System.out.println( "State:" + csvUser.getAreaInSqKm() );
                System.out.println( "State:" + csvUser.getDensityPerSqKm() );
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.NO_SUCH_FILE,"ENTER PROPER FILE",e);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (RuntimeException e)
        {
            throw new StateAnalyserException( StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS,"ENTER PROPER FILE NAME",e );
        }
        return count;
    }
}
