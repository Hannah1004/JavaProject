package mvc.model.DTO;

public class MovieDTO {
	private String title;
	private String rating;
	private String genre;
	private String runtime;
	private int price;
	
	public MovieDTO() {}

	public MovieDTO(String title, String rating, String genre, String runtime, int price) {
		super();
		this.title = title;
		this.rating = rating;
		this.genre = genre;
		this.runtime = runtime;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		String a = "---------------------------------------------------------------------------";
		   
		String b = "  ";
		String z = "  ";
		String y = "  ";
		String x = "  ";
		
		int c = title.getBytes().length;
		for(int i=0 ; i<(14-c); i++) {
			b+=" ";
		}
		int d = rating.getBytes().length;
		for(int i=0 ; i<(10-d); i++) {
			z+=" ";
		}
		int e = genre.getBytes().length;
		for(int i=0 ; i<(10-e); i++ ) {
			y+=" ";
		}
		int f = runtime.length();
		for(int i=0; i<(10-f);i++) {
			x+=" ";
		}
		
		
		return a + "\n" + "|" + title + b + " | " + rating + z+" | " + genre +y+ " | " + runtime +x+ " | " + price+"¿ø |";
	}
	
	
	
}
