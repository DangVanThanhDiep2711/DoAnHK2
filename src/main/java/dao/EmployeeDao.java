package dao;

import java.awt.Robot;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.Employees;
import entity.Role;


public class EmployeeDao {
	public static CallableStatement createCS(Connection con, int id) throws Exception {
		var cs = con.prepareCall("{call selectEmpID(?)}");
		cs.setInt(1, id);
		return cs;
	}
	public Employees getEmp(int id) {
		var emp = new Employees();
		try (
				var con = ConnectDB.connect();
				var cs = createCS(con, id);
				var result = cs.executeQuery();
		){
			
			while (result.next()) {
				
				emp.setEmployeeID(result.getInt("EmployeeID"));
				emp.setEmployeeName(result.getString("FullName"));
				emp.setEmail(result.getString("Email"));
				emp.setPassword(result.getString("Password"));
				emp.setStatus(result.getBoolean("Status"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
		
	}
	
	public Employees checkLogin(String email, String password) {
		var emp = new Employees();
		try (
				var con = ConnectDB.connect();
				var cs = CreateCallableStmt.createCS(con, email, password);
				var result = cs.executeQuery();
		){
			
			while (result.next()) {		
				emp.setEmployeeID(result.getInt("EmployeeID"));
				emp.setEmployeeName(result.getString("FullName"));
				emp.setEmail(result.getString("Email"));
				emp.setPassword(result.getString("Password"));
				emp.setStatus(result.getBoolean("Status"));
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return emp;
	}
	
	public Role selectRole(int idEmp) {
		var role = new Role();
		var call = "call selectRole(?)";
		try (
				var con = ConnectDB.connect();
				var cs = CreateCallableStmt.createCS(con, idEmp, call);
				var result = cs.executeQuery();
		){
			
			while (result.next()) {		
				role.setRoleName(result.getString("RoleName"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return role;
	}
	
}
