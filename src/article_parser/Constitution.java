package article_parser;

import java.io.FileNotFoundException;

public class Constitution {
	private static Parser File = null;

	public static void readFile(String path) throws FileNotFoundException {
		File = new Parser(path);
		File.Parse();
	}

	public static void view(String argument) {
		if (argument.matches("^c.*|^C.*|^R.*|r.*"))
			view_chapter(argument);
		else if (argument.matches("^a.*|^A.*"))
			view_articles(argument);
		else
			throw new IllegalArgumentException("Niepoprawny argument wybierz rozdzia³ zaczynaj¹c od litery c lub artyku³/y od litery a");
	}

	private static void view_articles(String argument) {
		argument = argument.replaceAll("[^\\d,-]", "");
		if (argument.isEmpty())
			throw new IllegalArgumentException("brak numeru/zakresu artyku³ów");
		int a, tmp2;
		if (argument.contains(",") || argument.contains("-")) {					// sprawdzamy czy to zakres
			int b;
			String[] tmp = argument.split("[,-]");
			if (tmp.length < 2 || tmp[0].isEmpty() || tmp[1].isEmpty())
				throw new IllegalArgumentException(
						"brak numeru lub z³y format zakresu artyku³ów zakres powinien byæ rozdzielony pojedyñczym - lub ,");
			a = Integer.parseInt(tmp[0]);
			b = Integer.parseInt(tmp[1]);
			if (b < a) { // swap
				a += b;
				b = a - b;
				a -= b;
			}
			if (a <= 0 || b > 243)
				throw new IllegalArgumentException("niepoprawny numer artyku³u(taki artyku³ nie istnieje)");
			for (Chapter c : File.textfile) {
				if (!(b < c.GetArticleStartNO()) || !(a > c.GetArticleEndNO())) {
					tmp2 = c.GetArticleStartNO();
					for (String s : c.Articles) {
						if (tmp2 >= a && tmp2 <= b)
							System.out.println(s);
						tmp2++;
					}
				}
			}
		} else {
			a = Integer.parseInt(argument);
			if (a <= 0 || a > 243)							// jesli nie zakres to pewnie pojedynczy artyku³
				throw new IllegalArgumentException("niepoprawny numer artyku³u(taki artyku³ nie istnieje)");	
			for (Chapter c : File.textfile) {
				if (!(a < c.GetArticleStartNO()) || !(a > c.GetArticleEndNO())) {
					tmp2 = c.GetArticleStartNO();
					for (String s : c.Articles) {
						if (tmp2 == a)
							System.out.println(s);
						tmp2++;
					}
				}
			}
		}

	}

	private static void view_chapter(String argument) throws NumberFormatException {
		int a;
		argument = argument.replaceAll("[^\\d]", "");
		if (argument.isEmpty())
			throw new IllegalArgumentException("brak numeru rozdzia³u");
		a = Integer.parseInt(argument);
		if (a < 1 || a >13 )
			throw new IllegalArgumentException("nie ma takiego rozdzia³u");
		a--;
		
		System.out.println(File.textfile.get(a).chapterTitle);
		for (String s : File.textfile.get(a).Articles)
			System.out.println(s);
	}
}
