package article_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser implements IParser {
	private File text;
	private Scanner scnr;
	public LinkedList<Chapter> textfile;

	public Parser(String path) throws FileNotFoundException {
		this.text = new File(path);
		this.scnr = new Scanner(text);
		this.textfile = null;
	}

	public void Parse() {
		this.textfile = new LinkedList<Chapter>();
		int articleIterator = 0;
		int chapterIterator = 0;
		String temp;
		Chapter temp2 = new Chapter(666, "nie dziala");
		boolean skip = true; // skipujemy pierwsz¹ czêœæ dokumentu 
		boolean isFirst = false; // przed dodaniem pierwszego artykulu w kazdym
									// chapterze nie mozemy
									// inkrementowacarticleIterator

		while (this.scnr.hasNext() == true) { // petla porownujaca g³ówne wzorce
			temp = this.scnr.nextLine();
			if (temp.matches("^2...-..-..") || temp.matches("^©Kancelaria Sejmu"))
				; // trafilsimy na niepotrzebne wyraznie pomijamy

			else if (!skip) {
				if (temp.matches("^Rozdzia³.*")) { // sprawdzamy czy trafilismy

					chapterIterator++;

					if (chapterIterator > 1) // jesli jest to conajmniej drugi
						this.textfile.add(temp2);

					temp2 = CreateChapter(articleIterator, temp);
					articleIterator++;
					isFirst = true;

				} else if (temp.matches("^Art.*")) {
					if (isFirst == false) // w pierwszym artykule rozdzia³u
											// kazdego rozdzia³u nie mozemy
											// zwiekszac licznika w reszcie tak
						articleIterator++;
					else
						isFirst = false;
					AddNewArticleToChapter(temp2, articleIterator, temp);
				} else {
					AddLineToArticle(temp2, temp);
				}
			} else { // skipowanie
				if (this.scnr.hasNext("Rozdzia³"))
					skip = false;
			}
		}
		chapterIterator++;
		this.textfile.add(temp2); // na koniec poza petla musimy dodac ostatni
									// chapter
	}

	private Chapter CreateChapter(int articleIterator, String title) {
		boolean isNextArt = false;
		while (!isNextArt) {
			title += ("\n" + scnr.nextLine());
			if (scnr.hasNext("Art.*")) // pobieramy linie az napotkamy artyku³
				isNextArt = true;
		}
		articleIterator++;
		return new Chapter(articleIterator, title); // tworzymy nowy chapter
	}

	private void AddNewArticleToChapter(Chapter chapter, int articleIterator, String article) {
		if (!this.scnr.hasNext("[0-9].*"))
			article = article + "\n";
		chapter.Articles.add(article);
		chapter.SetArticleEndNO(articleIterator);
	}

	private void AddLineToArticle(Chapter chapter, String line) {
		if (line.matches(".*-$"))
			line = line.substring(0, line.length() - 1);
		if (line.matches("^\\d[)].*|^\\d[.].*"))
			line = "\n" + line;
		chapter.Articles.set(chapter.Articles.size() - 1, chapter.Articles.getLast() + line);
	}
}
