/**
 *
 * @author Peggy
*/


public class LoginController {

    private LoginModel loginModel;
    private LoginView loginView;

    /**
     * Constructs LoginController object
     * @param loginModel a LoginModel object
     * @param loginView a LoginView object
     */
    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        SwingUtilities.invokeLater(() -> {
            this.loginView = loginView;
            listenLogin();
        });
    }

    /**
     * Listens to login action
     */
    private void listenLogin() {
        loginView.getLoginButton().addActionListener(e -> {
            String username = loginView.getUserField().getText();
            String password = String.valueOf(loginView.getPasswordField().getPassword());
            if (loginModel.performLogin(username, password)) {
                loginView.getErrorLabel().setText("Success! Launching Dashboard...");
                loginSuccess(loginModel.getUser());
            } else {
                loginView.getErrorLabel().setText("Error: Wrong credentials!");
            }
        });
    }

  
