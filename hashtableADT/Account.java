package hashtableADT;

public class Account {
    private String accountName;
    private String passWord;
     
    public Account(){

    }
    public Account(String accountName, String passWord){
        this.accountName = accountName;
        this.passWord = passWord;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "account name: "+ this.accountName + "/" +"password: "+ passWord;
    }
}