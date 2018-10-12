package mvc.model.DTO;

public class TotalDTO {
	private int myNo; // ��ȣ    mymovie
	private String phNo; // �ڵ��� ��ȣ	mymovie 
	private int people; // �ο���	mymovie
	private int myPrice; // ���� ����	
	private String title; // ���� movieSchedule
	private String gwan; // ��	movieSchedule
	private String mDate; // ����	movieSchedule
	private String showtime; // �󿵽��۽ð�	movieSchedule
	
	public TotalDTO() {}
	
	public TotalDTO(int myNo, String phNo, int people, int myPrice, String title, String gwan, String mDate,
			String showtime) {
		super();
		this.myNo = myNo;
		this.phNo = phNo;
		this.people = people;
		this.myPrice = myPrice;
		this.title = title;
		this.gwan = gwan;
		this.mDate = mDate;
		this.showtime = showtime;
	}

	public int getMyNo() {
		return myNo;
	}

	public void setMyNo(int myNo) {
		this.myNo = myNo;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGwan() {
		return gwan;
	}

	public void setGwan(String gwan) {
		this.gwan = gwan;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	@Override
	public String toString() {
		   
	      String a = "--------------------------------------------------------------------------------------------------";
	         
	      String b = "  ";
	      String z = "  ";
	      String y = "  ";
	      String x = "  ";
	      String w = "  ";
	      String v = "  ";
	      String u = "  ";
	      String t = "  ";
	      
	      int c = Integer.toString(myNo).length();
	      for(int i=0 ; i<(4-c); i++) {
	         b+="  ";
	      }
	      int d = phNo.length();
	      for(int i=0 ; i<(10-d); i++) {
	         z+="  ";
	      }
	      int e = Integer.toString(people).length();
	      for(int i=0 ; i<(2-e); i++ ) {
	         y+="  ";
	      }
	      int f = Integer.toString(myPrice).length();
	      for(int i=0; i<(6-f);i++) {
	         x+="  ";
	      }
	      int g = title.length();
	      for(int i=0; i<(6-g);i++) {
	         w+="  ";
	      }
	      int h = gwan.length();
	      for(int i=0; i<(2-h);i++) {
	         v+="  ";
	      }
	      int j = mDate.length();
	      for(int i=0; i<(4-i);i++) {
	         u+="  ";
	      }
	      int k = mDate.length();
	      for(int i=0; i<(6-k);i++) {
	         t+="  ";
	      }
	      
	      return a + "\n" + "|" + myNo + b + " | " + phNo + z + " | " + people + y + " | " + myPrice + x + " | " + title + w +" | "+ gwan + v + "|" + mDate + u +" | "+ showtime+ t+ " | ";

	}
}
