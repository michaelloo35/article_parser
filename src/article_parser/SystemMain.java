package article_parser;
import java.io.FileNotFoundException;
public class SystemMain {

	public static void main(String[] args) {

		try {
			String A = "konstytucja.txt";
			Constitution.readFile(A);
			Constitution.view("");
			
		} catch (FileNotFoundException e) {
			System.out.println("nie ma takiego pliku");
		}
		  catch(IllegalArgumentException e){
			System.out.println(e);
		}
	}

}
