package com.twitter.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        /*System.out.println( "Hello World!" );
        File file = new File("C:\\sentiment_analysis\\test.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("this is line 1");
        System.out.println( "Here 1" );
        out.newLine();
        out.write("this is line 2");
        System.out.println( "Here 2" );
        out.newLine();
        out.close();*/
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Calendar cal = Calendar.getInstance();
 	   System.out.println(dateFormat.format(cal.getTime()));
    }
}
