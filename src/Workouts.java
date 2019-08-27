import java.util.ArrayList; 
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;




public class Workouts {  

  private final ArrayList<Workout> workoutList = new ArrayList<Workout>(); 
  
  public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
  {
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    workoutList.add(newWorkout);
  }
  
  public final void addWorkout(Workout workout)
  {
    workoutList.add(workout);
  }
  
  public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasPrimaryMuscle(m)) {
        retval.addWorkout(w);
      }
      else if (includeSecondary && w.hasSecondaryMuscle(m)) { 
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary){
  	Workouts retval = new Workouts();
  	for(int i = 0; i < workoutList.size() ; i++){
  		for(int j = 0; j < m.size(); j++){
  			Config.Muscle primary = m.get(j);
  			if(workoutList.get(i).hasPrimaryMuscle(primary)){
  				retval.addWorkout(workoutList.get(i));
  			}
  			else if(includeSecondary && workoutList.get(i).hasSecondaryMuscle(primary)){
  				retval.addWorkout(workoutList.get(i));
  			}
  		}
  	}
  	return retval;
  }

	public final Workouts getWorkoutsByEquipment(Config.Equipment e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final ArrayList<String> getEquipment(){
  	ArrayList<String> retVal = new ArrayList<String>();
  	for(int i = 0; i < workoutList.size(); i++){
  		if(!(retVal.contains(workoutList.get(i).getEquipment()))){
  			retVal.add(workoutList.get(i).getEquipment());
  		}
  	}
  	return retVal;
  }
  
  public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final ArrayList<String> getNames()
  {
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout w : workoutList) {
      retval.add(w.getName());
    }
    return retval;
  }
 
  public final ArrayList<String[]> getFullInformation()
  {
    ArrayList<String[]> retval = new ArrayList<String[]>();
    for(Workout w : workoutList) {
      String[] info = new String[6];
      info[0] = w.getName();
      info[1] = w.getEquipment();
      info[2] = w.getPrimaryMuscle();
      info[3] = w.getSecondaryMuscle();
      info[4] = w.getDesc();
      info[5] = w.getReminders();
      retval.add(info);
    }
    return retval; 
  }
  
  public final int size(){
  	return workoutList.size();
  }
  
  public final Workout getWorkout(int index){
  	return workoutList.get(index);
  }
  
  public final String getWorkoutEquipment(int index){
  	Workout w = workoutList.get(index);
  	String retVal = w.getEquipment();
  	return retVal;
  }
  
  public final int findWorkoutByName(String name){
  	for(int i = 0; i < workoutList.size(); i++){
  		Workout w = workoutList.get(i);
  		if (w.getName().equals(name)){
  			return i;
  		}
  	}
  	return -1;
  }
}