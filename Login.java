import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Login class for user registration and authentication
 * Implements validation for username, password, and South African cell phone numbers
 */
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private boolean isRegistered;
    
    // Store registered user credentials
    private static String storedUsername;
    private static String storedPassword;
    private static String storedCellPhone;
    private static String storedFirstName;
    private static String storedLastName;
    
    public Login() {
        this.isRegistered = false;
    }
    
    /**
     * Method: checkUserName
     * Ensures that any username contains an underscore (_) and is no more than 5 characters long
     * @param username The username to validate
     * @return true if valid, false otherwise
     */
    public boolean checkUserName(String username) {
        if (username == null || username.length() > 5 || username.length() == 0) {
            return false;
        }
        return username.contains("_");
    }
    
    /**
     * Method: checkPasswordComplexity
     * Ensures passwords meet complexity requirements:
     * - At least eight characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     * @param password The password to validate
     * @return true if valid, false otherwise
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        
        return hasCapital && hasNumber && hasSpecial;
    }
    
    /**
     * Method: checkCellPhoneNumber
     * Ensures the cell phone is correct length and contains international country code
     * Uses regex to validate South African cell phone format: +27 followed by 9 digits
     * Total should be no more than 10 characters after country code
     * 
     * Regex Reference: South African mobile format ^\\+27\\d{9}$
     * Pattern explanation:
     * ^ - Start of string
     * \\+27 - Literal "+27" (South African country code)
     * \\d{9} - Exactly 9 digits
     * $ - End of string
     * 
     * @param cellPhone The cell phone number to validate
     * @return true if valid, false otherwise
     */
    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone == null || cellPhone.length() == 0) {
            return false;
        }
        
        // Regex pattern for South African cell phone with international code
        // +27 followed by exactly 9 digits (total 12 characters)
        String regex = "^\\+27\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellPhone);
        
        return matcher.matches();
    }
    
    /**
     * Method: registerUser
     * Returns registration messaging indicating:
     * - If username is incorrectly formatted
     * - If password does not meet complexity requirements
     * - If both conditions are met and user is registered successfully
     * 
     * @param username The username to register
     * @param password The password to register
     * @param cellPhone The cell phone number to register
     * @return Registration status message
     */
    public String registerUser(String username, String password, String cellPhone) {
        // Validate username first
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        // Validate password
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // Validate cell phone
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        // All validations passed - store user data
        storedUsername = username;
        storedPassword = password;
        storedCellPhone = cellPhone;
        
        // Extract first and last name from username (format: first_last)
        String[] nameParts = username.split("_");
        storedFirstName = nameParts.length > 0 ? nameParts[0] : username;
        storedLastName = nameParts.length > 1 ? nameParts[1] : "";
        
        this.isRegistered = true;
        
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }
    
    /**
     * Method: loginUser
     * Verifies that login details entered match the login details stored when user registers
     * @param username The username to verify
     * @param password The password to verify
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser(String username, String password) {
        if (!this.isRegistered) {
            return false;
        }
        
        return storedUsername.equals(username) && storedPassword.equals(password);
    }
    
    /**
     * Method: returnLoginStatus
     * Returns messaging for:
     * - A successful login: "Welcome <user first name> <user last name> it is great to see you again."
     * - A failed login: "Username or password incorrect, please try again."
     * 
     * @param username The username attempting to login
     * @param password The password attempting to login
     * @return Login status message
     */
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + storedFirstName + " " + storedLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // Getter methods for testing
    public boolean isRegistered() {
        return this.isRegistered;
    }
    
    public String getStoredUsername() {
        return storedUsername;
    }
}