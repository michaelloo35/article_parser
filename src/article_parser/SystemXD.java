package article_parser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class SystemXD {

	public static void main(String[] args) {
	
		try{
		File test = new File("test.txt");
		test.createNewFile();
		FileWriter fw = new FileWriter(test.getAbsoluteFile());
		String A = "konstytucja.txt";
		Parser a = new Parser(A);
		BufferedWriter bw = new BufferedWriter(fw);
		int i = 0;
		while(a.scnr.hasNext()){
			System.out.println(i++);
			System.out.println(a.scnr.nextLine());
			bw.write(a.scnr.nextLine());
			
		}
		bw.close();
		
		}
		catch (FileNotFoundException e) {
	        System.out.println("nie ma takiego pliku");
	    }
		catch (IOException e){
			System.out.println("ups cos poszlo nie tak");
		}
		
	}

}
