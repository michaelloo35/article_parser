package article_parser;

import java.util.LinkedList;

public class Chapter {
	int articleStartNO;
	int articleEndNO;
	String chapterTitle;
	LinkedList<String> Articles = new LinkedList<>();

	public Chapter(int startingArticleNO,String title1) {
		this.articleStartNO = startingArticleNO;
		this.articleEndNO = 0;
		this.chapterTitle = title1;
	}
	public void UpdateChapter(int endingArticleNo){
		this.articleEndNO = endingArticleNo;
	}
	public void AddArticle(String article){
		this.Articles.add(article);
	}
	
}
