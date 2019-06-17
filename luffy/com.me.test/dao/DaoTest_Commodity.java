package dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.wistron.dao.BiosDaoImpl;
import com.wistron.dao.CommodityDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.Commodity;

public class DaoTest_Commodity {
	
	private CommodityDaoImpl commodityDao;
	
	@Before
	public void initFactory() throws Exception {		
		commodityDao = new CommodityDaoImpl();
	}		
	
	/**
	 * 'Sunny','Nicolas','LincsB','bios pre-test','2019-02-05 14:25:30',
	 * '2019-05-11 11:05:30','F.10','18WW2SVT6AF',
	 * 'CDT-BIOS-Checklist_v4.6_pre-test','littlebear'
	 * @throws Exception
	 */
	@Test
	public void insertBioses() throws Exception {		
		List<Commodity> commodities = new ArrayList<Commodity>();
		//"Sunny2","NesslerP","Sunflower","HDD","SEAGATE 1T","924121-001","2019-06-08 14:25:30","2019-06-11 14:25:30","F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear"
		Commodity c1 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		Commodity c2 = new Commodity("Sunny2","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		commodities.add(c1);
		commodities.add(c2);
		commodityDao.insertCommodities(commodities);
		
		
	}
	
	
	@Test
	public void findAllCommodity() throws Exception {		
		List<Commodity> list = commodityDao.findAllCommodity();
		System.out.println(list);
		
	}
	
	
	@Test
	public void updateCommodity() throws Exception {
		Commodity c1 = new Commodity(1,"Sunny33","NesslerPxx","Sunflower","HDD","SEAGATE 1T","924121-001",new Date(),new Date(),"F.20","18WW2SVT6AF","CDT-BIOS-Checklist_v4.6_pre-test","littlebear");
		int row = commodityDao.updateCommodity(c1);
		
	}
	
	
	
	
	

	
	
}
