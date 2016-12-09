package article_parser;
import java.io.FileNotFoundException;
public class SystemMain {

	public static void main(String[] args) {

		try {
			Constitution.readFile(args[0]);
			
			for (int i = 1 ; i < args.length;i++)
				Constitution.view(args[i]);
			
		} catch (FileNotFoundException e) {
			System.out.println("nie ma takiego pliku");
		}
		  catch(IllegalArgumentException e){
			System.out.println(e);
		}
		  catch(IndexOutOfBoundsException e){
			  System.out.println("plik posiada niedozwolon¹ strukturê");
		  }
	}

}
