package mvc.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.model.DTO.DiscountDTO;
import mvc.model.DTO.MovieDTO;
import mvc.model.DTO.MyMovieDTO;
import mvc.model.DTO.ScheduleDTO;
import mvc.model.DTO.TotalDTO;
import mvc.model.Util.DBUtill;

public class MovieDAOImpl implements MovieDAO {
	private Properties proFile = DBUtill.getProFile();

	@Override
	public int InfoInsert(MovieDTO movieDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps =  null;
		String sql = proFile.getProperty("movie.insert");
		int result = 0;
		
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setString(1, movieDTO.getTitle());
			ps.setString(2, movieDTO.getRating());
			ps.setString(3, movieDTO.getGenre());
			ps.setString(4, movieDTO.getRuntime());
			ps.setInt(5, movieDTO.getPrice());
			
			result = ps.executeUpdate();

		}finally {
			DBUtill.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<MovieDTO> allMovieInfo() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 List<MovieDTO> list = new ArrayList<>();
		String sql = proFile.getProperty("movieInfoTable");
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				list.add(new MovieDTO(rs.getString(1),rs.getString(2),  
						rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		} finally {
			DBUtill.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ScheduleDTO> selectMovieSchedule(String title) throws SQLException {
		List<ScheduleDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("movieSelectByTitle");

		try {
		con = DBUtill.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, "%"+title+"%");
		rs = ps.executeQuery();
		
		while(rs.next()) {
			ScheduleDTO dto = new ScheduleDTO( rs.getInt(1),
					           rs.getString(2), rs.getString(3),
					           rs.getString(4), rs.getString(5),
					           rs.getInt(6));				
					list.add(dto);		
		}
		
		}finally {
			DBUtill.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<DiscountDTO> discountList() throws SQLException {
		List<DiscountDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("discountTable");
		
	try {	
		con = DBUtill.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			DiscountDTO dto = new DiscountDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
			list.add(dto);			
		}
	}finally {
		DBUtill.dbClose(rs, ps, con);
	}
		return list;
	}

	@Override
	public int MoviePrice(int movieNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps =  null;
//		String sql = proFile.getProperty("movie.insert");
		String sql = "SELECT PRICE FROM MOVIE_INFO A, MOVIE_SCHEDULE B WHERE B.MOVIE_NO = ? AND B.TITLE = A.TITLE";
		ResultSet result = null;
		int price;
		
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, movieNo);
			
			result = ps.executeQuery();
			result.next();
			price = result.getInt(1);

		}finally {
			DBUtill.dbClose(ps, con);
		}
		return price;
	}

	@Override
	public double discountRate(int discount) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps =  null;
//		String sql = proFile.getProperty("movie.insert");
		String sql = "SELECT DC_RATE FROM DISCOUNT WHERE num = ?";
		ResultSet result = null;
		int discountRate;
		
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setInt(1, discount);
			
			result = ps.executeQuery();
			result.next();
			discountRate = result.getInt(1);

		}finally {
			DBUtill.dbClose(ps, con);
		}
		return (double)discountRate/100;
	}

	@Override
	public int movieInsert(MyMovieDTO myMovie) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement("insert into my_movie values (my_movie_seq.nextval,?, ?, ?,?)");
			ps.setInt(1, myMovie.getMovieNo());
			ps.setString(2, myMovie.getPhNo());
			ps.setInt(3, myMovie.getPeople());
			ps.setInt(4, myMovie.getMyPrice());
			result = ps.executeUpdate();
		} finally {
			DBUtill.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<TotalDTO> myMovieCheck(String phNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TotalDTO> list = new ArrayList<>();
		String sql = proFile.getProperty("showMymovie");
		//select my_no, movie_no, ph_no, people, my_price from my_movie where ph_no=?;
		
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, phNo);

			rs = ps.executeQuery();
			
		
			while(rs.next()) {
				list.add(new TotalDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
													rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		}finally {
			DBUtill.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int movieCancle(String phNo, int myNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps =  null;
		String sql = proFile.getProperty("delMymovie");
		int result = 0;
		
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, myNo);
			
			result = ps.executeUpdate();
	
		}finally {
			DBUtill.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int scheduleInsert(ScheduleDTO dto) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      int result = 0;
	      try {
	         con = DBUtill.getConnection();
	         ps = con.prepareStatement("insert into movie_schedule values (movie_schedule_seq.nextval, ?, ?, ?, ?, ?)");
	         
	         //?, '상류사회', '181008', '7:00', 50);
	         ps.setString(1, dto.getTitle());
	         ps.setString(2, dto.getGwan());
	         ps.setString(3, dto.getmDate());
	         ps.setString(4, dto.getShowtime());
	         ps.setInt(5, dto.getRemaining());
	         result = ps.executeUpdate();
	      } finally {
	         DBUtill.dbClose(ps, con);
	      }
	      return result;
	}

	public List<TotalDTO> viewAll() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TotalDTO> list = new ArrayList<>();
		String sql = "select my_no, ph_no, people, my_price, title,gwan,to_char(m_Date, 'mm-dd'), showtime from my_movie join movie_schedule USING (MOVIE_NO)";
		
	
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				
			while(rs.next()) {
				list.add(new TotalDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
													rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		}finally {
			DBUtill.dbClose(rs, ps, con);
		}
		return list;
}
	
	public boolean jemokCheck(String title) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("movieTitleCheck");
		try {
			con = DBUtill.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(title)) {
					return true;
				}
			}
			return false;
		} finally {
			DBUtill.dbClose(rs, ps, con);
		}
	}
}
