package article_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Parser implements IParser {
	public int lolo = 0;
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
		boolean skip = true; // skipujemy pierwsz¹ czêœæ dokumentu // PODZIELIC NA POD METODY
		boolean isFirst = false; // przed dodaniem pierwszego artykulu w kazdym
									// chapterze nie mozemy inkrementowac
									// articleIterator
		while (this.scnr.hasNext() == true) {
			temp = this.scnr.nextLine();
			if (temp.matches("^2...-..-..") || temp.matches("^©Kancelaria Sejmu"));
				 // trafilsimy na niepotrzebne wyraznie pomijamy
										
			else if (!skip) {
				if (temp.matches("^Rozdzia³.*")) { // sprawdzamy czy trafilismy
													// jak rozdzial jestli tak
													// tworzymy nowego node'a i
													// stawiamy na nim iterator
					chapterIterator++;
					if (chapterIterator > 1) // jesli jest to conajmniej drugi
						this.textfile.add(temp2);
					boolean isNextArt = false;
					while(!isNextArt){
						temp += scnr.nextLine();
						if (scnr.hasNext("Art.*")) isNextArt = true;
					}
												// chapter musimy dodaæ
												// poprzedni gotowy chapter do
												// listy
					articleIterator++;
					temp2 = new Chapter(articleIterator,temp); // tworzymy nowy chapter
					isFirst = true;
				}
				else if (temp.matches("^Art.*")) {
					if (isFirst == false)	{				// w pierwszym artykule rozdzia³u nie mozemy zwiekszac licznika
						articleIterator++;
						temp2.Articles.add(temp);
						temp2.SetArticleEndNO(articleIterator);
					}
					else {
						isFirst = false;
						temp2.Articles.add(temp);
					}
				}
				else{
				temp2.Articles.set(temp2.Articles.size()-1, temp2.Articles.getLast() + temp);
				}
			} else {										// skipowanie
				if (this.scnr.hasNext("Rozdzia³"))
					skip = false;
			}
		}
		chapterIterator++;
		this.textfile.add(temp2);
	}

}
