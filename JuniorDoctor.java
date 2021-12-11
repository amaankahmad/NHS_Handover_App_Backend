public class JuniorDoctor extends Doctor{
    public JuniorDoctor(String nameIn, String DOBIn, String sexIn,String HospitalIDIn, String EmailIn, String numPagerIn){
        super(nameIn, DOBIn, sexIn, HospitalIDIn, EmailIn, numPagerIn);
    }

    public void takeUpTask(String task){
        //assigns task to themselves
    }

    public Task[] getTasks(String role){
        //Returns all task available to junior doctor, by calling the task model
    }
}
