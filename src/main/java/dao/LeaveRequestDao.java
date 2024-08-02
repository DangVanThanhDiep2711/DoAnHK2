package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.LeaveHistory;
import entity.LeaveRequests;
//import subFrame.HistoryRequest;

public class LeaveRequestDao {
	public static CallableStatement createCS(Connection con, int id) throws Exception {
		var cs = con.prepareCall("{call selectLeaveRequests(?)}");
		cs.setInt(1, id);
		return cs;
	}

	public List<LeaveHistory> getListLeaveRequests() {
		List<LeaveHistory> list = new ArrayList<>();
		try (

				var conection = ConnectDB.connect();
				var cs = conection.prepareCall("{call selectLeaveRequests}");

				var result = cs.executeQuery();

		) {

			while (result.next()) {
				var lh = new LeaveHistory();
				lh.setHistoryId(result.getInt("HistoryID"));
				lh.setEmployeeId(result.getInt("EmployeeID"));
				lh.setLeaveType(result.getString("LeaveType"));
				lh.setApprovalStatus(result.getString("ApprovalStatus"));
				lh.setStartDate(result.getDate("StartDate"));
				lh.setEndDate(result.getDate("EndDate"));
				lh.setSubmissionDate(result.getDate("SubmissionDate"));
				lh.setApproverID(result.getInt("ApproverID"));
				lh.setApprovalDate(result.getDate("ApprovalDate"));
				lh.setReason(result.getString("Reason"));
				lh.setStatus(result.getBoolean("Status"));
				list.add(lh);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<LeaveRequests> getLeaveRequests(int id) {
		var call = "call selectLeaveRequest(?)";
		List<LeaveRequests> list = new ArrayList<>();
		try (

				var conection = ConnectDB.connect();
				var cs = CreateCallableStmt.createCS(conection, id, call);
				var result = cs.executeQuery();) {

			while (result.next()) {
				var lr = new LeaveRequests();
				lr.setLeaveRequestId(result.getInt("LeaveRequestID"));
				lr.setEmployeeId(result.getInt("EmployeeID"));
				lr.setLeaveTypeId(result.getInt("LeaveTypeID"));
				lr.setStartDate(result.getDate("StartDate"));
				lr.setEndDate(result.getDate("EndDate"));
				lr.setReason(result.getString("Reason"));
				lr.setStatusLR(result.getString("StatusLR"));
				lr.setStatus(result.getBoolean("Status"));
				lr.setApproverId(result.getInt("ApproverID"));
				lr.setSubmissionDate(result.getDate("SubmissionDate"));
//				System.out.println("Employee Name: " + result.getString("Name"));
				list.add(lr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void UpdateLeaveRequest(String status, int idHR, int id) {
		try (

				var conection = ConnectDB.connect();
				var cs = conection.prepareCall("{call updateStatusLR(?,?,?)}");) {
			cs.setString(1, status);
			cs.setInt(2, id);
			cs.setInt(3, idHR);
			var result = cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Application Approved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static CallableStatement createCS(Connection con, int pageNumber, int rowPage) throws Exception {
		var cs = con.prepareCall("{call selLRequest(?,?)}");
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowPage);
		return cs;
	}

	public Integer countLRForLeader(int idUser) {
		int count = 0;
		var call = "call countLRforlLeader(?)";
		try (
				var con = new ConnectDB().connect();
				var cs = CreateCallableStmt.createCS(con, idUser, call);
				var result = cs.executeQuery();		
			){
			while (result.next()) {
				count = result.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return count;
	}

	public List<LeaveRequests> selLRequestForLeader(int pageNumber, int rowPage, int idUser) {
		var call = "call selLRequestForLeader(?,?,?)";
		List<LeaveRequests> list = new ArrayList<>();
		try (var con = new ConnectDB().connect();
				var cs = CreateCallableStmt.createCS(con, pageNumber, rowPage, idUser, call);
				var result = cs.executeQuery();) {
			while (result.next()) {
				LeaveRequests leaveRequest = new LeaveRequests();
				var lr = new LeaveRequests();
				lr.setLeaveRequestId(result.getInt("LeaveRequestID"));
				lr.setEmployeeId(result.getInt("EmployeeID"));
				lr.setLeaveTypeId(result.getInt("LeaveTypeID"));
				lr.setStartDate(result.getDate("StartDate"));
				lr.setEndDate(result.getDate("EndDate"));
				lr.setReason(result.getString("Reason"));
				lr.setStatusLR(result.getString("StatusLR"));
				lr.setStatus(result.getBoolean("Status"));
				lr.setApproverId(result.getInt("ApproverID"));
				lr.setSubmissionDate(result.getDate("SubmissionDate"));

				list.add(lr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}

//	public void updateLeaveRequestStatus(int historyId, String status , int userId) {
//		try (
//
//				var conection = ConnectDB.connect();
//				var cs = conection.prepareCall("{call updateStatusLR(?,?,?)}");) {
//			cs.setString(1, status);
//			cs.setInt(2, historyId);
//			cs.setInt(3, userId);
//			var result = cs.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
