package myOwnAnnotation;

public class ServiceImpl implements Service {

	@Override
	public void serve() {
		System.out.println("Served from Impl.");
	}

}
