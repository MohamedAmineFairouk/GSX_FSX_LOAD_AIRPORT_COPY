package load_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main m = new main();
		m.t("Start Load file");
		List<String> airports = m.read_file();
		m.t("airports : "+ airports.size());
		airports.forEach(E->{
			m.copyfile(E);
		});
		m.t("Load completed");
	}
	
	void t(String message) {
		
		System.out.println(new Date()+" *****Logger**** : "+message);
	}
	
	List<String> read_file(){
		List<String> output = new ArrayList<>();
		
		    try {
		      File myObj = new File("data.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        output.add(data.substring(0,4));
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File note Foud.");
		      
		    }
		   return output;
	}
	void copyfile(String name) {
		 // creating two channels
        // one input and other output   
        File src = new File("__init__.pye");
        File dest = new File("OUTPUT\\"+name+".pye");
             
        // using copy(InputStream,Path Target); method
        try {
			Files.copy(src.toPath(), dest.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        // here we are not required to have an
        // output file at the specified target.
        // same way we can use other method also.
	}

}
