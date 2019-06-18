package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.SoftpaqDaoImpl;
import com.wistron.pojo.Softpaq;

public class DaoTest_Softpaq {
	
	private SoftpaqDaoImpl softpaqDaoImpl;
	
	@Before
	public void initFactory() throws Exception {		
		softpaqDaoImpl = new SoftpaqDaoImpl();
	}		
	
	
	@Test
	public void insertSoftpaqs() throws Exception {		
		List<Softpaq> list = new ArrayList<Softpaq>();
		Softpaq s1 = new Softpaq("Tester1","NesslerPxx","Sunflower","SP96602","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		Softpaq s2 = new Softpaq("Tester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		list.add(s1);
		list.add(s2);
		softpaqDaoImpl.insertSoftpaqs(list);
		
		
	}
	
	
	@Test
	public void findAllSoftpaq() throws Exception {		
		List<Softpaq> list = softpaqDaoImpl.findAllSoftpaq();
		System.out.println(list);
		
	}
	
	
	@Test
	public void updateSoftpaq() throws Exception {
		Softpaq data = new Softpaq(5,"AlterTester2","NesslerPxx","Sunflower","SP96603","NVIDIA GeForce Driver for VR1","26.21.14.3039-B-1",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		int row = softpaqDaoImpl.updateSoftpaq(data);
		
	}
	
	
	
	
	

	
	
}
