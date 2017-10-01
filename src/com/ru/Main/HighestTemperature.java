package com.ru.Main;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class HighestTemperature {
	
	public static void main(String[] args)
	{
		HighestTemperature ob = new HighestTemperature();
		ob.testHighestTemperatureInDay();
		ob.testHighestTemperatureInManyDays();
			
	}
	private void testHighestTemperatureInManyDays(){
		
		CSVRecord largest = hottestTemperatureInManyDays();
		System.out.println("Hottest Temperature is" + largest.get("TemperatureF") + "at" + largest.get("DateUTC"));
		
		
	}
	private CSVRecord hottestTemperatureInManyDays(){
		CSVRecord largestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()){
		  FileResource fr = new FileResource(f);
		  CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
			
		}
		
	return largestSoFar;	
	}
	
	private void testHighestTemperatureInDay(){
		FileResource fr = new FileResource();
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("Hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));

		
	}
	private CSVRecord hottestHourInFile(CSVParser csvParser){
		
		CSVRecord largestSoFar = null;
		for(CSVRecord currentRow : csvParser){
			
			if(largestSoFar == null){
				largestSoFar = currentRow;
				
			}
			else{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if(currentTemp > largestTemp){
					largestSoFar = currentRow;
				}
				
			
		}
		
		
	}
		
		return largestSoFar;
  }
}
