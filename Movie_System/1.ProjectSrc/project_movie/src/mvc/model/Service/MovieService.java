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
	 * ������ => ��ȭ ���� ���(����ϱ� ���� ������ �ߺ�üũ)
	 * */
	void InfoInsert(MovieDTO movieDTO) throws SQLException;

	/**
	 * ��ȭ ���� ��� �����ֱ�
	 * */
	List<MovieDTO> allMovieInfo() throws SQLException;


	/**
	 * ���� �˻� ������ �����ֱ�
	 * */
	List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException;

	/**
	 * ���� ���� �����ֱ�
	 * */
	List<DiscountDTO> discountList() throws SQLException;

	/**
	 * ���� ���� �����ֱ�
	 * dao �ΰ� ����� (��ȭ ��ȣ, ������ ��������)
	 * */
	int totalPrice(int movieNo, int people, int discount) throws SQLException;

	/**
	 * ���� ���� ���� insert
	 *  new My_MovieDTO(0, number,people,null,movie_No);
	 *  totalPrice�� ȣ���ؼ� ���������� ��� ��
	 * */
	int movieInsert(MyMovieDTO myMovie) throws SQLException;
	
	/**
	 * ���� ���� ���� Ȯ��
	 * */
	List<TotalDTO> myMovieCheck(String number) throws SQLException;
	
	/**
	 * ��ȭ ����ϱ�
	 * */
	void movieCancle(String phNo, int myNo) throws SQLException;
	
	/**
	 * �����ڸ�� - �� ��ȭ ����
	 * */
	int scheduleInsert(ScheduleDTO dto) throws SQLException;

	/**
	 * �����ڸ�� - ��� ���� ���� ����
	 */
	List<TotalDTO> viewAll() throws SQLException;
	
	/**
	 * �����ڸ�� - �����ߺ�üũ
	 */
	public boolean jemokCheck(String title) throws SQLException;
}
