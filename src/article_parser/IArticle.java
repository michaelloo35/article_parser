package article_parser;

public interface IArticle {
	
	// takes file location and returns Article obj.
	public void read_file(String path);
	
	//method reads string "n - m" or single number "n" printing article/articles group
	public void view_articles(String range);
	
	//method prints chapter a including articles inside
	public void view_chapter(int a);
	
}
