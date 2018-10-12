package mvc.model.Service;

import java.sql.SQLException;
import java.util.List;

import mvc.View.MainView;
import mvc.model.DAO.MovieDAO;
import mvc.model.DAO.MovieDAOImpl;
import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public class MovieServiceImpl implements MovieService {
	private MovieDAO movieDAO = new MovieDAOImpl();

	@Override
	public List<MovieDTO> allMovieInfo() throws SQLException {
		List<MovieDTO> list = movieDAO.allMovieInfo();
		if(list==null||list.size()==0){
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return list;
	}

	@Override
	public List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException {
		List<ScheduleDTO> list = movieDAO.selectMovieSchedule(title);
		if(list == null || list.size() == 0) {
			throw new SQLException("제목이 "+title+"가 포함된 영화는 없습니다."
					+ "영화제목을 정확히 입력해주세요.");
		}
		return list;
	}

	@Override
	public List<DiscountDTO> discountList() throws SQLException {
		List<DiscountDTO> list = movieDAO.discountList();
		if (list == null || list.size() == 0) {
			throw new SQLException("list size가 0이면 안돼");
		}
		return list;
	}

	@Override
	public int totalPrice(int movieNo, int people, int discount) throws SQLException {
		int moviePrice = movieDAO.MoviePrice(movieNo);
		double discountRate = movieDAO.discountRate(discount);	
		
		return (int) (moviePrice * people * (1 - discountRate));
	}

	@Override
	public int movieInsert(MyMovieDTO myMovie) throws SQLException {
		int result = movieDAO.movieInsert(myMovie);
		if(result==0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public List<TotalDTO> myMovieCheck(String phNo) throws SQLException {
		List<TotalDTO> list = movieDAO.myMovieCheck(phNo);
		if(list == null || list.size() == 0 ) {
			throw new SQLException(phNo + "님의 예매 내역이 없습니다. \n다시 입력해주세요");
		}
		return list;
	}

	@Override
	public void movieCancle(String phNo, int myNo) throws SQLException {
		int re = movieDAO.movieCancle(phNo, myNo);
		if(re ==0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	@Override
	public void InfoInsert(MovieDTO movieDTO) throws SQLException {
		int re = movieDAO.InfoInsert(movieDTO);
		if(re == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}
	
	@Override
	public int scheduleInsert(ScheduleDTO dto) throws SQLException {
		int result = movieDAO.scheduleInsert(dto);
		return result;
	}

	public List<TotalDTO> viewAll() throws SQLException {
		List<TotalDTO> list = movieDAO.viewAll();
		if(list==null||list.size()==0){
			throw new SQLException("예매내역이 없습니다.");
		}
		return list;
	}
	
	public boolean jemokCheck(String title) throws SQLException{
		boolean b = movieDAO.jemokCheck(title);
		return b;
	}

}
