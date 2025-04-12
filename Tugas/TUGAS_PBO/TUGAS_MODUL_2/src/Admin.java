class Admin {
    String username = "Admin404";
    String password = "Password404";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}
