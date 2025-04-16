class Admin extends User {
    String username;
    String password;

    Admin(String nama, String nim, String username, String password) {
        super(nama,nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equalsIgnoreCase(username) && inputPassword.equalsIgnoreCase(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}