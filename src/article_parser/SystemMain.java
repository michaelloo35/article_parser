package article_parser;
import java.io.FileNotFoundException;
public class SystemMain {

	public static void main(String[] args) {

		try {
			String A = "konstytucja.txt";
			Parser a = new Parser(A);
			a.Parse();
			for ( Chapter i : a.textfile){
				System.out.println(i.chapterTitle);
				for (String s : i.Articles){
					System.out.println(s);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("nie ma takiego pliku");
		}
	}

}
