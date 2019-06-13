package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.BiosDaoImpl;
import com.wistron.pojo.Bios;

public class DaoTest_Bios {
	
	private BiosDaoImpl biosDao;
	
	@Before
	public void initFactory() throws Exception {		
		biosDao = new BiosDaoImpl();
	}		
	
	/**
	 * 'Sunny','Nicolas','LincsB','bios pre-test','2019-02-05 14:25:30',
	 * '2019-05-11 11:05:30','F.10','18WW2SVT6AF',
	 * 'CDT-BIOS-Checklist_v4.6_pre-test','littlebear'
	 * @throws Exception
	 */
	@Test
	public void insertBioses() throws Exception {		
		List<Bios> bioses = new ArrayList<Bios>();
		
		Bios b1 = new Bios("Sunny3","Nicolas","LincsB","bios pre-test",new Date(),new Date(),"F.10","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		Bios b2 = new Bios("Sunny4","Nicolas","LincsB","bios pre-test",new Date(),new Date(),"F.10","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		bioses.add(b1);
		bioses.add(b2);
		biosDao.insertBioses(bioses);
		
		
	}
	
	
	

	
	
}
