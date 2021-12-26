public abstract class Person {
    protected String name;
    private String DOB;
    private String sex;
    protected String[] ID;


    public Person(String nameIn, String DOBIn, String sexIn, String[] IDIn){
        name= nameIn;
        DOB = DOBIn;
        sex=sexIn;
        ID=IDIn;
    }


    public  String[] getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getSex(){
        return sex;
    }

    public String getDOB(){
        return DOB;
    }
}
