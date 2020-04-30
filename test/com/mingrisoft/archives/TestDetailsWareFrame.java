package com.mingrisoft.archives;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.api.server.Container;

public class TestDetailsWareFrame {
	private JButton excelButton;
	JFrame mainJFrame;
	   Container con;
	   JScrollPane JSPane;
	   JTable table;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	@Test
	public void test() {
		
		 mainJFrame = new JFrame();
	     Object[][] playerInfo={
	        {"张三","",new Integer(6500),new Integer(2000),new Integer(200)},
	        {"李四","",new Integer(4500),new Integer(1000),new Integer(300)},
	     };
	     String[] Names={"姓名","职务","工资","奖金","罚款"};
	     //创建带内容和表头信息的表格
	     table=new JTable(playerInfo,Names);
	     JSPane=new JScrollPane(table);
	     mainJFrame.add(JSPane);
	     mainJFrame.setTitle("JTable");
	     mainJFrame.setSize(300,200);
	     mainJFrame.setVisible(true);
	     mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	        
		       
		      
		excelButton = new JButton("导出excel");
		excelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		do_closeButton_actionPerformed(e);
				 File file = new File("C://货品详情工作表.xls");
				ExcelExporter cel=new ExcelExporter();
				
				//当前时间
				Calendar cal = Calendar.getInstance();   //获取当前时间
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //格式化日期
				String mDateTime=formatter.format(cal.getTime());
				
				
				cel.export(file, "货品详情", mDateTime,table);
				
				
			}
		});
		excelButton.setBounds(350, 500, 93, 23);
	
		
	}

}
