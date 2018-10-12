package mvc.model.DTO;

public class MyMovieDTO {

	private int myNo; // 번호
	private int movieNo;
	private String phNo; // 핸드폰 번호
	private int people; // 인원수
	private int myPrice; // 최종 가격
	
	public MyMovieDTO() {	}

	public MyMovieDTO(int myNo, int movieNo, String phNo,int people, int myPrice) {
			super();
			this.myNo = myNo;
			this.movieNo = movieNo;
			this.phNo = phNo;
			this.people = people;
			this.myPrice = myPrice;
		}
	
	public int getMyNo() {
		return myNo;
	}
	
	public void setMyNo(int myNo) {
		this.myNo = myNo;
	}
	
	public int getMovieNo() {
		return movieNo;
	}
	
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	
	public String getPhNo() {
		return phNo;
	}
	
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getMyPrice() {
		return myPrice;
	}
	
	public void setMyPrice(int myPrice) {
		this.myPrice = myPrice;
	}

@Override
	public String toString() {
		return myNo +  " | " +movieNo + " | " + phNo +   " | " + people
				+  " | " + myPrice;
	}
	
	
}
