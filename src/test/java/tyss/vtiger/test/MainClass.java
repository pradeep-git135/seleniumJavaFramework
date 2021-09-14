package tyss.vtiger.test;

public class MainClass {

	public static void main(String[] args) {
		A a=new B();
		System.out.println(a.myName("Priyanka"));
	}
}
class A{
	
	public String myName(String name) {
		return name;
	}
}

class B extends A{
	@Override
	public String myName(String name) {
		return "Hi "+name;
	}
}
