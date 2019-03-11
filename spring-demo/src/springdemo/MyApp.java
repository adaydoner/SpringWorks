package springdemo;

public class MyApp {

	public static void main(String[] args) {
		Coach myCoach = new TrackCoach();
		
		System.out.println(myCoach.getDailyWorkoutRoutine());
	}
}
