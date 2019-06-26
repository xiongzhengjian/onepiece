package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.SoftpaqDaoImpl;
import com.wistron.dao.SoftpaqDaoImpl2;
import com.wistron.pojo.Softpaq;
import com.wistron.pojo.Softpaq2;

public class DaoTest_Softpaq {
	
	private SoftpaqDaoImpl softpaqDaoImpl;
	private SoftpaqDaoImpl2 softpaqDaoImpl2;
	
	@Before
	public void initFactory() throws Exception {		
		softpaqDaoImpl = new SoftpaqDaoImpl();
		softpaqDaoImpl2 = new SoftpaqDaoImpl2();
	}		
	
	
	@Test
	public void insertSoftpaqs() throws Exception {		
		List<Softpaq> list = new ArrayList<Softpaq>();
		Softpaq s1 = new Softpaq("Tester1","NesslerPxx","Sunflower","SP96602","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		Softpaq s2 = new Softpaq("Tester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		list.add(s1);
		list.add(s2);
		softpaqDaoImpl.insertMultiple(list);
		
		
	}
	
	
	@Test
	public void findAllSoftpaq() throws Exception {		
		List<Softpaq> list = softpaqDaoImpl.findAll();
		System.out.println(list);
		
	}
	
	
	@Test
	public void updateSoftpaq() throws Exception {
		Softpaq data = new Softpaq(5,"AlterTester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		int row = softpaqDaoImpl.update(data);
		
	}
	
	/*------------------------------Softpaq2----------------------------------*/
	@Test
	public void insertSoftpaqs2() throws Exception {		
		List<Softpaq2> list = new ArrayList<Softpaq2>();
		Softpaq2 s1 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","Dyson - HP ENVY 795-0xxx Desktop","PASS","PASS","PASS","1","Only test in CFL project(Luton not support)");
		Softpaq2 s2 = new Softpaq2("Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","DysonP - HP Pavilion Gaming 790-0xxx Desktop","PASS","PASS","PASS","2","Only test in CFL project(Luton not support)");
		list.add(s1);
		list.add(s2);
		softpaqDaoImpl2.insertMultiple(list);
		
		
	}
	
	@Test
	public void findAllSoftpaq2() throws Exception {		
		List<Softpaq2> list = softpaqDaoImpl2.findAll();
		System.out.println(list);
		
	}
	
	@Test
	public void updateSoftpaq2() throws Exception {
		Softpaq2 data = new Softpaq2(5,"Elva",new Date(),new Date(),"SP960669","Intel Management Engine Interface (MEI) Driver","1904.12.0.1208 - A - 16","Evans 1C18 - HP Slim 290-p0xxx Desktop","PASS","PASS","PASS","5","Only test in CFL project(Luton not support)");
		int row = softpaqDaoImpl2.update(data);
		
	}
	

	
	
}
