package subFrame;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import dao.LeaveHRDao;
import entity.Employees;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class FormApprove extends JInternalFrame {
	private static FormApprove instance;
	private JPanel panelApproveAnRequest;
    private JTextField txtEmployeeName;
    private JTextField txtLeaveType;
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private JTextField txtReason;
    private JTextField txtApproverID;
    private JTextField txtSubmissionDate;
    private JTextField txtStatus;
    private JLabel lblStartDate_1;
	private JButton btnApprove;
    private JButton btnReject;	    
    private JPanel panelReason;
	private JTextArea textArea;
	private JButton btnSubmit;
    private Integer idRequest;
    private int id;
	private Employees emp = new Employees();
	static int idEmp;

	
//	public static int getIdEmp() {
//		return idEmp;
//	}
//	
//	public static void setIdEmp(int idEmp) {
//		MyRequest.idEmp = idEmp;
//	}
	
    public static FormApprove getInstance() {
        if (instance == null) {
            instance = new FormApprove();
        }
        return instance;
    }

    /**
     * Create the frame.
     */
    public FormApprove() {
    	setIconifiable(true);
    	addAncestorListener(new AncestorListener() {
    		public void ancestorAdded(AncestorEvent event) {
    			thisAncestorAdded(event);
    		}
    		public void ancestorMoved(AncestorEvent event) {
    		}
    		public void ancestorRemoved(AncestorEvent event) {
    		}
    	});
        setClosable(true);
        setTitle("Approve Request");
        setBounds(100, 100, 402, 280);
        getContentPane().setLayout(new CardLayout(0, 0));

        panelApproveAnRequest = new JPanel();
        getContentPane().add(panelApproveAnRequest, "panelApproveAnRequest");
        panelApproveAnRequest.setLayout(null);

        JLabel lblEmployeeName = new JLabel("Employee Name:");
        lblEmployeeName.setBounds(10, 55, 100, 14);
        panelApproveAnRequest.add(lblEmployeeName);

        txtEmployeeName = new JTextField();
        txtEmployeeName.setBounds(120, 52, 246, 20);
        panelApproveAnRequest.add(txtEmployeeName);
        txtEmployeeName.setColumns(10);

        JLabel lblLeaveType = new JLabel("Leave Type:");
        lblLeaveType.setBounds(10, 80, 100, 14);
        panelApproveAnRequest.add(lblLeaveType);

        txtLeaveType = new JTextField();
        txtLeaveType.setBounds(120, 77, 246, 20);
        panelApproveAnRequest.add(txtLeaveType);
        txtLeaveType.setColumns(10);

        JLabel lblStartDate = new JLabel("Effective Time:");
        lblStartDate.setBounds(10, 105, 100, 14);
        panelApproveAnRequest.add(lblStartDate);

        txtStartDate = new JTextField();
        txtStartDate.setBounds(120, 102, 100, 20);
        panelApproveAnRequest.add(txtStartDate);
        txtStartDate.setColumns(10);

        txtEndDate = new JTextField();
        txtEndDate.setBounds(266, 102, 100, 20);
        panelApproveAnRequest.add(txtEndDate);
        txtEndDate.setColumns(10);

        JLabel lblReason = new JLabel("Reason:");
        lblReason.setBounds(10, 130, 100, 14);
        panelApproveAnRequest.add(lblReason);

        txtReason = new JTextField();
        txtReason.setBounds(120, 130, 246, 51);
        panelApproveAnRequest.add(txtReason);
        txtReason.setColumns(10);

        JLabel lblApproverID = new JLabel("Approver ID:");
        lblApproverID.setBounds(10, 195, 100, 14);
        panelApproveAnRequest.add(lblApproverID);

        txtApproverID = new JTextField();
        txtApproverID.setBounds(120, 192, 246, 20);
        panelApproveAnRequest.add(txtApproverID);
        txtApproverID.setColumns(10);

        JLabel lblSubmissionDate = new JLabel("Submission Date:");
        lblSubmissionDate.setBounds(10, 226, 100, 14);
        panelApproveAnRequest.add(lblSubmissionDate);

        txtSubmissionDate = new JTextField();
        txtSubmissionDate.setBounds(120, 223, 246, 20);
        panelApproveAnRequest.add(txtSubmissionDate);
        txtSubmissionDate.setColumns(10);

        txtStatus = new JTextField();
        txtStatus.setBounds(293, 8, 73, 20);
        panelApproveAnRequest.add(txtStatus);
        txtStatus.setColumns(10);

        btnApprove = new JButton("Approved");
        btnApprove.setBounds(10, 7, 89, 23);
        btnApprove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	UpdateApprovateStatus(e);
            }
        });
        panelApproveAnRequest.add(btnApprove);

        lblStartDate_1 = new JLabel("=>");
        lblStartDate_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStartDate_1.setBounds(230, 105, 26, 14);
        panelApproveAnRequest.add(lblStartDate_1);

        btnReject = new JButton("Reject");
        btnReject.setBounds(109, 7, 89, 23);
        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	UpdateApprovateStatus(e);
            }
        });
        panelApproveAnRequest.add(btnReject);
        
        panelReason = new JPanel();
        panelReason.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "<html><div style=\"font-size:12px\">Reason For Refusal</div><html>", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        getContentPane().add(panelReason, "panel");
        panelReason.setLayout(new BorderLayout(0, 0));
        
        textArea = new JTextArea();
        textArea.setBackground(new Color(255, 255, 255));
        panelReason.add(textArea, BorderLayout.CENTER);
        
        btnSubmit = new JButton("Submit");
        panelReason.add(btnSubmit, BorderLayout.SOUTH);

        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panelApproveAnRequest");

        addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                txtStatus.setText("Waiting");
            }
        });
    }
    
    public void setFormData(int idUser, int historyId ,String employeeName, String leaveType, String startDate, String endDate, String reason, String approverID, String submissionDate, String status) {
        txtEmployeeName.setText(employeeName);
        txtLeaveType.setText(leaveType);
        txtStartDate.setText(startDate);
        txtEndDate.setText(endDate);
        txtReason.setText(reason);
        txtApproverID.setText(approverID);
        txtSubmissionDate.setText(submissionDate);
        txtStatus.setText(status);
        idRequest = historyId;
        id = idUser;
    }
    

    protected void UpdateApprovateStatus(ActionEvent e) {
    	String actionCommand = e.getActionCommand();
    	
    	var dao = new LeaveHRDao();
    	dao.UpdateApproveStatus("Watching",id, idRequest);
//    	ApproveAnRequest parentFrame = ApproveAnRequest.getInstance();
    	
    	
    	switch (actionCommand) {
		case "Approved" -> {
			dao.UpdateApproveStatus(btnApprove.getText(),id, idRequest );  
			JOptionPane.showMessageDialog(null, "Successfully");
			txtStatus.setText(btnApprove.getText());
			txtStatus.setText("Approved");
	        txtApproverID.setText(String.valueOf(idEmp));
			
			this.setVisible(false);
		}
		
		case "Reject" -> {
			if(JOptionPane.showConfirmDialog(null, "You definitely want to ???", "Notification", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
    			return;
    		}
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panel");
			btnSubmit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                submitReasonForRefusal();
	            }
	        });
			}	
    	}
    	
    	// Update the main table in ApproveAnRequest
//    	parentFrame.showAllRequest();
    	
    	
    }
    
    
    private void submitReasonForRefusal() {
        String reason = textArea.getText().trim();
        if (reason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reason cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panelApproveAnRequest");
            return;
        }
        
        //lưu xuống data
        var dao = new LeaveHRDao();
        dao.UpdateApproveStatus(btnApprove.getText(),id, idRequest);
    	txtStatus.setText(btnReject.getText());
    	txtStatus.setText("Rejected");
        txtApproverID.setText(String.valueOf(idEmp));
    	JOptionPane.showMessageDialog(null, "Successfully");
    	this.setVisible(false);
    }
    protected void thisAncestorAdded(AncestorEvent event) {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panelApproveAnRequest");
	}
    
}

