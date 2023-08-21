package com.example.SpringCrudOperation.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.SpringCrudOperation.Bean.Users;

@Repository("userDao")
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Users findUserByUsername(String username, String password) {
		String sql = " SELECT * FROM users WHERE username = ? and password = ?";
		List<Users> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class), username, password);
//		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class), username, password);
		if(!users.isEmpty()) {
			return users.get(0);
		}else {
			return null;
		}
	}
	
}
