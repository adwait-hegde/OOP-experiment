public interface IUserAuth {

    String username="noname";
    String password="Password";
    
    boolean login(String username,String password);
    void editUsername(String username);
    void editPassword(String password);
    
}
