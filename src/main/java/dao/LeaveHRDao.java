package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.Employees;
import entity.LeaveHistory;
import entity.LeaveRequests;
//import subFrame.HistoryRequest;

public class LeaveHRDao {
	private Connection connection;
	public List<LeaveHistory> getListLH(int id) {
		List<LeaveHistory> list = new ArrayList<>(); 
		try (
				var con = ConnectDB.connect();
				var cs = con.prepareCall("{call selectLeaveHistorys(?)}");
				
		){
			cs.setInt(1, id);
			var result = cs.executeQuery();
			
			
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
	
	public List<LeaveHistory> getListLH() {
		List<LeaveHistory> list = new ArrayList<>(); 
		try (
				var con = ConnectDB.connect();
				var cs = con.prepareCall("{call selectLeaveHistory}");
				var result = cs.executeQuery();
		){
			
			
			
			
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


	public void UpdateStatus(int id) {
		try (
				var con = ConnectDB.connect();
				var cs = con.prepareCall("{call UpdateStatus(?)}");
			){
				cs.setInt(1,id);
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Successfully deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void UpdateApproveStatus(String status, int approvelId, int idHistory){
		try(
				
				var conection = ConnectDB.connect();
				var cs =  conection.prepareCall("{call updateStatusLR(?,?,?)}");
			){
				cs.setString(1,status);
				cs.setInt(2, approvelId);
				cs.setInt(3,idHistory);
				cs.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	  public void UpdateApproveStatus1(String status, int approverId, Integer requestId) {
//	        String sql = "UPDATE leave_requests SET status = ?, approver_id = ? WHERE id_request = ?";
//
//	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//	            statement.setString(1, status);
//	            statement.setInt(2, approverId);
//	            statement.setInt(3, requestId);
//
//	            int rowsUpdated = statement.executeUpdate();
//	            if (rowsUpdated > 0) {
//	                System.out.println("Status updated successfully.");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
	
	public void insertLH(LeaveHistory hR, int empId) {
		try (
				var con = ConnectDB.connect();
				var cs = con.prepareCall("{call InsertLeaveRequest(?,?,?,?,?,?)}");
			){
			cs.setInt(1, empId);
			cs.setString(2, hR.getLeaveType());
			cs.setDate(3, new java.sql.Date(hR.getStartDate().getTime()));
			cs.setDate(4, new java.sql.Date(hR.getEndDate().getTime()));
			cs.setString(5, hR.getReason());
			cs.setDate(6, new java.sql.Date(hR.getSubmissionDate().getTime()));
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Submit a successful application");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<LeaveHistory> getLHByIdEmp(int id) {
		List<LeaveHistory> list = new ArrayList<>(); 
		try (
				var con = ConnectDB.connect();
				var cs = con.prepareCall("{call selectAllLeaveHistoryEmp(?)}");
				
		){
			
			cs.setInt(1, id);
			var result = cs.executeQuery();
			
			
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
	
	public void updateLHbyId(LeaveHistory hR) {
	try (
			var con = ConnectDB.connect();
			var cs = con.prepareCall("{call updateLeaveRequest(?,?,?,?,?)}");
		){
		
		cs.setString(1, hR.getLeaveType());
		cs.setDate(2, new java.sql.Date(hR.getStartDate().getTime()));
		cs.setDate(3, new java.sql.Date(hR.getEndDate().getTime()));
		cs.setString(4, hR.getReason());
		cs.setInt(5, hR.getHistoryId());
		cs.executeUpdate();
		JOptionPane.showMessageDialog(null, "Update a successful application");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
}

	public Integer countLHForLeader(int idUser) {
		var call = "call countLHforlLeader(?)";
		int count = 0;
		try (
				var con = new ConnectDB().connect();
				var cs = CreateCallableStmt.createCS(con, idUser, call);
				var result = cs.executeQuery();
		){
			while(result.next()){
				count = result.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return count;
	}
	
	
	public static CallableStatement createCS(Connection con, int pageNumber, int rowPage) throws Exception {
		var cs = con.prepareCall("{call selLHistory(?,?)}");
		cs.setInt(1, pageNumber);
		cs.setInt(2, rowPage);
		return cs;
	}

	public List<LeaveRequests> selLHistoryForLeader(int pageNumber, int rowPage, int idUser) {
			var call = "call selLHistorytForLeader(?,?,?)";
			List<LeaveRequests> list = new ArrayList<>();
			try
			(
				var con = new ConnectDB().connect();
				var cs = CreateCallableStmt.createCS(con, pageNumber, rowPage, idUser, call);

				var result = cs.executeQuery();
			) {
				while(result.next()) {
					var lh = new LeaveRequests();
					lh.setLeaveRequestId(result.getInt("LeaveRequestID"));
					lh.setEmployeeId(result.getInt("EmployeeID"));
					lh.setLeaveTypeId(result.getInt("LeaveTypeID"));
					lh.setStatusLR(result.getString("StatusLR"));
					lh.setStartDate(result.getDate("StartDate"));
					lh.setEndDate(result.getDate("EndDate"));
					lh.setSubmissionDate(result.getDate("SubmissionDate"));
					lh.setApproverId(result.getInt("ApproverID"));
					lh.setApprovalDate(result.getDate("ApprovalDate"));
					lh.setReason(result.getString("Reason"));
					lh.setStatus(result.getBoolean("Status"));
					
					list.add(lh);
				}
		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return list;
		
	}

//	public void UpdateRejectionReason(String reason, Integer idRequest) {
//		 String sql = "UPDATE leave_requests SET rejection_reason = ? WHERE id_request = ?";
//
//	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//	            statement.setString(1, reason);
//	            statement.setInt(2, idRequest);
//
//	            int rowsUpdated = statement.executeUpdate();
//	            if (rowsUpdated > 0) {
//	                System.out.println("Rejection reason updated successfully.");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//		
//	}

	
}
