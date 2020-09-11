package yju.wdb.test;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTest {
	
	private Logger log = Logger.getLogger(SampleTest.class);
	 
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("----------------------------");
		log.info(restaurant.getChef());
	}
	
	public void test() {
		
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, @PathVariable("pid") int pid) {
		return new String[] {"category: " + cat, "product id: "+pid};
	}
}
