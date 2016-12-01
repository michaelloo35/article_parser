package article_parser;
import java.io.FileNotFoundException;
public class SystemXD {

	public static void main(String[] args) {

		try {
			String A = "konstytucja.txt";
			Parser a = new Parser(A);
			a.Parse();
			Chapter test;
			test = a.textfile.getFirst();
			System.out.println(test.chapterTitle1);
		} catch (FileNotFoundException e) {
			System.out.println("nie ma takiego pliku");
		}
	

	}

}
