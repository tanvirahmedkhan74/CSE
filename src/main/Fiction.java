package main;

public class Fiction implements Genre {

	private final String GENRE;
	private String subGenre;
	private static double genreDiscount = 0.09;
	
	public Fiction(String subGenre) {
		this.GENRE = "Fiction";
		this.subGenre = subGenre;
	}
	
	public void setGenreDiscount(double discount) {
		this.genreDiscount = discount;
	}
	
	@Override
	public double getGenreDiscount() {
		return genreDiscount;
	}

	@Override
	public String getSubGenre() {
		return subGenre;
	}

	@Override
	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	@Override
	public String getGenre() {
		return GENRE;
	}
}
