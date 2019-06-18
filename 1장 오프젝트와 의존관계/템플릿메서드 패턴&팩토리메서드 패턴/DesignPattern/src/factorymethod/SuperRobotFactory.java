package factorymethod;
//5
public class SuperRobotFactory extends RobotFactory{

	@Override
	Robot createRobot(String name) {
		// TODO Auto-generated method stub
		switch (name) {
		case "super":
			
			return new SuperRobot();
		case "power":
			
			return new PowerRobot();
		}
		return null;
	}

}
