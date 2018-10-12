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
				System.out.println("         ****메뉴선택****");
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("");
				System.out.println("1.회원   |   2. 관리자  |  3. 종료");
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("");
				System.out.print("\n♥ 원하시는 메뉴의 번호를 입력하세요 ≫≫  ");
				int choiceMenu = Integer.parseInt(sc.next());
				switch(choiceMenu){
					case 1 : member();		 break;
					case 2 : manager();       break;
					case 3 :
						System.out.println("\n※※※ 프로그램 종료합니다.***");
						System.exit(0); //프로그램강제 종료.
						break;
					default:
						System.out.println("잘못되었습니다. 다시입력해 주세요");
				}
			}catch(NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
		}//while문 끝
	}
	
	private static void member() {
		while(true) {
			try {
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("");
				System.out.println("1.영화 예매  |  2. 영화 예매 확인  |  3. 영화 취소 |  4. 처음으로  |  5.종료");
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("");
				System.out.print("\n♥ 원하시는 메뉴의 번호를 입력하세요 ≫≫  ");
				int choice = Integer.parseInt(sc.next());
				switch(choice) {
				  case 1 : movieTicketing();    break;
				  case 2 : myMovieCheck();    break;
				  case 3 : movieCancle();        break;
				  case 4 : MainMenu(); 	       break;
				  case 5 : 
					  System.out.println("\n※※※ 프로그램 종료합니다 ※※※");
					  System.exit(0);   break;
				  default:
					  System.out.println("\n※※※ 잘못되었습니다. 다시입력해주세요 ※※※\n");
				}
			}catch(NumberFormatException e) {
				System.out.println("\n※※※ 메뉴는 숫자만 가능합니다 ※※※\n");
			}
		}//while문 끝
	}
	
	private static void movieTicketing() {
		//영화 정보 보여주기
		MovieController.allMovieInfo();
		
		System.out.print("\n♥ 보고 싶은 영화 제목을 입력하세요 ≫≫  ");
		String title = sc.next();
		List<ScheduleDTO> list =	MovieController.selectMovieSchedule(title);
		if(list ==null || list.size()==0) {
			movieTicketing();
		}
		int a = 0;
		int movieNo = 0;
		do {
			System.out.print("\n♥ 예매할 번호를 입력하세요  ≫≫  ");
			try {
				movieNo = Integer.parseInt(sc.next());
			} catch (NumberFormatException e) {
				System.out.print("\n※※※ 예매번호는 숫자만 입력 가능합니다 ※※※\n");
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
				System.out.println("\n※※※ 번호를 잘못 입력하셨습니다 ※※※\n");
			}
		} while(a==0);
		
		
		
		int people = 0;
		do {
			System.out.print("\n♥ 인원수를 정확히 입력하세요  ≫≫  ");
			
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
					System.out.println("\n※※※ 예매가능 인원초과 ※※※\n");
					continue;
				}
        			break;
			} catch (NumberFormatException e) {
				System.out.print("\n※※※ 잘못 입력하셨습니다 ※※※\n");
				continue;
			}
			
		} while(true);
		
		
		MovieController.discountList();
		int discount = 0;
		do {
			System.out.print("\n♥ 할인번호를 입력해주세요.  ≫≫  ");
			try {
				discount = Integer.parseInt(sc.next());
				if(discount !=1 && discount !=2 && discount !=3 ) {
				System.out.println("\n※※※ 정확한 번호를 입력해주세요 ※※※\n");
				continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n※※※ 번호로 입력해주세요 ※※※\n");
				continue;
			}
			
		} while(true);
		
		String number = null;
		do {
			System.out.print("\n♥ 핸드폰 번호를 입력하세요(ex)12341234)  ≫≫   ");
			try {
				number = sc.next();
			if(number.length() !=8) {
				System.out.println("\n※※※ 핸드폰번호는 8자 입력해주세요 ※※※\n");
				continue;
			}
				Integer.parseInt(number);
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n※※※ 잘못 입력하셨습니다 ※※※\n");
				continue;
			}
		} while(true);
		
		int total = MovieController.totalPrice(movieNo, people, discount);

		if(check() == true) {
			MyMovieDTO myMovie = new MyMovieDTO(0, movieNo, number,people,total);
			MovieController.movieInsert(myMovie);
		}else {
			 System.out.println("\n※※※ 예매가 종료 됩니다 ※※※\n");
			 member();
		}
	}
	 
	 private static boolean check() {
		while(true) {
			System.out.print(" \n♥ 예매 하시겠습니까?(Y or N)   ≫≫  ");
			String check = sc.next();
			if(check.equals("Y") || check.equals("y") || check.equals("ㅛ") ) {
				return true;
			} else if(check.equals("N")||check.equals("n") || check.equals("ㅜ")) {
				return false;
			} else {
				System.out.println("\n※※※ 다시 입력해주세요 ※※※\n");
			}
		}
	 }
	
	public static void myMovieCheck() {
		System.out.print("\n♥ 핸드폰 번호를 입력하세요   ≫≫  ");
		String phNo = sc.next();
		List<TotalDTO> list = MovieController.myMovieCheck(phNo);
		if(list == null || list.size()==0) {
			myMovieCheck();
		}
	}
	
	private static void movieCancle() {
		System.out.print("\n♥ 핸드폰 번호를 입력하세요   ≫≫   ");
		String phNo = sc.next();
		List<TotalDTO> list = MovieController.myMovieCheck(phNo);
		if(list == null || list.size()==0) {
			movieCancle();
		}
		int b = 0;
		int myNo = 0;
		if(list != null) {
         do {
	  	   System.out.print("\n♥ 취소할 번호를 입력하세요   ≫≫   ");
	  	    try {
		      myNo = Integer.parseInt(sc.next());
	  	   }catch(NumberFormatException e) {
	  		  System.out.print("\n※※※ 취소번호는 숫자만 입력 가능합니다 ※※※\n");
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
				System.out.println("                                  ****메뉴선택****");
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("");
				System.out.println("1.영화 정보 추가  |  2. 영화 스케쥴 추가  | 3. 전체예매보기 | 4. 처음으로  |  5. 종료");
				System.out.println("");
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

				int choice = Integer.parseInt(sc.next());
				switch(choice) {
				case 1 : InfoInsert();          break;
				case 2 : scheduleInsert();   break;
				case 3 : viewAll();   break;
				case 4 : MainMenu();        break;
				case 5 : 
					System.out.println("\n※※※ 프로그램 종료합니다 ※※※\n");
					System.exit(0);
				default:
					System.out.println("\n ※※※잘못되었습니다. 다시입력해주세요※※※ \n");
				}
			}catch(NumberFormatException e) {
				System.out.println("\n※※※ 숫자만 가능합니다 ※※※\n");
			}
		}
	}
	
	private static void manager() {
		System.out.print("    비밀번호를 입력하세요 ≫≫ ");
		String password = sc.next();
		if(password.equals("1234")) {
			managerMenu();
		}else {
			System.out.println("\n ※※※ 비밀번호가 틀렸습니다 ※※※\n");
			MainMenu();
		}
	}
	
	private static void InfoInsert() {
		System.out.print("\n♥ 제목을 입력해주세요 ≫≫  ");
		String title = sc.next();
		System.out.print("\n♥ 등급을 입력해주세요 ≫≫  ");
		String rating = sc.next();
		System.out.print("\n♥ 장르를 입력해주세요 ≫≫  ");
		String genre = sc.next();
		System.out.print("\n♥ 총 상영시간을 입력해주세요 ≫≫  ");
		String runtime = sc.next();
		
		int price = 0;
		do {
			System.out.print("\n♥ 가격을 입력해주세요 ≫≫  ");
			try {
				price = Integer.parseInt(sc.next());
				if (price < 0 && price > 20000) {
					System.out.print("잘못 입력하셨습니다. 숫자로 ");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("잘못 입력하셨습니다. 숫자로 ");
				continue;
			}
			
		} while(true);
		
		
		
		
		MovieController.InfoInsert(new MovieDTO(title, rating, genre, runtime, price));
	}
	
	private static void scheduleInsert() {

		String title = null;
		do {
			System.out.print("\n♥ 추가할 영화제목을 입력해주세요 ≫≫  ");
			title = sc.next();
			if(jemokCheck(title) == false) {
				System.out.println(title+" 라는 제목의 영화를 찾을 수 없습니다. 정확히 입력해주세요.");
				continue;
			}
			break;
		} while (true);
		
	
		System.out.print("\n♥ 추가할 관을 입력해주세요 ≫≫  ");
		String gwan = sc.next();
		System.out.print("\n♥ 추가할 영화 상영일을 입력해주세요 ≫≫  ");
		String mDate = sc.next();
		System.out.print("\n♥ 추가할 영화 상영시간을 입력해주세요 ≫≫  ");
		String showtime = sc.next();

		int remaining = 0;
		do {
			System.out.print("\n♥ 추가할 영화 총좌석을 입력해주세요 ≫≫  ");
			try {
				remaining = Integer.parseInt(sc.next());
				if (remaining<0 && remaining > 50) {
					System.out.print("\n영화관의 최대 좌석은 50좌석입니다. ");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("\n좌석은 숫자로 입력하세요. ");
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
		System.out.println("\n총 매출은  :  " + a + " 원 입니다.\n");
		}
	   	
	private static boolean jemokCheck(String title) {
		boolean b = MovieController.jemokCheck(title);
		return b;
	}
}
