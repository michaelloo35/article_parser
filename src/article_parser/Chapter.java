package article_parser;

import java.util.LinkedList;

public class Chapter {
	private int articleStartNO;
	private int articleEndNO;
	public String chapterTitle;
	public LinkedList<String> Articles = new LinkedList<>();
	
	public void SetArticleStartNO(int neww){
		this.articleStartNO = neww;
	}
	public void SetArticleEndNO(int neww){
		this.articleEndNO = neww;
	}
	public int GetArticleStartNO(){
		return this.articleStartNO;
	}
	public int GetArticleEndNO(){
		return this.articleEndNO;
	}
	Chapter(int startingArticleNO,String title1) {
		this.articleStartNO = startingArticleNO;
		this.articleEndNO = 0;
		this.chapterTitle = title1;
	}
	public void AddArticle(String article){
		this.Articles.add(article);
	}
	
}
