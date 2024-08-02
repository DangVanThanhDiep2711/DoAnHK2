package dao;

import database.ConnectDB;
import entity.Department;


public class DepartmentDao {
	public Department selectDepartment(int idEmp) {
		var depar = new Department();
		var call = "call selectDepartments(?)";
		try (
				var con = ConnectDB.connect();
				var cs = CreateCallableStmt.createCS(con, idEmp, call);
				var result = cs.executeQuery();
		){
			
			while (result.next()) {		
				depar.setDepartmentId(result.getInt("DepartmentID"));
				depar.setDepartmentName(result.getString("DepartmentName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return depar;
	}
}
