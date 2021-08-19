package javaBook;

public class BeerSong {

	public static void main(String[] args) {
		int beerNum = 99;
		String beerPlurality = "bottles";
		
		while (beerNum > 0) {

			System.out.println(beerNum + " " + beerPlurality + " of beer on the wall,");
			System.out.println(beerNum + " " + beerPlurality + " of beer,");
			System.out.println("Take one down, \nPass it around,");
			beerNum -= 1;
			
			if (beerNum == 1) {
				beerPlurality = "bottle";
			}
			
			if (beerNum > 0) {
				System.out.println(beerNum + " " + beerPlurality + " of beer on the wall!");
			} else {
				System.out.println("No more bottles of beer on the wall!");
			}
		}
	}
}
