package article_parser;

import java.util.LinkedList;

public class Chapter {
	int articleStartNO;
	int articleEndNO;
	String chapterTitle1;
	String chapterTitle2;
	LinkedList<String> Articles = new LinkedList<>();

	public Chapter(int startingArticleNO,String title1,String title2) {
		this.articleStartNO = startingArticleNO;
		this.articleEndNO = 0;
		this.chapterTitle1 = title1;
		this.chapterTitle2 = title2;
	}
	public void UpdateChapter(int endingArticleNo){
		this.articleEndNO = endingArticleNo;
	}
	public void AddArticle(String article){
		this.Articles.add(article);
	}
	
}
