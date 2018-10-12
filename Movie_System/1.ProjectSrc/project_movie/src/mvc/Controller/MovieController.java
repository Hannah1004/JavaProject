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
			SuccessView.messagePrint("�ءءؿ�ȭ��������� �Ϸ�Ǿ����ϴ�.�ءء�");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ��� ��ȭ ���� �ҷ�����
	 * ������
	 * */
	public static void allMovieInfo() {
		try {
			SuccessView.selectPrint(ms.allMovieInfo());
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 *  �˻��� ��ȭ ������ ������ �ҷ�����
	 *  ���մ�
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
	 * ���� ���� �����ֱ�
	 * ���մ�
	 * */
	public static void discountList() {
		try {
			SuccessView.discountList(ms.discountList());
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ���� ���� �����ֱ� dao �ΰ� ����� (��ȭ ��ȣ, ������ ��������)
	 * ������
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
	 * ���� ���� ������ insert�ϱ�
	 * ȣ����
	 * */
	public static void movieInsert(MyMovieDTO myMovie) {
		try {
			ms.movieInsert(myMovie);
			SuccessView.messagePrint("�ءءؿ��Ű� �Ϸ�Ǿ����ϴ�.�ءء�");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ���� ���� ���� Ȯ�� �ϱ�
	 * �ѳ�
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
	 * ���� ���� �����ϱ�
	 * �ѳ�
	 * */
	public static void movieCancle(String phNo, int myNo) {
		try {
			ms.movieCancle(phNo, myNo);	
			SuccessView.messagePrint("�ءءػ����� �Ϸ�Ǿ����ϴ�.�ءء�");

		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());

		}
	}
	
	/**
	 * ��ȭ ������ insert
	 * ȣ����
	 * */
	public static void scheduleInsert(ScheduleDTO dto) {
		try {
			ms.scheduleInsert(dto);
			SuccessView.messagePrint("�ءءؿ�ȭ�������� �߰��Ǿ����ϴ�.�ءء�");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	/**
	 * ������ ��� ���� ���� ����
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
