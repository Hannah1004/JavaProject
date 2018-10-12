package mvc.model.DAO;

import java.sql.SQLException;
import java.util.List;

import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public interface MovieDAO {
	/**
	 * 게시물 등록하기
	 * insert into movie_info values(?,?,?,?,?)
	 * */
	int InfoInsert(MovieDTO movieDTO) throws SQLException;

	/**
	 * 영화 정보 모두 보여주기
	 * */
	List<MovieDTO> allMovieInfo() throws SQLException;
	
	/**
	 * 검색된 스케쥴 보여주기
	 * */
	List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException;
	
	/**
	 * 할인 종류 보여주기
	 * */
	List<DiscountDTO> discountList() throws SQLException;
	
	/**
	 * 최종가격 보여주기
	 * */
	int MoviePrice(int modelNo) throws SQLException;
	double discountRate(int discount) throws SQLException;
	
	/**
	 * 나의 영화 예매 insert
	 * */
	int movieInsert(MyMovieDTO myMovie) throws SQLException;
	
	/**
	 * 나의 영화 내역 확인
	 * */
	List<TotalDTO> myMovieCheck(String number) throws SQLException;
	
	/**
	 * 영화 취소하기
	 * */
	int movieCancle(String phNo, int myNo) throws SQLException;
	
	/**
	 * 관리자모드 - 새 영화 삽입
	 * */
	int scheduleInsert(ScheduleDTO dto) throws SQLException;

	/**
	 * 관리자모드 - 모든 예매 내역 보기
	 */
	List<TotalDTO> viewAll() throws SQLException;
	
	/**
	 * 관리자모드 - 제목체크
	 */
	public boolean jemokCheck(String title) throws SQLException;
}
