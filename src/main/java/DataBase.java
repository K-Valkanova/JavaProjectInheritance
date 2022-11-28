public class DataBase {
   private IUser[] dataBase;

    public DataBase(int maxUsers){
        this.dataBase = new IUser[maxUsers];
    }

    public IUser[] getDataBase() {
        return dataBase;
    }
}
