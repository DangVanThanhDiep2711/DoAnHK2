package component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.LeaveTypeDao;
import entity.LeaveType;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

public class LeaveTypes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField txtLeaveTypeID;
	private JTextField txtLeaveTypeName;
	private JTextField txtLeaveTypeDescription;
	private JTextField txtLeaveDaysPerYear;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblLeaveTypeID;
	private JLabel lblLeavetypename;
	private JLabel lblLeavetyppedescription;
	private JLabel lblLeavedaysperyear;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public LeaveTypes() {
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 991, 459);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtLeaveTypeID = new JTextField();
		txtLeaveTypeID.setBounds(103, 474, 98, 43);
		txtLeaveTypeID.setBackground(new Color(240, 240, 240));
		txtLeaveTypeID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		add(txtLeaveTypeID);
		txtLeaveTypeID.setColumns(10);

		txtLeaveTypeName = new JTextField();
		txtLeaveTypeName.setBounds(337, 474, 269, 43);
		txtLeaveTypeName.setBackground(new Color(240, 240, 240));
		txtLeaveTypeName.setColumns(10);
		txtLeaveTypeName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		add(txtLeaveTypeName);

		txtLeaveTypeDescription = new JTextField();
		txtLeaveTypeDescription.setBounds(150, 528, 688, 43);
		txtLeaveTypeDescription.setBackground(new Color(240, 240, 240));
		txtLeaveTypeDescription.setColumns(10);
		txtLeaveTypeDescription.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		add(txtLeaveTypeDescription);

		txtLeaveDaysPerYear = new JTextField();
		txtLeaveDaysPerYear.setBounds(722, 474, 116, 43);
		txtLeaveDaysPerYear.setBackground(new Color(240, 240, 240));
		txtLeaveDaysPerYear.setColumns(10);
		txtLeaveDaysPerYear.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 255)));
		add(txtLeaveDaysPerYear);

		btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(848, 481, 153, 28);
		btnNewButton.setMnemonic('I');
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertLeaveType();
			}
		});

		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(848, 520, 153, 28);
		btnNewButton_1.setMnemonic('u');
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLeaveType();
            }
        });

		lblLeaveTypeID = new JLabel("LeaveTypeID:");
		lblLeaveTypeID.setBounds(10, 480, 83, 28);
		add(lblLeaveTypeID);

		lblLeavetypename = new JLabel("LeaveTypeName:");
		lblLeavetypename.setBounds(211, 481, 116, 28);
		add(lblLeavetypename);

		lblLeavetyppedescription = new JLabel("LeaveTyppeDescription:");
		lblLeavetyppedescription.setBounds(10, 534, 130, 28);
		add(lblLeavetyppedescription);

		lblLeavedaysperyear = new JLabel("LeaveDaysPerYear:");
		lblLeavedaysperyear.setBounds(616, 480, 96, 28);
		add(lblLeavedaysperyear);

		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(848, 559, 153, 28);
		btnNewButton_2.setMnemonic('u');
		add(btnNewButton_2);
		// Load data into the table
		loadData();

		// Add selection listener to the table
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// Ensure the event is not fired during table updates
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						txtLeaveTypeID.setText(table.getValueAt(selectedRow, 0).toString());
						txtLeaveTypeName.setText(table.getValueAt(selectedRow, 1).toString());
						txtLeaveTypeDescription.setText(table.getValueAt(selectedRow, 2).toString());
						txtLeaveDaysPerYear.setText(table.getValueAt(selectedRow, 3).toString());
					}
				}
			}
		});
	}

	private void loadData() {
		var dao = new LeaveTypeDao();
		var leaveTypes = dao.selectAllLeaveTypes();
		var model = new DefaultTableModel(
				new Object[] { "LeaveTypeID", "LeaveTypeName", "LeaveTypeDescription", "LeaveDaysPerYear" }, 0);

		for (LeaveType lt : leaveTypes) {
			model.addRow(new Object[] { lt.getLeaveTypeID(), lt.getLeaveTypeName(), lt.getLeaveTypeDescription(),
					lt.getLeaveDaysPerYear() });
		}

		table.setModel(model);

		// Adjust column widths
		TableColumn column = null;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			switch (i) {
			case 0: // LeaveTypeID
				column.setPreferredWidth(50);
				break;
			case 1: // LeaveTypeName
				column.setPreferredWidth(200);
				break;
			case 2: // LeaveTypeDescription
				column.setPreferredWidth(300);
				break;
			case 3: // LeaveDaysPerYear
				column.setPreferredWidth(100);
				break;
			}
		}
	}

	private void insertLeaveType() {


		String leaveTypeIDText = txtLeaveTypeID.getText();
		String leaveTypeName = txtLeaveTypeName.getText();
		String leaveTypeDescription = txtLeaveTypeDescription.getText();
		String leaveDaysPerYearText = txtLeaveDaysPerYear.getText();

		if (leaveTypeIDText.isEmpty() || leaveTypeName.isEmpty() || leaveTypeDescription.isEmpty()
		        || leaveDaysPerYearText.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		int leaveTypeID;
		int leaveDaysPerYear;
		try {
		    leaveTypeID = Integer.parseInt(leaveTypeIDText);
		    leaveDaysPerYear = Integer.parseInt(leaveDaysPerYearText);
		} catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog(null, "LeaveTypeID and LeaveDaysPerYear must be valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		// Create LeaveType object
		LeaveType leaveType = new LeaveType();
		leaveType.setLeaveTypeID(leaveTypeID);
		leaveType.setLeaveTypeName(leaveTypeName);
		leaveType.setLeaveTypeDescription(leaveTypeDescription);
		leaveType.setLeaveDaysPerYear(leaveDaysPerYear);
	

		// Insert into database
		LeaveTypeDao dao = new LeaveTypeDao();
		boolean success = dao.insertLeaveType(leaveType);

		if (success) {
		    loadData();
		    txtLeaveTypeID.setText("");
		    txtLeaveTypeName.setText("");
		    txtLeaveTypeDescription.setText("");
		    txtLeaveDaysPerYear.setText("");
		} else {
		    JOptionPane.showMessageDialog(null, "Failed to insert LeaveType.", "Database Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateLeaveType() {
        String leaveTypeIDText = txtLeaveTypeID.getText();
        String leaveTypeName = txtLeaveTypeName.getText();
        String leaveTypeDescription = txtLeaveTypeDescription.getText();
        String leaveDaysPerYearText = txtLeaveDaysPerYear.getText();

        if (leaveTypeIDText.isEmpty() || leaveTypeName.isEmpty() || leaveTypeDescription.isEmpty()
                || leaveDaysPerYearText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int leaveTypeID;
        int leaveDaysPerYear;
        try {
            leaveTypeID = Integer.parseInt(leaveTypeIDText);
            leaveDaysPerYear = Integer.parseInt(leaveDaysPerYearText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "LeaveTypeID and LeaveDaysPerYear must be valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create LeaveType object
        LeaveType leaveType = new LeaveType();
        leaveType.setLeaveTypeID(leaveTypeID);
        leaveType.setLeaveTypeName(leaveTypeName);
        leaveType.setLeaveTypeDescription(leaveTypeDescription);
        leaveType.setLeaveDaysPerYear(leaveDaysPerYear);

        // Update in database
        LeaveTypeDao dao = new LeaveTypeDao();
        boolean success = dao.updateLeaveType(leaveType);

        if (success) {
            loadData();
            txtLeaveTypeID.setText("");
            txtLeaveTypeName.setText("");
            txtLeaveTypeDescription.setText("");
            txtLeaveDaysPerYear.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update LeaveType.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
