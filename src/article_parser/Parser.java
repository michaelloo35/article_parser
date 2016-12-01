package article_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Parser implements IParser {

	public File text;
	public Scanner scnr;
	public LinkedList<Chapter> textfile;

	public Parser(String path) throws FileNotFoundException {
		this.text = new File(path);
		this.scnr = new Scanner(text);
		this.textfile = null;
	}

	public void Parse() {
		this.textfile = new LinkedList<Chapter>();
		int articleIterator = 1;
		int chapterIterator = 0;
		String temp;
		Chapter temp2 = new Chapter(666, "nie dziala", "nie dziala");
		String temp3;
		boolean skip = true; // skipujemy pierwsz¹ czêœæ dokumentu
		boolean isFirst = false; // przed dodaniem pierwszego artykulu w kazdym chapterze nie mozemy inkrementowac articleIterator
		while (this.scnr.hasNext() == true) {
			temp = this.scnr.nextLine();
			if (temp.matches("^2...-..-..") || temp.matches("^©Kancelaria Sejmu"))
				this.scnr.nextLine(); // trafilsimy na niepotrzebne wyraznie
										// pomijamy
			else if (!skip) {
				if (temp.matches("^Rozdzia³.*")) { // sprawdzamy czy trafilismy jak rozdzial jestli tak tworzymy nowego node'a i stawiamy na nim iterator
					chapterIterator++;
					temp3 = this.scnr.nextLine();
					if (chapterIterator > 1)		// jesli jest to conajmniej drugi chapter musimy dodaæ poprzedni gotowy chapter do listy
						this.textfile.add(temp2);
					temp2 = new Chapter(articleIterator, temp, temp3); // tworzymy nowy chapter do ktorego bedziemy dodawali artykuly
					temp = this.scnr.nextLine();
					isFirst = true;
				}
				if (temp.matches("^Art.*"))
					if (isFirst == false)
						articleIterator++; 
					else
						isFirst = false;
				while (temp.matches("-$")) // sprawdzamy jesli artku³ sie // MUSZE ZMIENIC BO PO ODNALEZIENIU ARTYKU£U DODAJE KOLEJNY LINIE JAKO NOWE ARTYKU£Y ZLE !
											// I JESZCZE NIE MA SCIAGAC PUNKTOW DO NOWYCH LINI!!
											// ciagnie na pare lini to zklejamy je napewno nie bd tak ze konczy
											// sie na - i w nast lini jest cos niepotrzebneg
					temp = temp += this.scnr.nextLine();
				temp2.AddArticle(temp); // dodajemy artyku³
				temp2.UpdateChapter(articleIterator);
			} else {
				if (this.scnr.hasNext("Rozdzia³"))
					skip = false;
			}
		}
	}


}
