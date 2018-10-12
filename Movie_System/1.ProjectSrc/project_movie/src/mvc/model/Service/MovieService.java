package mvc.model.Service;

import java.sql.SQLException;
import java.util.List;

import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public interface MovieService {

	/**
	 * 관리자 => 영화 정보 등록(등록하기 전에 글제목 중복체크)
	 * */
	void InfoInsert(MovieDTO movieDTO) throws SQLException;

	/**
	 * 영화 정보 모두 보여주기
	 * */
	List<MovieDTO> allMovieInfo() throws SQLException;


	/**
	 * 제목 검색 스케쥴 보여주기
	 * */
	List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException;

	/**
	 * 할인 종류 보여주기
	 * */
	List<DiscountDTO> discountList() throws SQLException;

	/**
	 * 최종 가격 보여주기
	 * dao 두개 만들기 (영화 번호, 할인율 가져오기)
	 * */
	int totalPrice(int movieNo, int people, int discount) throws SQLException;

	/**
	 * 나의 예매 내역 insert
	 *  new My_MovieDTO(0, number,people,null,movie_No);
	 *  totalPrice를 호출해서 최종가격을 들고 들어감
	 * */
	int movieInsert(MyMovieDTO myMovie) throws SQLException;
	
	/**
	 * 나의 예매 내역 확인
	 * */
	List<TotalDTO> myMovieCheck(String number) throws SQLException;
	
	/**
	 * 영화 취소하기
	 * */
	void movieCancle(String phNo, int myNo) throws SQLException;
	
	/**
	 * 관리자모드 - 새 영화 삽입
	 * */
	int scheduleInsert(ScheduleDTO dto) throws SQLException;

	/**
	 * 관리자모드 - 모든 예매 내역 보기
	 */
	List<TotalDTO> viewAll() throws SQLException;
	
	/**
	 * 관리자모드 - 제목중복체크
	 */
	public boolean jemokCheck(String title) throws SQLException;
}
