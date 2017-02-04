package di;

public class Client {

	//Move your Factory from Application to some kind of Framework == Dependency Injection. Implementation are provided from outside - this is called Inversion of Control IoC
	// @CreateFromFactory
	// static Configuration configuration;
	
	public static void main(String[] args) {
//		Configuration configuration = (Configuration) ObjectFactory.getInstance().create();
		//Trust the Framework that configuration would be available - contract between us and Framework!
	}

}
