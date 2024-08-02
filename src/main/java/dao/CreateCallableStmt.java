package dao;

import java.sql.*;

import javax.swing.JOptionPane;

public class CreateCallableStmt {
//	Employees
	public static CallableStatement createCS(Connection con, int idEmp, String call) throws Exception {
		var cs = con.prepareCall("{" +call +"}");
		cs.setInt(1, idEmp);
		return cs;
	}
	
	public static CallableStatement createCS(Connection con, int idEmp) throws Exception {
		var cs = con.prepareCall("{call selectEmpID(?)}");
		cs.setInt(1, idEmp);
		return cs;
	}
	
	public static CallableStatement createCS(Connection con, String str1, String Str2, String call) throws Exception {
		
		var cs = con.prepareCall("{call countLR(?)}");
		cs.setString(1, str1);
		cs.setString(2, Str2);
		return cs;
	}
	
//	LeaveRequest
	// call Phân trang LR
//	public static CallableStatement createCS(Connection con, int pageNumber, int rowPage) throws Exception {
//		var cs = con.prepareCall("{call selLRequest(?,?)}");
//		cs.setInt(1, pageNumber);
//		cs.setInt(2, rowPage);
//		return cs;
//	}
	
//	public static CallableStatement createCS(Connection con, int id) throws Exception {
//		var cs = con.prepareCall("{call selectLeaveRequests(?)}");
//		cs.setInt(1, id);
//		return cs;
//	}
	
	
//	HistoryRequest
	//	Call Phân trang LH
	public static CallableStatement createCS(Connection con, int pageNumber, int rowPage,int idUser,String call) throws Exception {
		var cs = con.prepareCall("{" + call +"}");
		cs.setInt(1, idUser);
		cs.setInt(2, pageNumber);
		cs.setInt(3, rowPage);
		return cs;
	}
	
// checkLogin
	public static CallableStatement createCS(Connection con, String Email, String password) throws Exception {
		var cs = con.prepareCall("{call selectLogin(?,?)}");
		cs.setString(1, Email);
		cs.setString(2, password);
		return cs;
	}
	
}
