package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.WatDaoImpl;
import com.wistron.pojo.Wat;

public class DaoTest_Wat {
	
	private WatDaoImpl daoImpl;
	
	@Before
	public void initFactory() throws Exception {		
		daoImpl = new WatDaoImpl();
	}		
	
	
	@Test
	public void insertMultiple() throws Exception {		
		List<Wat> list = new ArrayList<Wat>();
		Wat data1 = new Wat("Tester1_Java","Nessler","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		Wat data2 = new Wat("Tester2_Java","NesslerPxx","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		list.add(data1);
		list.add(data2);
		daoImpl.insertMultiple(list);
		
		
	}
	
	
	@Test
	public void findAll() throws Exception {		
		List<Wat> list = daoImpl.findAll();
		System.out.println(list);
		
	}
	
	
	@Test
	public void update() throws Exception {
		Wat data1 = new Wat(1,"AlterTest_Java","NesslerPxx","Sunflower","Headset 4002","94256-5151",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		int row = daoImpl.update(data1);
		
	}
	
	
	
	
	

	
	
}
