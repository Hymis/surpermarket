package com.mingrisoft.panel;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mingrisoft.bean.Salary;
import com.mingrisoft.dao.SalaryDao;
import com.mingrisoft.model.SalaryModel;

public class TestSalaryPanel {
	private JTable table;
	SalaryDao salaryDao = new SalaryDao();
	SalaryModel model = new SalaryModel();
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
	public void SalaryPanel() {
		
		
		List list = salaryDao.selectSalary();
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {	
			Salary sal = (Salary)list.get(i);
			 model.addRow(new Object[] { sal.getId(), sal. geteNum(),
						sal.geteName(), sal.getdName(),
						sal.getBasicSalary(), sal.getBonus(),
						sal.getOthers(), sal.getTotalSalary()});
			 
			 System.out.println(sal.geteName());
		
		}
		

	}

}
