package com.code.server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.code.rmi.QuestionAnalysisRemote;
import com.code.value.FinalResult;
import com.code.value.QuestionRate;
import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.FontWeight;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
//import java.util.Date;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.Window.Type;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;


public class server_main {

	private JFrame frame;
	private JLabel time1;
	private JLabel date1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JPanel quection_panel;
	private JPanel analyse_panel;
	private JPanel chart_panel;
	
	GridBagLayout layout = new GridBagLayout();
	
		/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	 
		
		server_main window = new server_main();
	}

	/**
	 * Create the application.
	 */
	public server_main() {
		initialize();
		//clock();
		hidden();
		Registry reg=null;
		QuestionAnalysisRemote remote=null;
		
		try {
			reg=LocateRegistry.getRegistry(8888);
			remote=new RemoteImpl();
			reg.rebind("questionsremote", remote);
			System.out.println("Server starting..");
			
		} catch (Exception e) {
			try {
				
				reg=LocateRegistry.createRegistry(8888);
				remote=new RemoteImpl();
				reg.rebind("questionsremote", remote);
				System.out.println("Server starting..");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		quection_panel.setVisible(true);
		analyse_panel.setVisible(false);
		chart_panel.setVisible(false);
		
		label_2.setVisible(true);
		
		
		
		
	}
	
    
	
	  public void dpmethod(JPanel panel, GridBagLayout layout){
	  
	  panel.setLayout(layout); GridBagConstraints c = new GridBagConstraints();
	  c.gridx = 0; c.gridy = 0; panel.add(panel, c); panel.setVisible(true);
	  
	  
	  }
	 
	

	
	
	void hidden(){
		
		label_3.setVisible(false);
		label_4.setVisible(false);
		
	}
	
	
	  void setpanelkalu(JPanel x){
	        x.setBackground(new Color(51,51,51));
	    }
	
	  void resetpanell (JPanel x){
	        x.setBackground(new Color(102,102,102));
	    }
	  
	  void setblack(JPanel x){
	        x.setBackground(new Color(0,153,153));
	    }
	
	  void resetclick (JLabel x){
	        x.setForeground(new Color(0,153,153));
	    }
	  
	  
	  

	
	  /*
    public void showdate(){
        Date d = new Date(1);
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd [ E ]");
        String datee = adf.format(d);
        date1.setText(datee);
        
         }
    
        void showtime(){
        
        new Timer(0,(ActionEvent e) -> {
            Date d = new Date(2);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            String timee = sdf.format(d);
            time1.setText(timee);
        }).start();
   
    }
	
	public void clock()
		{
		Thread clock = new Thread()
		{
			public void run()
		{
		try
		{
			while(true)
			{
		Calendar cal = new GregorianCalendar();
				  		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
				
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int hou = cal.get(Calendar.HOUR);
		
		date1.setText(""+year+" / "+month+" / "+day+"");
		time1.setText(""+hou+" : "+min+" : "+sec+" ");
		sleep(1000);
			}			
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
						
		}}
	}
		;clock.start();
	}
	/*

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 997, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 997, 636);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 997, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBounds(756, 11, 54, 62);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\usernew1.png"));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblLoginAs = new JLabel("Login As :");
		lblLoginAs.setBounds(685, 27, 72, 46);
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginAs.setForeground(Color.WHITE);
		panel_1.add(lblLoginAs);
		
		JLabel lblAdmin = new JLabel("<html><b><i><u>Admin<u><i><b></html>");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAdmin.setBounds(820, 36, 66, 28);
		panel_1.add(lblAdmin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\cancel_1.png"));
		lblNewLabel_2.setBounds(935, 11, 40, 62);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblSurvayAboutAss = new JLabel("ABC Hospital Survey");
		lblSurvayAboutAss.setForeground(Color.WHITE);
		lblSurvayAboutAss.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSurvayAboutAss.setBounds(10, 29, 552, 27);
		panel_1.add(lblSurvayAboutAss);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 58, 341, 15);
		panel_1.add(separator_1);
		
		

		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 102, 235, 476);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				setpanelkalu(panel_4);			
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				resetpanell(panel_4);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//panelsetblack(panel_8);
				//setpanelkalu(panel_8);
				
				label_2.setVisible(true);
				label_3.setVisible(false);
				label_4.setVisible(false);
				
				
				
				analyse_panel.setVisible(false);
				chart_panel.setVisible(false);
				quection_panel.setVisible(true);
				
				
				
				
				JOptionPane.showMessageDialog(null, "hellp");
				panel.setVisible(true);
				
				
				//dpmethod(qeu, layout);
				/*
				 * showtime(); showdate();
				 */
				
				
			}
		});
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(10, 87, 215, 107);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel bbb = new JLabel("ANSWER DATA");
		bbb.setForeground(Color.LIGHT_GRAY);
		bbb.setFont(new Font("Tahoma", Font.BOLD, 20));
		bbb.setHorizontalAlignment(SwingConstants.CENTER);
		bbb.setBounds(24, 32, 165, 38);
		panel_4.add(bbb);
		
		JPanel panel_8 = new JPanel();
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_2.setVisible(true);
				label_3.setVisible(false);
				label_4.setVisible(false);
				
			
				analyse_panel.setVisible(false);
				chart_panel.setVisible(false);
				quection_panel.setVisible(true);
				
				
			
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				setpanelkalu(panel_4);
				
				
			}
		});
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setBounds(10, 11, 195, 85);
		panel_4.add(panel_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setpanelkalu(panel_5);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetpanell(panel_5);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				label_2.setVisible(false);
				label_3.setVisible(true);
				label_4.setVisible(false);
				//panel_11.setVisible(true);
				
				
				chart_panel.setVisible(false);
				analyse_panel.setVisible(true);
				quection_panel.setVisible(false);
			
				
				
				
			}
		});
		panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(10, 215, 215, 107);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblAnalyse = new JLabel("ANALYSE");
		lblAnalyse.setForeground(Color.LIGHT_GRAY);
		lblAnalyse.setBounds(45, 42, 120, 25);
		lblAnalyse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalyse.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lblAnalyse);
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				label_2.setVisible(false);
				label_3.setVisible(true);
				label_4.setVisible(false);
				
				chart_panel.setVisible(false);
				analyse_panel.setVisible(true);
				quection_panel.setVisible(false);
				
				
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setpanelkalu(panel_5);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetpanell(panel_5);
			}
		});
		panel_9.setBackground(Color.DARK_GRAY);
		panel_9.setBounds(10, 11, 195, 85);
		panel_5.add(panel_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//setpanelkalu(panel_6);
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(true);
				//panel_12.setVisible(true);
				
				
			
				chart_panel.setVisible(true);
				analyse_panel.setVisible(false);
				quection_panel.setVisible(false);
			
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetpanell(panel_6);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setpanelkalu(panel_6);
			}
		});
		panel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_6.setBackground(Color.GRAY);
		panel_6.setBounds(10, 347, 215, 107);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblChrta = new JLabel("VISION");
		lblChrta.setForeground(Color.LIGHT_GRAY);
		lblChrta.setHorizontalAlignment(SwingConstants.CENTER);
		lblChrta.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChrta.setBounds(43, 40, 120, 25);
		panel_6.add(lblChrta);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(true);
				
				chart_panel.setVisible(true);
				analyse_panel.setVisible(false);
				quection_panel.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setpanelkalu(panel_6);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetpanell(panel_6);
			}
		});
		panel_10.setBackground(Color.DARK_GRAY);
		panel_10.setBounds(10, 11, 195, 85);
		panel_6.add(panel_10);
		
		JLabel lblNewLabel = new JLabel("Welcome !");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(50, 11, 132, 39);
		panel_2.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 61, 173, 15);
		panel_2.add(separator);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(0, 601, 997, 35);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		date1 = new JLabel("date");
		date1.setBounds(843, 5, 144, 19);
		panel_7.add(date1);
		date1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		date1.setForeground(Color.WHITE);
		
		time1 = new JLabel("time");
		time1.setBounds(721, 5, 121, 19);
		panel_7.add(time1);
		time1.setForeground(Color.WHITE);
		time1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Tharaka\\\\Desktop\\img\\ahead.png"));
		label_2.setBounds(233, 213, 53, 71);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\ahead.png"));
		label_3.setBounds(233, 336, 53, 71);
		panel.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\ahead.png"));
		label_4.setBounds(233, 464, 53, 71);
		panel.add(label_4);
		
		quection_panel = new JPanel();
		quection_panel.setBackground(Color.white);
		quection_panel.setBounds(296, 102, 660, 476);
		panel.add(quection_panel);
		quection_panel.setLayout(null);
		setDataTable(quection_panel);
		analyse_panel = new JPanel();
		analyse_panel.setBounds(296, 102, 660, 476);
		panel.add(analyse_panel);
		analyse_panel.setBackground(Color.RED);
		analyse_panel.setLayout(null);
		
		chart_panel = new JPanel();
		chart_panel.setBounds(296, 102, 660, 476);
		panel.add(chart_panel);
		chart_panel.setBackground(Color.PINK);
		setAnswerTable(quection_panel);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Tharaka\\Desktop\\img\\w.jpg"));
		label.setBounds(0, 0, 997, 636);
		panel.add(label);
		setstatistics(analyse_panel);
		try {
			List<QuestionRate>qrk=Databaseworks.getQUestionKnow();
			List<QuestionRate>qru=Databaseworks.getQuestionrate();
			
			List<QuestionRate>qrpk=Databaseworks.getQUestionSet("SELECT avg(rate),gender FROM `result` inner join sessions on result.sessionid=sessions.sessionid where ratetype='Knowledge about medicine' group by gender");
		    List<QuestionRate>qrpu=Databaseworks.getQUestionSet("SELECT avg(rate),gender FROM `result` inner join sessions on result.sessionid=sessions.sessionid where ratetype='Can usage medicine' group by gender");
			loadstatics(qrk, qru);
			loadPieData(qrpk, qrpu);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setVisible(true);
	}
	JTable jTable1 ;
	private void setDataTable(JPanel jp) {
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
             
            },
            new String [] {
                "Session", "Age Range", "Gender", "Rate for","Rate out of 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jp.add(jScrollPane1);
        loadSessionData();
        jScrollPane1.setBounds(0, 10, 660, 206);
	}
	JTable jTable2;
	private void setAnswerTable(JPanel jp) {
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
             
            },
            new String [] {
                "Question No", "Answer", "Answered By"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jp.add(jScrollPane1);
        loadAnswerData();
        jScrollPane1.setBounds(0, 250, 660, 226);
	}
	
	private void loadSessionData() {
		DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
		try {
			ResultSet res=Databaseworks.getResultSet("SELECT * FROM `result` inner join sessions on result.sessionid=sessions.sessionid");
		     while(res.next()) {
		    	 df.addRow(new Object[] {res.getString(2),res.getString(7),res.getString(6),res.getString(3),res.getString(4)});
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadAnswerData() {
		DefaultTableModel df=(DefaultTableModel)jTable2.getModel();
		try {
			ResultSet res=Databaseworks.getResultSet("SELECT * FROM `answers` ");
		     while(res.next()) {
		    	 df.addRow(new Object[] {res.getString(2),res.getString(3),res.getString(4)});
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadstatics(List<QuestionRate>qrk,List<QuestionRate>qru) {
		PlatformImpl.startup(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Collections.reverse(qru);
				XYChart.Series<String, Number>ser=new XYChart.Series<>();
				ser.setName("Knowledge Level");
				for(QuestionRate qr:qrk) {
					
					ser.getData().add(new XYChart.Data<String, Number>(qr.getAge_range(), Integer.parseInt(qr.getValue().split("\\.")[0])));
					
					
				}
				
				XYChart.Series<String, Number>ser2=new XYChart.Series<>();
				ser2.setName("Usage Level");
				for(QuestionRate qr:qru) {
					
					ser2.getData().add(new XYChart.Data<String, Number>(qr.getAge_range(), Integer.parseInt(qr.getValue().split("\\.")[0])));
					System.out.println(qr.getAge_range());
					
				}
				bar2.getData().addAll(ser,ser2);
			}
		});
   PlatformImpl.startup(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		
		}
	});
	}
	
private void loadPieData(List<QuestionRate>lik,List<QuestionRate>liu) {
Platform.runLater(new Runnable() {
	
	@Override
	public void run() {
		ObservableList<PieChart.Data>lis=FXCollections.observableArrayList();
		for(QuestionRate qr:lik) {
			lis.add(new PieChart.Data(qr.getAge_range(), Integer.parseInt(qr.getValue().split("\\.")[0])));
		}
		ObservableList<PieChart.Data>lis2=FXCollections.observableArrayList();
		for(QuestionRate qr:liu) {
			lis2.add(new PieChart.Data(qr.getAge_range(), Integer.parseInt(qr.getValue().split("\\.")[0])));
		}
		pieKnow.setData(lis);
		pieUsab.setData(lis2);
		
	}
});
}
	BarChart<String, Number>bar2;
	PieChart pieKnow;
	PieChart pieUsab;
	private void setstatistics(JPanel jp) {
		
		PlatformImpl.startup(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JPanel content=new JPanel();
				
				JFXPanel pn=new JFXPanel();
				ScrollPane scroll=new ScrollPane();
				
				content.setBackground(Color.YELLOW);
				content.setSize(1167, 670);
				content.setLayout(new CardLayout());
				
				AnchorPane root=new AnchorPane();
				pieKnow=new PieChart();
				pieUsab=new PieChart();
				pieKnow.setTitle("Knowledge About Medicine by Gender");
				pieUsab.setTitle("Usability of Medicine by gender");
				AnchorPane.setTopAnchor(scroll, 0d);
				AnchorPane.setBottomAnchor(scroll, 0d);
				AnchorPane.setLeftAnchor(scroll, 0d);
				AnchorPane.setRightAnchor(scroll, 0d);
				
				
				
				Label l=new Label();
				l.setFont(javafx.scene.text.Font.font("Segoe UI", FontWeight.BOLD, 18));
				l.setTextFill(javafx.scene.paint.Color.web("#2196f3"));		
				
				CategoryAxis cat2=new CategoryAxis();
				cat2.setLabel("Age Ranges");
				
				NumberAxis num2=new NumberAxis();
				num2.setLabel("Level");
				bar2=new BarChart<>(cat2, num2);
				
				bar2.setTitle("Usage and Knowledge Level of medicine By Age Range");
			   bar2.setAnimated(false);
				
				AnchorPane.setLeftAnchor(l, 30d);
				AnchorPane.setTopAnchor(l, 40d);
			   AnchorPane.setRightAnchor(l, 30d);
			   l.setAlignment(Pos.CENTER);
				l.setMaxWidth(1100);

				
				AnchorPane.setTopAnchor(bar2, 50d);
				AnchorPane.setLeftAnchor(bar2, 30d);
				AnchorPane.setTopAnchor(pieKnow, 510d);
				AnchorPane.setLeftAnchor(pieKnow, 30d);
				AnchorPane.setTopAnchor(pieUsab, 930d);
				AnchorPane.setLeftAnchor(pieUsab, 30d);
				
				
				root.getChildren().addAll(scroll);
				AnchorPane acp=new AnchorPane();
				scroll.setContent(acp);
				acp.getChildren().addAll(l,bar2,pieKnow,pieUsab);
				Scene scene=new Scene(root,660, 476);
				root.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
				
				
				
				pn.setScene(scene);
				content.add(pn);
				content.setBounds(0, 0, 660, 476);
				jp.add(content);
				
			}
		});
	}
}
