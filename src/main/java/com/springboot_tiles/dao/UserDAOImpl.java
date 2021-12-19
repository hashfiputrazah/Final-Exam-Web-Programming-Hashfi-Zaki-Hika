package com.springboot_tiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springboot_tiles.to.UserRoleTO;
import com.springboot_tiles.to.UserTO;
import com.springboot_tiles.util.ZConnection;

@Repository
public class UserDAOImpl implements UserDAO {
	@Qualifier("datasource")
	@Autowired DataSource dataSource;

	@Override
	public UserTO getUser(String username) {
		UserTO tobResult = new UserTO();
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		PreparedStatement pstRole = null;
		ResultSet rstRole = null;
		
		try {
			conn = dataSource.getConnection();
			sql.delete(0, sql.length());
			sql.append("select user_name, password, user_id \n"); 
			sql.append("from sys_user \n");
			sql.append("where user_name = '"+username+"' \n");
			pst = conn.prepareStatement(sql.toString());
			rst = pst.executeQuery();
			if(rst.next()) {
				tobResult.setUsername(rst.getString("user_name"));
				tobResult.setPassword(rst.getString("password"));
				
				sql.delete(0, sql.length());
				sql.append("select sur.user_id, sur.role_id, sr.role_name \n"); 
				sql.append("from sys_user_role sur  \n");
				sql.append("left join sys_role sr on sr.role_id = sur.role_id \n");
				sql.append("where sur.user_id = "+rst.getInt("user_id")+" \n");
				System.out.println(sql.toString());
				pstRole = conn.prepareStatement(sql.toString());
				rstRole = pstRole.executeQuery();
				Set<UserRoleTO> roles = new HashSet<>();
				while(rstRole.next()) {
					UserRoleTO tobRole = new UserRoleTO();
					tobRole.setRoleID(rstRole.getInt("role_id"));
					tobRole.setRoleName(rstRole.getString("role_name"));
					roles.add(tobRole);
				}
				tobResult.setRoles(roles);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closeResultSet(rst);
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return tobResult;
	}

	@Override
	public void addUser(UserTO tobpUser) {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		
		try {
			conn = dataSource.getConnection();
			ZConnection.beginTransaction(conn);
			
			sql.delete(0, sql.length());
			sql.append("insert into sys_user (user_name, password) \n"); 
			sql.append("values (?,?) \n");
			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, tobpUser.getUsername());
			pst.setString(2, tobpUser.getPassword());
			pst.addBatch();
			ZConnection.executeBatchPrepareStatement(pst);
			
			ZConnection.commitTransaction(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void addLoginUser(UserTO tobpUser) {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		
		try {
			conn = dataSource.getConnection();
			ZConnection.beginTransaction(conn);
			
			sql.delete(0, sql.length());
			sql.append("update sys_user set current_login = now(), ip_address = '"+tobpUser.getIp_address()+"', browser='"+tobpUser.getBrowser()+"', operating_system = '"+tobpUser.getOperating_system()+"' \n"); 
			sql.append("where user_name = '"+tobpUser.getUsername()+"' \n");
			pst = conn.prepareStatement(sql.toString());
			pst.addBatch();
			ZConnection.executeBatchPrepareStatement(pst);
			
			ZConnection.commitTransaction(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void addLogoutUser(UserTO tobpUser) {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		
		try {
			conn = dataSource.getConnection();
			ZConnection.beginTransaction(conn);
			
			sql.delete(0, sql.length());
			sql.append("update sys_user set last_login = current_login \n"); 
			sql.append("where user_name = '"+tobpUser.getUsername()+"' \n");
			pst = conn.prepareStatement(sql.toString());
			pst.addBatch();
			ZConnection.executeBatchPrepareStatement(pst);
			
			ZConnection.commitTransaction(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
