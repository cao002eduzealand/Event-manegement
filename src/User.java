class User {
    //attributter til brugere
    private String userName;
    private String email;

    //kontruktør
    public User(String name, String email) {
        this.userName = name;
        this.email = email;
    }

    //metoder
    public String getUsername() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


}

