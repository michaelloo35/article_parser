package article_parser;
import java.util.LinkedList;
import java.util.Scanner;
public interface IParser {
		// converting a string into list[preferrably skiplist](chapters) of list(articles) of strings w/o (-) unnecessary things 
		public LinkedList<Chapter> Parse(Scanner scnr);

}
