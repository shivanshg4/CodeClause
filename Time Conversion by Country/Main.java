package pkg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	
	JButton change;
	JLabel printFirst, printSecond;
	JComboBox regionFirst, regionSecond; 
	
	public Main() {
		
		JLabel titel = new JLabel("Date And Time Convertor");
		titel.setBounds(90,5,200,20);
		titel.setFont(new Font("Ariel",Font.BOLD,15));
		add(titel);
		
		JLabel first = new JLabel("From : ");
		first.setBounds(60,80,200,20);
		first.setFont(new Font("Ariel",Font.BOLD,15));
		add(first);
		
		String[] list1 = {"Asia/Kolkata" , "Asia/Tashkent" , "Asia/Kuwait"};
		regionFirst = new JComboBox(list1);
		regionFirst.setBounds(120,80,200,20);
		regionFirst.setFont(new Font("Ariel",Font.BOLD,15));
		add(regionFirst);
		
		JLabel second = new JLabel("To : ");
		second.setBounds(60,120,200,20);
		second.setFont(new Font("Ariel",Font.BOLD,15));
		add(second);
		
		String[] list2 = {"America/New_York", "Europe/London", "Asia/Tokyo"};
		regionSecond = new JComboBox(list2);
		regionSecond.setBounds(120,120,200,20);
		regionSecond.setFont(new Font("Ariel",Font.BOLD,15));
		add(regionSecond);
		
		printFirst = new JLabel();
		printFirst.setBounds(60,160,350,20);
		printFirst.setFont(new Font("Ariel",Font.BOLD,15));
		add(printFirst);
		
		printSecond = new JLabel();
		printSecond.setBounds(60,200,350,20);
		printSecond.setFont(new Font("Ariel",Font.BOLD,15));
		add(printSecond);
		
		change = new JButton("Change");
		change.setBounds(110,280,160,20);
		change.setFont(new Font("Ariel",Font.BOLD,15));
		add(change);
		change.addActionListener(this);
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(500,150,400,400);
		setTitle("Time Conversion");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] arg) {
		new Main();
		
	}
	
	String[] getTime(String region1, String region2) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter Local Zone eg.(Asia/Kolkata, Asia/Tashkent, Asia/Kuwait): ");
//		String localZoneStr = sc.nextLine();
		ZoneId localZoneId = ZoneId.of(region1);
		
//		System.out.print("Enter New Zone (e.g. America/New_York, Europe/London, Asia/Tokyo): ");
//		String newZoneStr = sc.nextLine();
		ZoneId newZoneId = ZoneId.of(region2);
		
		LocalDateTime localTime = LocalDateTime.now(localZoneId) ;
		LocalDateTime currentTime = LocalDateTime.now(newZoneId);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:MM:ss");
		String localstr = formatter.format(localTime);
		String newstr = formatter.format(currentTime);
		
		String[] result = {(region1+ ":" +localstr), (region2 + ":"+ newstr) };
		return result;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==change) {
			String str1 = (String) regionFirst.getSelectedItem();
			String str2 = (String) regionSecond.getSelectedItem();
			String[] ans = getTime(str1,str2);
			printFirst.setText(ans[0]);
			printSecond.setText(ans[1]);
		}
		
	}
}
