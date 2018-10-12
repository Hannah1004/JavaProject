package mvc.Controller;

import java.sql.SQLException;
import java.util.List;

import mvc.View.FailView;
import mvc.View.MainView;
import mvc.View.SuccessView;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;
import mvc.model.Service.MovieService;
import mvc.model.Service.MovieServiceImpl;

public class MovieController {
	private static MovieService ms = new MovieServiceImpl();
	
	public static void InfoInsert(MovieDTO movieDTO) {
		try {
			ms.InfoInsert(movieDTO);
			SuccessView.messagePrint("※※※영화정보등록이 완료되었습니다.※※※");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 모든 영화 정보 불러오기
	 * 진영님
	 * */
	public static void allMovieInfo() {
		try {
			SuccessView.selectPrint(ms.allMovieInfo());
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 *  검색한 영화 제목의 스케쥴 불러오기
	 *  도균님
	 * */
	public static List<ScheduleDTO> selectMovieSchedule(String title) {
		List<ScheduleDTO> list = null;
		try {
			list = ms.selectMovieSchedule(title);
			SuccessView.selectSchedule(list);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
		return list;
	}

	/**
	 * 할인 종류 보여주기
	 * 도균님
	 * */
	public static void discountList() {
		try {
			SuccessView.discountList(ms.discountList());
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 최종 가격 보여주기 dao 두개 만들기 (영화 번호, 할인율 가져오기)
	 * 지현님
	 * */
	public static int totalPrice(int movieNo, int people, int discount) {
		int total =0;
		try {
			total = ms.totalPrice(movieNo,people, discount);
			SuccessView.totalPirce(total);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		return total;
	}

	/**
	 * 나의 예매 내역에 insert하기
	 * 호수님
	 * */
	public static void movieInsert(MyMovieDTO myMovie) {
		try {
			ms.movieInsert(myMovie);
			SuccessView.messagePrint("※※※예매가 완료되었습니다.※※※");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 나의 예매 내역 확인 하기
	 * 한나
	 * */
	public static List<TotalDTO> myMovieCheck(String phNo) {
		List<TotalDTO> list = null;
		try{
			list = ms.myMovieCheck(phNo);
			SuccessView.selectMyMovie(list);
			
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		return list;
	}

	/**
	 * 예매 내역 삭제하기
	 * 한나
	 * */
	public static void movieCancle(String phNo, int myNo) {
		try {
			ms.movieCancle(phNo, myNo);	
			SuccessView.messagePrint("※※※삭제가 완료되었습니다.※※※");

		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());

		}
	}
	
	/**
	 * 영화 스케쥴 insert
	 * 호수님
	 * */
	public static void scheduleInsert(ScheduleDTO dto) {
		try {
			ms.scheduleInsert(dto);
			SuccessView.messagePrint("※※※영화스케쥴이 추가되었습니다.※※※");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	/**
	 * 관리자 모든 예매 내역 보기
	 */
	public static List<TotalDTO> viewAll() {
		List<TotalDTO> list = null;
		try {
			list = ms.viewAll();
		SuccessView.allPrint(ms.viewAll());
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}	
		return list;
	}
	
	public static boolean jemokCheck(String title) {
		boolean b = false;
		try {
			b = ms.jemokCheck(title);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		return b;
	}
}
