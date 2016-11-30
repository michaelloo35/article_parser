package article_parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser implements IParser {
	
	public File text;
	public Scanner scnr;
	public String textfile;
	
	
	public Parser(String path)throws FileNotFoundException{
		text = new File(path);
		scnr = new Scanner(text);
	}
	
	public LinkedList<LinkedList<String>> Parse(String file) {
		// TODO Auto-generated method stub
		return null;
	}

	//deletes (-) at the end of a line
	//private String merge_lines(String text){
		
	//}
	//deletes unnecessary things
	//private String shorten_text(String text){
		
	//}
	

}
