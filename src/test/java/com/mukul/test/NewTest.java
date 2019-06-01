package com.mukul.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.mukul.utils.Mukul;

public class NewTest {
  @Test
  public void Test() {
	  try {
		  Mukul mukul=new Mukul();
		  JSONParser parser=new JSONParser();
		  //JSONObject object=(JSONObject) parser.parse(new FileReader(System.getProperty("user.dir")+"/jsonfile.json"));
		 // mukul.createPojos(object, System.getProperty("user.dir")+"/src/main/java", "com.mukul.pojoResponse", "Root");
		  JSONArray array=(JSONArray) parser.parse(new FileReader(System.getProperty("user.dir")+"/jsonfile.json"));
		  mukul.generatePojos(array, System.getProperty("user.dir")+"/src/main/java", "com.mukul.pojoResponse", "Root",null);
	  } catch (JsonIOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonSyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
}
