public class Person {
    private String name;
    private String surName;
    private String email;

    public Person(String name, String surName, String email  ){
        this.name = name;
        this.surName = surName;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public String getEmail(){
        return email;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setSurName(String surName){
        this.surName = surName;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void displayPersonInfo(){
        System.out.println("Name: " + name + " " + surName);
        System.out.println("Email: " + email);
    }

}
