package mvc.model.DTO;

public class ScheduleDTO {
	private int movieNo; // 영화 번호
	private String gwan; // 관
	private String title; // 제목
	private String mDate; // 상영일
	private String showtime; // 상영시작시간
	private int remaining; // 잔여좌석 수
	
	public ScheduleDTO() {}
	public ScheduleDTO(int movieNo, String gwan, String title, String mDate, String showtime, int remaining) {
		super();
		this.movieNo = movieNo;
		this.gwan = gwan;
		this.title = title;
		this.mDate = mDate;
		this.showtime = showtime;
		this.remaining = remaining;
	}
	public int getmovieNo() {
		return movieNo;
	}
	public void setmovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getGwan() {
		return gwan;
	}
	public void setGwan(String gwan) {
		this.gwan = gwan;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	@Override
	public String toString() {
			String a = "---------------------------------------------------------------------";
			String b = "  ";
			String z = "  ";
			String y = "  ";
			String x = "  ";
			String u = "  ";
			String w = "  ";
			
			int c = Integer.toString(movieNo).length();
			for(int i=0 ; i<(3-c); i++) {
				b+="  ";
			}
			int d = gwan.length();
			for(int i=0 ; i<(3-d); i++) {
				z+="  ";
			}
			int e = title.length();
			for(int i=0 ; i<(5-e); i++ ) {
				y+="  ";
			}
			int f = mDate.length();
			for(int i=0; i<(6-f);i++) {
				x+="  ";
			}
			int g = showtime.length();
			for(int i =0; i<(4-g); i++) {
				u+="  ";
			}
			int h = Integer.toString(remaining).length();
			for(int i=0; i<(4-h); i++) {
				w+="  ";
			}
			return a + "\n" + " | " + movieNo + b + " | " + gwan + z+" | " + title +y+ " | " + mDate +x+ " | " + showtime+u+" | " +remaining+w+" | ";
		}
}
