package component;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;



public class Pagination extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnFirst;
	private JButton btnPrivious;
	private JButton btnNext;
	private JButton btnLast;
	private JTextField txtSearch;
	private Integer pageNumber = 1; //Trang thu may
	private Integer rowOfPage = 10; // So dong mac dinh trong trang
	private Integer totalRow = 0; // so dong trong database
	private Double totalPage = 1.0; // Tong so trang
	private JTextField txtPage;
	private JLabel lblStatusPage;
	/**
	 * Create the panel.
	 */
	
	
	
	public Pagination() {
		setLayout(new MigLayout("", "[105.00][107.00][][105.00][105.00][56.00,grow]", "[30.00][]"));
		
		lblStatusPage = new JLabel("1");
		lblStatusPage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblStatusPage, "cell 0 0");
		
		btnFirst = new JButton("<< First");
		
		add(btnFirst, "cell 0 1,grow");
		
		btnPrivious = new JButton("< Privious");
		
		
		add(btnPrivious, "cell 1 1,grow");
		
		txtPage = new JTextField();
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		txtPage.setBackground(new Color(240, 240, 240));
		add(txtPage, "cell 2 1,grow");
		txtPage.setColumns(10);
		
		btnNext = new JButton("Next >");
		
			add(btnNext, "cell 3 1,grow");
			
			btnLast = new JButton("Last >>");
			
			add(btnLast, "cell 4 1,grow");
			
			txtSearch = new JTextField();
			txtSearch.setBackground(new Color(240, 240, 240));
			txtSearch.setBorder(new TitledBorder(new LineBorder(new Color(227, 227, 227), 2), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			add(txtSearch, "cell 5 1,grow");
			txtSearch.setColumns(10);
		
//		txtSearch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String text = txtSearch.getText();
//                if (text.trim().length() == 0) {
//                    rowSorter.setRowFilter(null);
//                } else {
//                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                }
//            }
//        });
		
		
		
	}
	

	public void addFirstButtonListener(ActionListener listener) {
		btnFirst.addActionListener(listener);
    }

    public void addPreviousButtonListener(ActionListener listener) {
        btnPrivious.addActionListener(listener);
    }

    public void addNextButtonListener(ActionListener listener) {
        btnNext.addActionListener(listener);
    }

    public void addLastButtonListener(ActionListener listener) {
        btnLast.addActionListener(listener);
    }
    
    public void addSearchListener(ActionListener listener) {
        txtSearch.addActionListener(listener);
    }
    
	public Integer setPagination(ActionEvent e, Integer num, Double totalPage) {
	String actionCommand = e.getActionCommand();
	
		switch (actionCommand) {
		case "<< First" ->{
			txtPage.setText((num = 1).toString());
		}
			
		case "Next >" -> {
			if (num < totalPage.intValue()) {	
			txtPage.setText((++num).toString());
			}
		}
		
		case "< Privious" -> {
			if(num > 1) {		
			txtPage.setText((--num).toString());
			}
		}
		
		case "Last >>" ->{
			num = totalPage.intValue();
			txtPage.setText(num.toString());
			
		}
	
	}
	 return num;
	}
	
	public String getStrSearch() {
		String str = txtSearch.getText();
		txtSearch.setText("");
		return str;
	}



	
	
}
