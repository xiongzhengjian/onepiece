package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.wistron.dao.SoftrollRespinDaoImpl;
import com.wistron.dao.WatDaoImpl;
import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.Wat;

public class DaoTest_SoftrollRespin {
	
	private SoftrollRespinDaoImpl daoImpl;
	
	@Before
	public void initFactory() throws Exception {		
		daoImpl = new SoftrollRespinDaoImpl();
	}		
	
	
	@Test
	public void insertMultiple() throws Exception {		
		List<SoftrollRespin> list = new ArrayList<SoftrollRespin>();
		SoftrollRespin data1 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","FIT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		SoftrollRespin data2 = new SoftrollRespin("Tester1_Java","Nessler","Sunflower","WAT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		list.add(data1);
		list.add(data2);
		daoImpl.insertMultiple(list);
		
		
	}
	
	
	@Test
	public void findAll() throws Exception {		
		List<SoftrollRespin> list = daoImpl.findAll();
		System.out.println(list);
		
	}
	
	
	@Test
	public void update() throws Exception {
		SoftrollRespin data1 = new SoftrollRespin(1,"Alter_Java","Nessler","Sunflower","FIT",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");		
		int row = daoImpl.update(data1);
		
	}
	
	
	
	
	

	
	
}
