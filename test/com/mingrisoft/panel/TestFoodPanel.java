package com.mingrisoft.panel;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mingrisoft.bean.Food;
import com.mingrisoft.dao.FoodDao;
import com.mingrisoft.model.FoodModel;

public class TestFoodPanel {
	FoodDao dao = new FoodDao();
	FoodModel model = new FoodModel();
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

		//����Ϣ��ʾ��Ž�forѭ�����棬���ܶ�ÿһ�����ڵ����ݽ�����ʾ
				
	
	
		List list = dao.selectFood();
		
		
		
		//����Ϣ��ʾ��Ž�forѭ�����棬���ܶ�ÿһ�����ڵ����ݽ�����ʾ
		for (int i = 0; i < list.size(); i++) {
			Food food = (Food)list.get(i);
			model.addRow(new Object[] { food.getId(), food.getFoodname(),
					food.getDescribe(),food.getUnit(),food.getPurchasing_cost(),food.getRetail_cost(),food.getVip_price(),food.getPromotion_price(),
					food.getProduced_date(),food.getExpriation_date()});
			
			
		}
		

				



				Date  produced_date=null;
				int expriation_date=0;
				String foodname="";
				int promotion_price=0;  //������
				 
				List list2 = dao.selectFood();
				for (int i = 0; i < list2.size(); i++) {
					Food food2 = (Food)list2.get(i);
					 produced_date=food2.getProduced_date();    //��ȡ���ݿ����������
					 expriation_date=food2.getExpriation_date();  //��ȡ���ݿ�ı����ڱ�����
					  foodname=food2.getFoodname();
					  promotion_price=food2.getPromotion_price();  //������
			//	}
				
				
				System.out.println("�������ڣ�"+produced_date);  
				System.out.println("�����ڣ�"+expriation_date);
				
			//	try{	
				//��ǰʱ��
				Calendar cal = Calendar.getInstance();   //��ȡ��ǰʱ��
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //��ʽ������
				String mDateTime=formatter.format(cal.getTime());
				System.out.println(mDateTime);
				
				
				Date nowtime=new Date();//��ȡ��ǰʱ��
				System.out.println("nowtime:"+nowtime);
				
				//�Ƚ�����ʱ��֮�������
				SimpleDateFormat myFormatter= new SimpleDateFormat("yyyy-MM-dd");
			
				
//				long day=(nowtime.getTime()-produced_date.getTime())/(24*60*60*1000);//���㵱ǰ��������������������
//				System.out.println(day);
				
				long rest=(produced_date.getTime()-nowtime.getTime())/(24*60*60*1000); 
				System.out.println(rest);
				long restday=rest+expriation_date;    // ��������-��ǰ����+������  =ʣ������
				System.out.println(restday);
				

				//��ʣ������С�ڻ��ߵ���30���ʱ���������
				if (restday==30) {
					System.out.println("������ڻ���30��!!");
					
				}
				
				else        //ע��С��0���ж����Ҫ����С��30֮ǰ��Ҫ���ᱻ��������ִ�У�������ʾ�Ѿ�����
					if(restday<=0)
				{   
						System.out.println(foodname+"�Ѿ�����"+Math.abs(restday)+"�죬ע�⴦��");
					
				}	//Math.abs(restday)  �Ը���ȡ��
				
				
					else
						if(restday<30)
					{
							System.out.println(foodname+"������ڻ���"+restday+"�죬ע���������������Ϊ"+promotion_price+"Ԫ");
						
					}
				
						
					
				}
	}

}
