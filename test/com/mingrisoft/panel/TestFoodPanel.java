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

		//把信息提示框放进for循环里面，就能对每一条过期的数据进行提示
				
	
	
		List list = dao.selectFood();
		
		
		
		//把信息提示框放进for循环里面，就能对每一条过期的数据进行提示
		for (int i = 0; i < list.size(); i++) {
			Food food = (Food)list.get(i);
			model.addRow(new Object[] { food.getId(), food.getFoodname(),
					food.getDescribe(),food.getUnit(),food.getPurchasing_cost(),food.getRetail_cost(),food.getVip_price(),food.getPromotion_price(),
					food.getProduced_date(),food.getExpriation_date()});
			
			
		}
		

				



				Date  produced_date=null;
				int expriation_date=0;
				String foodname="";
				int promotion_price=0;  //促销价
				 
				List list2 = dao.selectFood();
				for (int i = 0; i < list2.size(); i++) {
					Food food2 = (Food)list2.get(i);
					 produced_date=food2.getProduced_date();    //获取数据库的生产日期
					 expriation_date=food2.getExpriation_date();  //获取数据库的保质期保质期
					  foodname=food2.getFoodname();
					  promotion_price=food2.getPromotion_price();  //促销价
			//	}
				
				
				System.out.println("生产日期："+produced_date);  
				System.out.println("保质期："+expriation_date);
				
			//	try{	
				//当前时间
				Calendar cal = Calendar.getInstance();   //获取当前时间
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //格式化日期
				String mDateTime=formatter.format(cal.getTime());
				System.out.println(mDateTime);
				
				
				Date nowtime=new Date();//获取当前时间
				System.out.println("nowtime:"+nowtime);
				
				//比较两个时间之间的天数
				SimpleDateFormat myFormatter= new SimpleDateFormat("yyyy-MM-dd");
			
				
//				long day=(nowtime.getTime()-produced_date.getTime())/(24*60*60*1000);//计算当前的日期与生产日期相差几天
//				System.out.println(day);
				
				long rest=(produced_date.getTime()-nowtime.getTime())/(24*60*60*1000); 
				System.out.println(rest);
				long restday=rest+expriation_date;    // 生产日期-当前日期+保质期  =剩余日期
				System.out.println(restday);
				

				//在剩余天数小于或者等于30天的时候进行提醒
				if (restday==30) {
					System.out.println("距离过期还有30天!!");
					
				}
				
				else        //注意小于0的判断语句要放在小于30之前，要不会被促销处理执行，而非显示已经过期
					if(restday<=0)
				{   
						System.out.println(foodname+"已经过期"+Math.abs(restday)+"天，注意处理");
					
				}	//Math.abs(restday)  对负数取正
				
				
					else
						if(restday<30)
					{
							System.out.println(foodname+"距离过期还有"+restday+"天，注意促销处理，促销价为"+promotion_price+"元");
						
					}
				
						
					
				}
	}

}
