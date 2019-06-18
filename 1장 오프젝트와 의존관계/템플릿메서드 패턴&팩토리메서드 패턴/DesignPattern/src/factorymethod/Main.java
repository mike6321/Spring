package factorymethod;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotFactory rf = new SuperRobotFactory();
		Robot r = rf.createRobot("super");
		Robot r2 = rf.createRobot("power");
		
		System.out.println(r.getName());
		System.out.println(r2.getName());
		
	}

}
