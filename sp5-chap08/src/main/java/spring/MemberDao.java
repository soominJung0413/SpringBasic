package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
	}

	@Autowired
	public MemberDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE EMAIL = ?", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member newMember = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				newMember.setId(rs.getLong("ID"));

				return newMember;
			}
		}, email);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(final Member member) {// 인서트 문이므로 절대 값변하면 안됨 final이여야함
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((Connection con) -> {
			PreparedStatement pstmt = con.prepareStatement(
					"insert into member (EMAIL,PASSWORD,NAME,REGDATE) values(?, ?, ?, ?)", new String[] { "ID" });
			// 키
			// 홀더
			// 값을
			// preparedStatement에
			// 매개값으로
			// 줘야한다!!!
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
			return pstmt;
		}, keyHolder);
		Number ketValue = keyHolder.getKey();
		member.setId(ketValue.longValue());

	}

	public void update(Member member) {
		jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?", member.getName(),
				member.getPassword(), member.getEmail());
	}

	public List<Member> selectAll() {
		List<Member> result = jdbcTemplate.query("select * from member", (rs, rowNum) -> {
			Member members = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getTimestamp("REGDATE").toLocalDateTime());
			members.setId(rs.getLong("ID"));
			return members;
		});
		return result;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
		return count;
	}
}
