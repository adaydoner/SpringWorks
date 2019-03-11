package springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(){
		
	}
	
	public TrackCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkoutRoutine() {
		return "Run a hard 5 km";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It : " + fortuneService.getFortune();
	}
	
	public void doMyStartupStaff(){
		System.out.println("TrackCoach: inside method doMyStartupStaff");
	}
	
	public void doMyCleanupStaff(){
		System.out.println("TrackCoach: inside method doMyCleanupStaff");
	}

}
