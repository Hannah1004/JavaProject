package mvc.model.DTO;

public class DiscountDTO {
	
	private int num;
	private String dcName;
	private int dcRate;
	
	public DiscountDTO() {}
	public DiscountDTO(int num, String dcName, int dcRate) {
		super();
		this.num = num;
		this.dcName = dcName;
		this.dcRate = dcRate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getdcName() {
		return dcName;
	}
	public void setdcName(String dcName) {
		this.dcName = dcName;
	}
	public int getdcRate() {
		return dcRate;
	}
	public void setdcRate(int dcRate) {
		this.dcRate = dcRate;
	}
	@Override
	public String toString() {
	      
	      String a = "--------------------------------------";
	               
	      String b = "  ";
	      String z = "  ";
	      String y = " ";
	      
	      
	      String s = Integer.toString(num);
	      int c = s.length();
	      for(int i=0 ; i<(2-c); i++) {
	         b+="  ";
	      }
	      int d = dcName.length();
	      for(int i=0 ; i<=(6-d); i++) {
	         z+="  ";
	      }
	      String ss = Integer.toString(dcRate);
	      int e = ss.length();
	      for(int i=0 ; i<(6-e); i++) {
	         y+=" ";
	      }
	      
	      return a + "\n" + "|" + num + b + " | " + dcName + z+" | " + dcRate +"%"+y+ "|" ;
	}
	
}
