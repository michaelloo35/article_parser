package article_parser;

import java.io.FileNotFoundException;

public class SystemXD {

	public static void main(String[] args) {

		try {
			String A = "konstytucja.txt";
			Parser a = new Parser(A);
			int i = 0;
			while (a.scnr.hasNext()) {
				System.out.println(a.scnr.nextLine());
				System.out.println(i++);
			}

		} catch (FileNotFoundException e) {
			System.out.println("nie ma takiego pliku");
		}

	}

}
