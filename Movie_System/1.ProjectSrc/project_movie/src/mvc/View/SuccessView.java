package mvc.View;

import java.util.List;

import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public class SuccessView {
	/**
	 * ���, ����, ���� ���� �޼��� ���
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	
	/**
	 * ��� ��ȭ ���� �����ֱ�
	 * */
	public static void selectPrint(List<MovieDTO> list) {
		//list for�� ������
		System.out.println("\n|       ����      |     ����     |     �帣     |   �󿵽ð�    |  ����   |");
		for(MovieDTO movieDTO : list) {
			System.out.println(movieDTO);
		}
	}

	
	/**
	 * ���� ���� ���� Ȯ���ϱ�
	 * */
	public static void selectMyMovie(List<TotalDTO> list) {
		System.out.println("\n|���Ź�ȣ |   �ڵ�����ȣ   | �ο���|    ����   |      ����      |  ��  |   ���� ��¥   |  �ð�   |");
		for(TotalDTO totalDTO : list) {
			System.out.println(totalDTO);
		}
	}
	/*
	|���Ź�ȣ|   �ڵ�����ȣ   | �ο��� |    ����    |      ����     |  ��  |  ���� ��¥    |  �ð�   |
	--------------------------------------------------------------------------------------------------------
	|24       | 11112222       | 5     | 45000     | �ϼ�����       | 1��  |18-10-12       | 18:00   |*/
	/**
	 * �˻��� ������ ������ �����ֱ�
	 * */
	public static void selectSchedule(List<ScheduleDTO> list ) {
		//list for�� ������
		System.out.println(" \n |  ��ȣ  |    ��   |      ����    |  ���ų�¥ |  �ð�   | �ܿ��¼� |");
		for(ScheduleDTO dto : list) {
			System.out.println(dto);
		}
	}

	public static void discountList(List<DiscountDTO> list) {
		//list for�� ������
		System.out.println("\n| ��ȣ |     ���� ����    |  ������ |");
		for(DiscountDTO dto : list) {
			System.out.println(dto);
		}
	}/*
	
|��ȣ|     ���� ����     |  ������  |
-----------------------------------
|1     | ��Ż�����       | 15%     |*/

	public static void totalPirce(int totalPrice) {
		System.out.println("   ���� ���� ����  > " + totalPrice+"��");
	}
	
	public static void allPrint(List<TotalDTO> viewAll) {
		System.out.println("\n|���Ź�ȣ |   �ڵ�����ȣ   | �ο���|    ����   |      ����      |  ��  |  ���� ��¥  |  �ð�   |");
		for(TotalDTO movieDTO : viewAll) {
			System.out.println(movieDTO);
		}
		
	}
}
