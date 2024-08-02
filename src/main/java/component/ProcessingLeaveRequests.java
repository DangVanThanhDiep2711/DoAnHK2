package component;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.LeaveHRDao;
import dao.LeaveRequestDao;
import entity.Employees;
import entity.LeaveHistory;
import entity.Role;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import component.PendingApproval;

public class ProcessingLeaveRequests extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panelApproveAnRequest;
    private JPanel panelReason;
    private JButton btnReject;
    private JLabel lblEmployeeName;
    private JButton btnApprove;
    private JTextField txtStatus;
    private JTextField txtEmployeeName;
    private JLabel lblLeaveType;
    private JTextField txtLeaveType;
    private JLabel lblStartDate;
    private JTextField txtStartDate;
    private JLabel lblStartDate_1;
    private JTextField txtEndDate;
    private JLabel lblReason;
    private JLabel lblApproverID;
    private JTextField txtReason;
    private JTextField txtApproverID;
    private JLabel lblSubmissionDate;
    private JTextField txtSubmissionDate;
    private JButton btnSend;
    private JTextArea textArea;
    private JButton btnBack;
    private PendingApproval pA;
    private Employees user;
    private Role role = null;
    private Integer idRequest;
    private int id;
    private Employees emp = new Employees();
   private LeaveHistory lh;

    public ProcessingLeaveRequests(LeaveHistory lH, String name, PendingApproval pAl, Employees emp, Role r) {
    	role = r;
    	user = emp;
    	pA = pAl;
    	lh = lH;
        setLayout(new CardLayout(0, 0));

        panelApproveAnRequest = new JPanel();
        add(panelApproveAnRequest, "panelApproveAnRequest");
        panelApproveAnRequest.setLayout(null);

        btnReject = new JButton("Reject");
        btnReject.setBounds(109, 11, 89, 23);
        panelApproveAnRequest.add(btnReject);

        lblEmployeeName = new JLabel("Employee Name:");
        lblEmployeeName.setBounds(10, 59, 100, 14);
        panelApproveAnRequest.add(lblEmployeeName);

        btnApprove = new JButton("Approved");
        btnApprove.setBounds(10, 11, 89, 23);
        panelApproveAnRequest.add(btnApprove);

        txtStatus = new JTextField();
        txtStatus.setEditable(false);
        txtStatus.setColumns(10);
        txtStatus.setBounds(293, 12, 73, 20);
        panelApproveAnRequest.add(txtStatus);

        txtEmployeeName = new JTextField(name);
        txtEmployeeName.setEditable(false);
        txtEmployeeName.setColumns(10);
        txtEmployeeName.setBounds(120, 56, 246, 20);
        panelApproveAnRequest.add(txtEmployeeName);

        lblLeaveType = new JLabel("Leave Type:");
        lblLeaveType.setBounds(10, 84, 100, 14);
        panelApproveAnRequest.add(lblLeaveType);

        txtLeaveType = new JTextField(lH.getLeaveType());
        txtLeaveType.setEditable(false);
        txtLeaveType.setColumns(10);
        txtLeaveType.setBounds(120, 81, 246, 20);
        panelApproveAnRequest.add(txtLeaveType);

        lblStartDate = new JLabel("Effective Time:");
        lblStartDate.setBounds(10, 109, 100, 14);
        panelApproveAnRequest.add(lblStartDate);

        txtStartDate = new JTextField(lH.getStartDate().toString());
        txtStartDate.setEditable(false);
        txtStartDate.setColumns(10);
        txtStartDate.setBounds(120, 106, 100, 20);
        panelApproveAnRequest.add(txtStartDate);

        lblStartDate_1 = new JLabel("=>");
        lblStartDate_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartDate_1.setBounds(230, 109, 26, 14);
        panelApproveAnRequest.add(lblStartDate_1);

        txtEndDate = new JTextField(lH.getEndDate().toString());
        txtEndDate.setEditable(false);
        txtEndDate.setColumns(10);
        txtEndDate.setBounds(266, 106, 100, 20);
        panelApproveAnRequest.add(txtEndDate);

        lblReason = new JLabel("Reason:");
        lblReason.setBounds(10, 134, 100, 14);
        panelApproveAnRequest.add(lblReason);

        lblApproverID = new JLabel("Approver ID:");
        lblApproverID.setBounds(10, 199, 100, 14);
        panelApproveAnRequest.add(lblApproverID);

        txtReason = new JTextField(lH.getReason());
        txtReason.setEditable(false);
        txtReason.setColumns(10);
        txtReason.setBounds(120, 134, 246, 51);
        panelApproveAnRequest.add(txtReason);

        txtApproverID = new JTextField(lH.getApproverID());
        txtApproverID.setColumns(10);
        txtApproverID.setBounds(120, 196, 246, 20);
        panelApproveAnRequest.add(txtApproverID);

        lblSubmissionDate = new JLabel("Submission Date:");
        lblSubmissionDate.setBounds(10, 230, 100, 14);
        panelApproveAnRequest.add(lblSubmissionDate);

        txtSubmissionDate = new JTextField(lH.getSubmissionDate().toString());
        txtSubmissionDate.setEditable(false);
        txtSubmissionDate.setColumns(10);
        txtSubmissionDate.setBounds(120, 227, 246, 20);
        panelApproveAnRequest.add(txtSubmissionDate);

        panelReason = new JPanel();
        panelReason.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "<html><div style=\"font-size:20px\">Reason For Refusal</div></html>", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        add(panelReason, "panelReason");
        panelReason.setLayout(null);

        btnSend = new JButton("Send");
        btnSend.setBounds(20, 225, 247, 23);
        panelReason.add(btnSend);

        textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 15));
        textArea.setBounds(10, 30, 355, 184);
        panelReason.add(textArea);

        btnBack = new JButton("Back");
        btnBack.setBounds(276, 225, 89, 23);
        panelReason.add(btnBack);

        btnApprove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateApprovateStatus(e);
            }
        });

        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateApprovateStatus(e);
            }
        });

        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitReasonForRefusal();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) getLayout();
                layout.show(ProcessingLeaveRequests.this, "panelApproveAnRequest");
            }
        });
    }

//    public void setFormData() {
//        txtEmployeeName.setText(employeeName);
//        txtLeaveType.setText(leaveType);
//        txtStartDate.setText(startDate);
//        txtEndDate.setText(endDate);
//        txtReason.setText(reason);
//        txtApproverID.setText(approverID);
//        txtSubmissionDate.setText(submissionDate);
//        txtStatus.setText(status);
//    }

    public void UpdateApprovateStatus(ActionEvent e) {
    	
        String actionCommand = e.getActionCommand();

        var dao = new LeaveHRDao();

         
        

        switch (actionCommand) {
        case "Approved" -> {
        	var str = role.getRoleName() == "Admin" ? "Approved by HR" : "Approved by Lead";
            dao.UpdateApproveStatus(str, user.getEmployeeID(), lh.getHistoryId());
            JOptionPane.showMessageDialog(null, "Successfully");
            txtStatus.setText(btnApprove.getText());
            txtStatus.setText("Approved");
            pA.getProcessingLeaveRequestFrame().setVisible(false);
            this.setVisible(false);
        }
        case "Reject" -> {
            if (JOptionPane.showConfirmDialog(null, "You definitely want to reject?", "Notification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                return;
            }
            
            
            CardLayout layout = (CardLayout) getLayout();
            layout.show(this, "panelReason");
        }
        }
        
        
        pA.showAllRequest();
    }
    
//    public void addApproveActionListener(ActionListener Listener) {
//    	btnApprove.addActionListener(Listener);
//    }
//    public void addRejeckActionListener(ActionListener Listener) {
//    	btnReject.addActionListener(Listener);
//    }

    private void submitReasonForRefusal() {
        LeaveHRDao dao = new LeaveHRDao();

        String reason = textArea.getText();
        if (reason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide a reason for refusal.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
        
        dao.UpdateApproveStatus("Rejected", lh.getApproverID(), lh.getHistoryId());
//        dao.UpdateRejectionReason(reason, idRequest);

//        ApproveAnRequest parentFrame = ApproveAnRequest.getInstance();
//        parentFrame.showAllRequest();
        
        JOptionPane.showMessageDialog(this, "Leave request rejected successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        pA.getProcessingLeaveRequestFrame().setVisible(false);
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, "panelApproveAnRequest");
    }
}
