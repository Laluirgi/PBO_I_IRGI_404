package evoting.project_evoting.Pengguna;

public class Panitia {
    private String username;
    private String password;

    public Panitia(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
