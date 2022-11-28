public class AdminUserImpl extends AbstractUser implements IAdminUser {

    public AdminUserImpl(String username) {
        super(username, true);
    }

    private DataBase adminDataBase = new DataBase(10);

    @Override
    public void deleteUser(String username) {
        IUser[] allUsers = adminDataBase.getDataBase();
        boolean isDeleted = false;
        boolean isEmpty = false;

        for (int i = 0; i < allUsers.length; i++) {
            if (allUsers[i] != null) {
                if (allUsers[i].getUsername().equalsIgnoreCase(username)) {
                    allUsers[i] = null;
                    isDeleted = true;
                    System.out.println("User " + username + " was deleted.");
                    return;
                }else {
                    isEmpty = false;
                }
            }
        }
            if (!isEmpty) {
                System.out.println("User with username " + username + " doesn't exist in the database.");
            } else {
                System.out.println("The database is empty, no user to delete.");
            }
        }


    @Override
    public IUser createNewUser(String username, boolean isAdmin) {
        IUser[] allUsers = adminDataBase.getDataBase();

        if (isAdmin) {
            IAdminUser adminUser = null;

            if (checkIfUserExists(username)) {
                System.out.println("The username " + username + " is already taken.");
                return null;
            }

            for (int i = 0; i < allUsers.length; i++) {
                if (allUsers[i] == null) {
                    adminUser = new AdminUserImpl(username);
                    allUsers[i] = adminUser;
                    return adminUser;
                }
            }
            System.out.println("Database is full. No more free places");
            return null;
        } else {
            IUser justUser = null;

            if (checkIfUserExists(username)) {
                System.out.println("The username " + username + " is already taken.");
                return null;
            }

            for (int i = 0; i < allUsers.length; i++) {
                if (allUsers[i] == null) {
                    justUser = new UserImpl(username);
                    allUsers[i] = justUser;
                    return justUser;
                }
            }
            System.out.println("Database is full. No more free places to add users");
            return null;
        }
    }
            @Override
            public void viewAllUsers () {
            IUser[] allUsers = adminDataBase.getDataBase();
                for (int i = 0; i < allUsers.length; i++) {
                    if (allUsers[i] != null) {
                        System.out.println(allUsers[i].getUsername().toString());
                    }
                }
            }

            private boolean checkIfUserExists(String userName){
                IUser[] allUsers = adminDataBase.getDataBase();

                for (int i = 0; i < allUsers.length; i++) {
                    if (allUsers[i] != null) {
                        if (allUsers[i].getUsername().equalsIgnoreCase(userName)) {
                            return true;
                        }
                    }
                }
                return false;
            }

    }