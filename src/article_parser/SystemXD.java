package article_parser;
import java.io.FileNotFoundException;
public class SystemXD {

	public static void main(String[] args) {
		String A = "konstytucja.txt";
		Parser a = new Parser(A);
		try{
		a.read();
		}
		catch (FileNotFoundException e) {
	        System.out.println("nie ma takiego pliku");
	    }
		while(a.scnr.hasNextLine()){
		System.out.print(a.scnr.next());
	
		}
	}

}
