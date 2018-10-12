package mvc.View;

import java.util.List;
import java.util.Scanner;

import mvc.Controller.MovieController;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public class MainView {
	private static	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MainMenu();
	}
	
	public static void MainMenu() {
		while(true){
			try {
				System.out.println("");
				System.out.println("         ****�޴�����****");
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("");
				System.out.println("1.ȸ��   |   2. ������  |  3. ����");
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("");
				System.out.print("\n�� ���Ͻô� �޴��� ��ȣ�� �Է��ϼ��� ���  ");
				int choiceMenu = Integer.parseInt(sc.next());
				switch(choiceMenu){
					case 1 : member();		 break;
					case 2 : manager();       break;
					case 3 :
						System.out.println("\n�ءء� ���α׷� �����մϴ�.***");
						System.exit(0); //���α׷����� ����.
						break;
					default:
						System.out.println("�߸��Ǿ����ϴ�. �ٽ��Է��� �ּ���");
				}
			}catch(NumberFormatException e) {
				System.out.println("�޴��� ���ڸ� �����մϴ�.");
			}
		}//while�� ��
	}
	
	private static void member() {
		while(true) {
			try {
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("");
				System.out.println("1.��ȭ ����  |  2. ��ȭ ���� Ȯ��  |  3. ��ȭ ��� |  4. ó������  |  5.����");
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("");
				System.out.print("\n�� ���Ͻô� �޴��� ��ȣ�� �Է��ϼ��� ���  ");
				int choice = Integer.parseInt(sc.next());
				switch(choice) {
				  case 1 : movieTicketing();    break;
				  case 2 : myMovieCheck();    break;
				  case 3 : movieCancle();        break;
				  case 4 : MainMenu(); 	       break;
				  case 5 : 
					  System.out.println("\n�ءء� ���α׷� �����մϴ� �ءء�");
					  System.exit(0);   break;
				  default:
					  System.out.println("\n�ءء� �߸��Ǿ����ϴ�. �ٽ��Է����ּ��� �ءء�\n");
				}
			}catch(NumberFormatException e) {
				System.out.println("\n�ءء� �޴��� ���ڸ� �����մϴ� �ءء�\n");
			}
		}//while�� ��
	}
	
	private static void movieTicketing() {
		//��ȭ ���� �����ֱ�
		MovieController.allMovieInfo();
		
		System.out.print("\n�� ���� ���� ��ȭ ������ �Է��ϼ��� ���  ");
		String title = sc.next();
		List<ScheduleDTO> list =	MovieController.selectMovieSchedule(title);
		if(list ==null || list.size()==0) {
			movieTicketing();
		}
		int a = 0;
		int movieNo = 0;
		do {
			System.out.print("\n�� ������ ��ȣ�� �Է��ϼ���  ���  ");
			try {
				movieNo = Integer.parseInt(sc.next());
			} catch (NumberFormatException e) {
				System.out.print("\n�ءء� ���Ź�ȣ�� ���ڸ� �Է� �����մϴ� �ءء�\n");
				continue;
			}
			for (int i = 0; i<list.size();i++) {
				if (list.get(i).getmovieNo() == movieNo) {
					a=1;
					break;
				} else {
					a=0;
				}
			}
			if(a==0) {
				System.out.println("\n�ءء� ��ȣ�� �߸� �Է��ϼ̽��ϴ� �ءء�\n");
			}
		} while(a==0);
		
		
		
		int people = 0;
		do {
			System.out.print("\n�� �ο����� ��Ȯ�� �Է��ϼ���  ���  ");
			
			try {
				String scv = sc.next();
				people = Integer.parseInt(scv);
				int aa=0;
				for(int i = 1 ; i < list.size() ; i++) {
				 if(list.get(i).getmovieNo()==movieNo) {
				     aa=i;
					 break;
			      	}else {
					   aa=0;				   
				   }			 	
				}
				if(list.get(aa).getRemaining() < people || people==0) {
					System.out.println("\n�ءء� ���Ű��� �ο��ʰ� �ءء�\n");
					continue;
				}
        			break;
			} catch (NumberFormatException e) {
				System.out.print("\n�ءء� �߸� �Է��ϼ̽��ϴ� �ءء�\n");
				continue;
			}
			
		} while(true);
		
		
		MovieController.discountList();
		int discount = 0;
		do {
			System.out.print("\n�� ���ι�ȣ�� �Է����ּ���.  ���  ");
			try {
				discount = Integer.parseInt(sc.next());
				if(discount !=1 && discount !=2 && discount !=3 ) {
				System.out.println("\n�ءء� ��Ȯ�� ��ȣ�� �Է����ּ��� �ءء�\n");
				continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n�ءء� ��ȣ�� �Է����ּ��� �ءء�\n");
				continue;
			}
			
		} while(true);
		
		String number = null;
		do {
			System.out.print("\n�� �ڵ��� ��ȣ�� �Է��ϼ���(ex)12341234)  ���   ");
			try {
				number = sc.next();
			if(number.length() !=8) {
				System.out.println("\n�ءء� �ڵ�����ȣ�� 8�� �Է����ּ��� �ءء�\n");
				continue;
			}
				Integer.parseInt(number);
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n�ءء� �߸� �Է��ϼ̽��ϴ� �ءء�\n");
				continue;
			}
		} while(true);
		
		int total = MovieController.totalPrice(movieNo, people, discount);

		if(check() == true) {
			MyMovieDTO myMovie = new MyMovieDTO(0, movieNo, number,people,total);
			MovieController.movieInsert(myMovie);
		}else {
			 System.out.println("\n�ءء� ���Ű� ���� �˴ϴ� �ءء�\n");
			 member();
		}
	}
	 
	 private static boolean check() {
		while(true) {
			System.out.print(" \n�� ���� �Ͻðڽ��ϱ�?(Y or N)   ���  ");
			String check = sc.next();
			if(check.equals("Y") || check.equals("y") || check.equals("��") ) {
				return true;
			} else if(check.equals("N")||check.equals("n") || check.equals("��")) {
				return false;
			} else {
				System.out.println("\n�ءء� �ٽ� �Է����ּ��� �ءء�\n");
			}
		}
	 }
	
	public static void myMovieCheck() {
		System.out.print("\n�� �ڵ��� ��ȣ�� �Է��ϼ���   ���  ");
		String phNo = sc.next();
		List<TotalDTO> list = MovieController.myMovieCheck(phNo);
		if(list == null || list.size()==0) {
			myMovieCheck();
		}
	}
	
	private static void movieCancle() {
		System.out.print("\n�� �ڵ��� ��ȣ�� �Է��ϼ���   ���   ");
		String phNo = sc.next();
		List<TotalDTO> list = MovieController.myMovieCheck(phNo);
		if(list == null || list.size()==0) {
			movieCancle();
		}
		int b = 0;
		int myNo = 0;
		if(list != null) {
         do {
	  	   System.out.print("\n�� ����� ��ȣ�� �Է��ϼ���   ���   ");
	  	    try {
		      myNo = Integer.parseInt(sc.next());
	  	   }catch(NumberFormatException e) {
	  		  System.out.print("\n�ءء� ��ҹ�ȣ�� ���ڸ� �Է� �����մϴ� �ءء�\n");
	          continue;
	  	   }
	  	for (int i = 0; i<list.size();i++) {
		  if (list.get(i).getMyNo() == myNo) {
			 b=1;
			 MovieController.movieCancle(phNo, myNo);
			 break;
			} else {
			    b=0;	
			    continue;
			  }
		    }
          } while(b==0);
	    }
	}

	private static void managerMenu() {
		while(true) {
			try {
				System.out.println("                                  ****�޴�����****");
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("");
				System.out.println("1.��ȭ ���� �߰�  |  2. ��ȭ ������ �߰�  | 3. ��ü���ź��� | 4. ó������  |  5. ����");
				System.out.println("");
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");

				int choice = Integer.parseInt(sc.next());
				switch(choice) {
				case 1 : InfoInsert();          break;
				case 2 : scheduleInsert();   break;
				case 3 : viewAll();   break;
				case 4 : MainMenu();        break;
				case 5 : 
					System.out.println("\n�ءء� ���α׷� �����մϴ� �ءء�\n");
					System.exit(0);
				default:
					System.out.println("\n �ءء��߸��Ǿ����ϴ�. �ٽ��Է����ּ���ءء� \n");
				}
			}catch(NumberFormatException e) {
				System.out.println("\n�ءء� ���ڸ� �����մϴ� �ءء�\n");
			}
		}
	}
	
	private static void manager() {
		System.out.print("    ��й�ȣ�� �Է��ϼ��� ��� ");
		String password = sc.next();
		if(password.equals("1234")) {
			managerMenu();
		}else {
			System.out.println("\n �ءء� ��й�ȣ�� Ʋ�Ƚ��ϴ� �ءء�\n");
			MainMenu();
		}
	}
	
	private static void InfoInsert() {
		System.out.print("\n�� ������ �Է����ּ��� ���  ");
		String title = sc.next();
		System.out.print("\n�� ����� �Է����ּ��� ���  ");
		String rating = sc.next();
		System.out.print("\n�� �帣�� �Է����ּ��� ���  ");
		String genre = sc.next();
		System.out.print("\n�� �� �󿵽ð��� �Է����ּ��� ���  ");
		String runtime = sc.next();
		
		int price = 0;
		do {
			System.out.print("\n�� ������ �Է����ּ��� ���  ");
			try {
				price = Integer.parseInt(sc.next());
				if (price < 0 && price > 20000) {
					System.out.print("�߸� �Է��ϼ̽��ϴ�. ���ڷ� ");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("�߸� �Է��ϼ̽��ϴ�. ���ڷ� ");
				continue;
			}
			
		} while(true);
		
		
		
		
		MovieController.InfoInsert(new MovieDTO(title, rating, genre, runtime, price));
	}
	
	private static void scheduleInsert() {

		String title = null;
		do {
			System.out.print("\n�� �߰��� ��ȭ������ �Է����ּ��� ���  ");
			title = sc.next();
			if(jemokCheck(title) == false) {
				System.out.println(title+" ��� ������ ��ȭ�� ã�� �� �����ϴ�. ��Ȯ�� �Է����ּ���.");
				continue;
			}
			break;
		} while (true);
		
	
		System.out.print("\n�� �߰��� ���� �Է����ּ��� ���  ");
		String gwan = sc.next();
		System.out.print("\n�� �߰��� ��ȭ ������ �Է����ּ��� ���  ");
		String mDate = sc.next();
		System.out.print("\n�� �߰��� ��ȭ �󿵽ð��� �Է����ּ��� ���  ");
		String showtime = sc.next();

		int remaining = 0;
		do {
			System.out.print("\n�� �߰��� ��ȭ ���¼��� �Է����ּ��� ���  ");
			try {
				remaining = Integer.parseInt(sc.next());
				if (remaining<0 && remaining > 50) {
					System.out.print("\n��ȭ���� �ִ� �¼��� 50�¼��Դϴ�. ");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n�¼��� ���ڷ� �Է��ϼ���. ");
				continue;
			}
		} while(true);
	
		MovieController.scheduleInsert(new ScheduleDTO(0,title, gwan, mDate, showtime, remaining));
	}
	
	private static void viewAll() {
		int a= 0;
		List<TotalDTO> list = MovieController.viewAll();
		for(int i = 0 ; i < list.size(); i++) {
			 int b= list.get(i).getMyPrice();
			 a = a + b;
		   }
		System.out.println("\n�� ������  :  " + a + " �� �Դϴ�.\n");
		}
	   	
	private static boolean jemokCheck(String title) {
		boolean b = MovieController.jemokCheck(title);
		return b;
	}
}
