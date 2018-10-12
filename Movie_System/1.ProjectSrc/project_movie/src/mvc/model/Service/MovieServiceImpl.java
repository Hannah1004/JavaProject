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
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return list;
	}

	@Override
	public List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException {
		List<ScheduleDTO> list = movieDAO.selectMovieSchedule(title);
		if(list == null || list.size() == 0) {
			throw new SQLException("������ "+title+"�� ���Ե� ��ȭ�� �����ϴ�."
					+ "��ȭ������ ��Ȯ�� �Է����ּ���.");
		}
		return list;
	}

	@Override
	public List<DiscountDTO> discountList() throws SQLException {
		List<DiscountDTO> list = movieDAO.discountList();
		if (list == null || list.size() == 0) {
			throw new SQLException("list size�� 0�̸� �ȵ�");
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
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public List<TotalDTO> myMovieCheck(String phNo) throws SQLException {
		List<TotalDTO> list = movieDAO.myMovieCheck(phNo);
		if(list == null || list.size() == 0 ) {
			throw new SQLException(phNo + "���� ���� ������ �����ϴ�. \n�ٽ� �Է����ּ���");
		}
		return list;
	}

	@Override
	public void movieCancle(String phNo, int myNo) throws SQLException {
		int re = movieDAO.movieCancle(phNo, myNo);
		if(re ==0) {
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		}
	}

	@Override
	public void InfoInsert(MovieDTO movieDTO) throws SQLException {
		int re = movieDAO.InfoInsert(movieDTO);
		if(re == 0) {
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
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
			throw new SQLException("���ų����� �����ϴ�.");
		}
		return list;
	}
	
	public boolean jemokCheck(String title) throws SQLException{
		boolean b = movieDAO.jemokCheck(title);
		return b;
	}

}
