package myOwnAnnotation;

import java.lang.reflect.Field;

public class MyOwnAnnotation {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("myOwnAnnotation.Facade");

		// .getDeclaredFields() return public and private fields
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			MyInject myInject = field.getAnnotation(MyInject.class);
			if (myInject != null) {
				System.out.printf("Field %s is annotated with %s", field, myInject);
				System.out.println();
				Object facade = clazz.newInstance();
				Class<?> serviceType = field.getType();

				String simpleName = serviceType.getSimpleName();
				String className = simpleName + "Impl";
				String packageName = serviceType.getPackage().getName();
				String fullName = packageName + "." + className;
				Object service = Class.forName(fullName).newInstance();
				// Object service = serviceType.newInstance();
				// if field is private you can fix this with
				// setAccessible(true), otherwise IllegalAccessException
				field.setAccessible(true);
				//09 Decorate the service
				field.set(facade, Decorator.decorate(service));
				Facade typedFacade = (Facade) facade;
				typedFacade.invokeService();
				System.out.println("Facade: " + facade);
			} else {
				System.out.printf("Field %s is not annotated", field);
			}
			System.out.println();

		}
	}

}
