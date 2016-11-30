package article_parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser implements IParser {
	
	public File text;
	public Scanner scnr;
	public String textfile;
	
	
	public Parser(String path){
		text = new File(path);
	}
	@Override
	public LinkedList<LinkedList<String>> Parse(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	// converting file into string
	public void read()throws FileNotFoundException{
		scnr = new Scanner(text);
	}
	//deletes (-) at the end of a line
	//private String merge_lines(String text){
		
	//}
	//deletes unnecessary things
	//private String shorten_text(String text){
		
	//}
	

}
