package di;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationFactoryTest {

	private ObjectFactory cut;
	
	@Before
	public void initialize() {
		this.cut = ObjectFactory.getInstance();
	}
	
	@Test
	public void productCreation() {
		Configuration product = (Configuration) this.cut.create();
		assertNotNull(product);
	}

}
