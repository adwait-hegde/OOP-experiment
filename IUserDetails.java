public interface IUserDetails {

    int age=0;
    String phone="9833512267";
    String location = "Mumbai, India";
    char gender = 'N';

    void editUsername(String username);
    void editPassword(String password);
    void editAge(int age);
    void editPhone(String phone);
    void editLocation(String location);
    void editGender(char gender);
    void print();
   
}
