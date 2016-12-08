package article_parser;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		Chapter testC = new Chapter(0,"testchapter");
		assertEquals(testC.chapterTitle,"testchapter");
		assertEquals(testC.GetArticleStartNO(),0);
		testC.SetArticleStartNO(92);
		assertEquals(testC.GetArticleStartNO(),92);
		assertEquals(testC.GetArticleEndNO(),0);
		testC.SetArticleEndNO(493);
		assertEquals(testC.GetArticleEndNO(),493);
		testC.AddArticle("TestArticle");
		testC.AddArticle("Testarcile2");
		testC.AddArticle("Art.343_$@#_#$_#@_#");
		testC.Articles.set(1, testC.Articles.get(1) + " ThisIsTest");
		assertEquals(testC.Articles.getLast(),"Art.343_$@#_#$_#@_#");
		assertEquals(testC.Articles.get(0),"TestArticle");
		assertEquals(testC.Articles.get(1),"Testarcile2 ThisIsTest");
		
				}
	@Test(expected = FileNotFoundException.class)
    public void FileNotFoundTest() throws FileNotFoundException {
        Parser pTest = new Parser("nie ma takiego pliku");
    }
	@Test
	public void ParserT() throws FileNotFoundException{
		Parser pTest = new Parser("konstytucja.txt");
		pTest.Parse();
		Chapter TestC = pTest.textfile.get(0);
		assertEquals(TestC.chapterTitle,"Rozdzia³ I\nRZECZPOSPOLITA");
		assertEquals(TestC.Articles.get(3),"Art. 4.\n1. W³adza zwierzchnia w Rzeczypospolitej Polskiej nale¿y do Narodu. \n2. Naród sprawuje w³adzê przez swoich przedstawicieli lub bezpoœrednio. ");
		assertEquals(TestC.Articles.getLast(),"Art. 29.\nStolic¹ Rzeczypospolitej Polskiej jest Warszawa. ");
		TestC = pTest.textfile.getLast();
		assertEquals(TestC.chapterTitle,"Rozdzia³ XIII\nPRZEPISY PRZEJŒCIOWE I KOÑCOWE");
		assertEquals(TestC.Articles.get(6),"Art. 242.\nTrac¹ moc: \n1) ustawa konstytucyjna z dnia 17 paŸdziernika 1992 r. o wzajemnych stosunkach miêdzy w³adz¹ ustawodawcz¹ i wykonawcz¹ Rzeczypospolitej Polskiej oraz o samorz¹dzie terytorialnym (Dz.U. Nr 84, poz. 426, z 1995 r. Nr 38, poz. 184 i Nr 150, poz. 729 oraz z 1996 r. Nr 106, poz. 488), \n2) ustawa konstytucyjna z dnia 23 kwietnia 1992 r. o trybie przygotowania i uchwalenia Konstytucji Rzeczypospolitej Polskiej (Dz.U. Nr 67, poz. 336 i z 1994 r. Nr 61, poz. 251). ");
	} 
	@Test(expected = FileNotFoundException.class)
	public void ConstitutionTest0() throws FileNotFoundException{
		Constitution.readFile("NieMaTakiegoPliku.test");
	}
	@Test(expected = IllegalArgumentException.class)
	public void ConstitutionTest() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("kofwaok");
	}
	public void ConstitutionTest2() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("TNieJestLiter¹AaniCaniR");
	}
	public void ConstitutionTest3() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("chapterniewiemjaki");
	}
	public void ConstitutionTest5() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("a-nieweiem-5");
	}
	public void ConstitutionTest6() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("A5--6");
	}
	public void ConstitutionTest7() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("A(0,504)");
	}
	public void ConstitutionTest8() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("Article666");
	}
	public void ConstitutionTest9() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("Chapter14");
	}
	public void ConstitutionTest10() throws FileNotFoundException{
		Constitution.readFile("konstytucja.txt");
		Constitution.view("c--");
	}


}
