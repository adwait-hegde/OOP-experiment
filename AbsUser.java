public abstract class AbsUser implements IUserDetails, IUserAuth {
    private String username;
    private String password;
    
    private int age;
    private String phone;
    private String location;
    private char gender;

    //parameterised onstructors
    public AbsUser(String username, String password){
        this.username = username;
        this.password=password;
        age = 0;
        location = "Mumbai,India";
        gender='O'; 
    }

    public AbsUser(String username, String password, int age, String phone, String location){
        this(username,password);
        this.age = age;
        this.phone = phone;
        this.location = location;
    }

    public AbsUser(String username, String password, int age, String phone, String location, char gender){
        this(username, password, age, phone, location);
        this.gender = gender;
    }

    //method for logging in
    public boolean login(String username,String password){
        return this.password.equals(password) && this.username.equals(username);
    }

    //getter for age
    public int getAge(){
        return this.age;
    }

    //getter for username
    public String getUsername(){
        return this.username;
    }


    public void editUsername(String username){
        this.username=username;
    }
    public void editPassword(String password){
        this.password=password;
    }
    public void editAge(int age){
        this.age=age;
    }
    public void editPhone(String phone){
        this.phone=phone;
    }
    public void editLocation(String location){
        this.location=location;
    }
    public void editGender(char gender){
        this.gender=gender;
    }
   
    //prints the details of the user
    public void print(){
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        System.out.println("Age: "+age);
        System.out.println("Phone: "+phone);
        System.out.println("Location: "+location);
        System.out.println("Gender: "+gender);
    }    
}
