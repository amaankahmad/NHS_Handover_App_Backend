public class Task {
    private Patient patientObject;
    private String seniorityRequired;
    private String additionalNotes;
    private String history;
    private String creationTime;

    public Task(Patient patIn, String seniorIn, String notesIn, String historyIn, String creationTimeIn){
        patientObject=patIn;
        seniorityRequired=seniorIn;
        additionalNotes=notesIn;
        history=historyIn;
        creationTime=creationTimeIn;
    }

    public String getTime(){
        return creationTime;
    }

}
