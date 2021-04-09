package com.qa.exceldataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVFileReader {
	
	public String CSVData(String Data,String file2) throws IOException
	{
		BufferedReader input = null;
		  File file = new File(file2);
		  input = new BufferedReader(new FileReader(file));
		  CSVParser parser=CSVParser.parse(input, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		  String data=null;
		  String values = null;
		  int i=0;
		  for(CSVRecord record:parser)
		  {
			   values=record.get(Data);
			   data=values;
			   i=i+1;
		  }
		  return data;
	}
}


	