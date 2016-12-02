package article_parser;

public interface IArticleOps {
	
	// takes file location and returns Article obj.
	 void readFile(String path);
	
	//method reads string "n - m" or single number "n" printing article/articles group
	 void view_articles(String range);
	
	//method prints chapter a including articles inside
	 void view_chapter(int a);
	
}
