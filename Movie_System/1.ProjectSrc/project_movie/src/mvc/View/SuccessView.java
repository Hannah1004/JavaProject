package mvc.View;

import java.util.List;

import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;

public class SuccessView {
	/**
	 * 등록, 수정, 삭제 성공 메세지 출력
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	
	/**
	 * 모든 영화 정보 보여주기
	 * */
	public static void selectPrint(List<MovieDTO> list) {
		//list for문 돌리기
		System.out.println("\n|       제목      |     연령     |     장르     |   상영시간    |  가격   |");
		for(MovieDTO movieDTO : list) {
			System.out.println(movieDTO);
		}
	}

	
	/**
	 * 나의 예매 내역 확인하기
	 * */
	public static void selectMyMovie(List<TotalDTO> list) {
		System.out.println("\n|예매번호 |   핸드폰번호   | 인원수|    가격   |      제목      |  관  |   예매 날짜   |  시간   |");
		for(TotalDTO totalDTO : list) {
			System.out.println(totalDTO);
		}
	}
	/*
	|예매번호|   핸드폰번호   | 인원수 |    가격    |      제목     |  관  |  예매 날짜    |  시간   |
	--------------------------------------------------------------------------------------------------------
	|24       | 11112222       | 5     | 45000     | 암수살인       | 1관  |18-10-12       | 18:00   |*/
	/**
	 * 검색된 제목의 스케쥴 보여주기
	 * */
	public static void selectSchedule(List<ScheduleDTO> list ) {
		//list for문 돌리기
		System.out.println(" \n |  번호  |    관   |      제목    |  예매날짜 |  시간   | 잔여좌석 |");
		for(ScheduleDTO dto : list) {
			System.out.println(dto);
		}
	}

	public static void discountList(List<DiscountDTO> list) {
		//list for문 돌리기
		System.out.println("\n| 번호 |     할인 종류    |  할인율 |");
		for(DiscountDTO dto : list) {
			System.out.println(dto);
		}
	}/*
	
|번호|     할인 종류     |  할인율  |
-----------------------------------
|1     | 통신사할인       | 15%     |*/

	public static void totalPirce(int totalPrice) {
		System.out.println("   최종 예매 가격  > " + totalPrice+"원");
	}
	
	public static void allPrint(List<TotalDTO> viewAll) {
		System.out.println("\n|예매번호 |   핸드폰번호   | 인원수|    가격   |      제목      |  관  |  예매 날짜  |  시간   |");
		for(TotalDTO movieDTO : viewAll) {
			System.out.println(movieDTO);
		}
		
	}
}
