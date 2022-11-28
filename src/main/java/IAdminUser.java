public interface IAdminUser extends IUser{
    void deleteUser(String username);
    IUser createNewUser(String username, boolean isAdmin);
    void viewAllUsers();
}
