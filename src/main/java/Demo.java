public class Demo {
    public static void main(String[] args) {
        IAdminUser masterGeorge = new AdminUserImpl("George");

        IUser userMimi = masterGeorge.createNewUser("Mimi", false);
        IUser userStef = masterGeorge.createNewUser("Stefan", true);
        userMimi.logIn();
        userMimi.logOut();
        System.out.println(userMimi.getUsername() + "'s registration date is: "+ userMimi.getRegistrationDate());

        masterGeorge.createNewUser("Ivan", false);
        masterGeorge.createNewUser("Galya", false);
        masterGeorge.createNewUser("Petya", false);

          masterGeorge.viewAllUsers();

        masterGeorge.deleteUser("Pesho");
        masterGeorge.deleteUser("Ivan");

        ((AdminUserImpl) userStef).createNewUser("Nencho", false);
        ((AdminUserImpl) userStef).viewAllUsers();


    }
}
