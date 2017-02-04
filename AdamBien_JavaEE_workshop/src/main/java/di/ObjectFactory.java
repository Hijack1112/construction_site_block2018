package di;

public class ObjectFactory {

	private final static ObjectFactory INSTANCE = new ObjectFactory();

	// precache Configuration product
	private Object product;

	private ObjectFactory() {
		// this.product = new SystemPropertyConfiguration();
		try {
			// ... or using Reflections
			this.product = Class.forName("di.SystemPropertyConfiguration").newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
			throw new IllegalStateException("Product not found", ex);
		}

	}

	public static final ObjectFactory getInstance() {
		return INSTANCE;
	}

	public Object create() {
		return this.product;
	}

}
