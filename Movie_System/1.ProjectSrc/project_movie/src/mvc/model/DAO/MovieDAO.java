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
	 * �Խù� ����ϱ�
	 * insert into movie_info values(?,?,?,?,?)
	 * */
	int InfoInsert(MovieDTO movieDTO) throws SQLException;

	/**
	 * ��ȭ ���� ��� �����ֱ�
	 * */
	List<MovieDTO> allMovieInfo() throws SQLException;
	
	/**
	 * �˻��� ������ �����ֱ�
	 * */
	List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException;
	
	/**
	 * ���� ���� �����ֱ�
	 * */
	List<DiscountDTO> discountList() throws SQLException;
	
	/**
	 * �������� �����ֱ�
	 * */
	int MoviePrice(int modelNo) throws SQLException;
	double discountRate(int discount) throws SQLException;
	
	/**
	 * ���� ��ȭ ���� insert
	 * */
	int movieInsert(MyMovieDTO myMovie) throws SQLException;
	
	/**
	 * ���� ��ȭ ���� Ȯ��
	 * */
	List<TotalDTO> myMovieCheck(String number) throws SQLException;
	
	/**
	 * ��ȭ ����ϱ�
	 * */
	int movieCancle(String phNo, int myNo) throws SQLException;
	
	/**
	 * �����ڸ�� - �� ��ȭ ����
	 * */
	int scheduleInsert(ScheduleDTO dto) throws SQLException;

	/**
	 * �����ڸ�� - ��� ���� ���� ����
	 */
	List<TotalDTO> viewAll() throws SQLException;
	
	/**
	 * �����ڸ�� - ����üũ
	 */
	public boolean jemokCheck(String title) throws SQLException;
}
