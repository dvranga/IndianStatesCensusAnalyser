package com.bridgelabz.indianStatesCensus;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String SAMPLE_CSV_FILE_PATH="IndiaStateCensusData.csv";

    public static void main(String[] args) throws IOException {
        System.out.println("welcome to indiaStates census analyser simulator");
       int numberOfRecords= csvReader();
        System.out.println("numberOfRecords "+numberOfRecords);

    }

    public static int csvReader() throws IOException {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader( Paths.get( SAMPLE_CSV_FILE_PATH ) );
        ) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder( reader )
                    .withType( CSVStateCensus.class )
                    .withIgnoreLeadingWhiteSpace( true )
                    .build();
            Iterator<CSVStateCensus> csvStateCensusIterator = csvToBean.iterator();
            while (csvStateCensusIterator.hasNext()) {
                CSVStateCensus csvUser = csvStateCensusIterator.next();
                System.out.println("State:"+csvUser.getState());
                System.out.println("State:"+csvUser.getPopulation());
                System.out.println("State:"+csvUser.getAreaInSqKm());
                System.out.println("State:"+csvUser.getDensityPerSqKm());
                count++;
            }


        }

        return count;
    }
}
