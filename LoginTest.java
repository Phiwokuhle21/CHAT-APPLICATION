
/**
 * Comprehensive Unit Tests for the Login class
 * Tests all validation methods and registration/login functionality
 * 
 * Test Framework: JUnit 5
 * IDE: NetBeans
 */
public class LoginTest {
    
    private Login login;
    
    
    public void setUp() {
        login = new Login();
    }
    
    // ==================== checkUserName() Tests ====================
    
    /**
     * Test: Username is correctly formatted
     * Test Data: "kyl_4"
     * Expected: The username contains an underscore and is no more than five characters long
     * The system returns: "Welcome <user first name> <user last name> it is great to see you again."
     */
    
    public void testCheckUserName_CorrectlyFormatted_kyl_4() {
        String username = "kyl_4";
        boolean result = login.checkUserName(username);
        assertTrue(result, "Username 'kyl_4' should be valid - contains underscore and is 5 characters");
    }
    
    /**
     * Test: Username correctly formatted - another valid example
     * Test Data: "a_b"
     * Expected: True
     */
    
    public void testCheckUserName_CorrectlyFormatted_a_b() {
        String username = "a_b";
        boolean result = login.checkUserName(username);
        assertTrue(result, "Username 'a_b' should be valid");
    }
    
    /**
     * Test: Username incorrectly formatted - no underscore
     * Test Data: "kyle!!!!!!!"
     * Expected: False
     * The system returns: False
     */
    
    public void testCheckUserName_IncorrectlyFormatted_NoUnderscore() {
        String username = "kyle!!!!!!!";
        boolean result = login.checkUserName(username);
        assertFalse(result, "Username 'kyle!!!!!!!' should be invalid - no underscore");
    }
    
    /**
     * Test: Username incorrectly formatted - too long
     * Test Data: "john_d" (6 characters)
     * Expected: False
     */
    
    public void testCheckUserName_IncorrectlyFormatted_TooLong() {
        String username = "john_d";
        boolean result = login.checkUserName(username);
        assertFalse(result, "Username 'john_d' should be invalid - more than 5 characters");
    }
    
    /**
     * Test: Username incorrectly formatted - too long
     * Test Data: "abcdef"
     * Expected: False
     */
    
    public void testCheckUserName_IncorrectlyFormatted_TooLong_NoUnderscore() {
        String username = "abcdef";
        boolean result = login.checkUserName(username);
        assertFalse(result, "Username 'abcdef' should be invalid - too long and no underscore");
    }
    
    /**
     * Test: Username incorrectly formatted - empty string
     * Expected: False
     */
    
    public void testCheckUserName_IncorrectlyFormatted_Empty() {
        String username = "";
        boolean result = login.checkUserName(username);
        assertFalse(result, "Empty username should be invalid");
    }
    
    /**
     * Test: Username incorrectly formatted - null
     * Expected: False
     */
    
    public void testCheckUserName_IncorrectlyFormatted_Null() {
        String username = null;
        boolean result = login.checkUserName(username);
        assertFalse(result, "Null username should be invalid");
    }

    private void assertTrue(boolean contains, String registration_should_succeed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String username_or_password_incorrect_please_try, String status, String should_fail_when_user_not_registered) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertFalse(boolean loginUser, String first_attempt_should_fail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // ==================== checkPasswordComplexity() Tests ====================
    
    /**
     * Test: Password meets complexity requirements
     * Test Data: "Ch&sse@ke99!"
     * Expected: The password meets the complexity requirements
     * The system returns: True
     */
  
    
    public void testCheckPasswordComplexity_MeetsRequirements_Password1() {
        String password = "Password1!";
        boolean result = login.checkPasswordComplexity(password);
        assertTrue(result, "Password 'Password1!' should meet complexity requirements");
    }
    
    /**
     * Test: Password does not meet complexity requirements
     * Test Data: "password"
     * Expected: The password does not meet the complexity requirements
     * The system returns: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_AllLowercase() {
        String password = "password";
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Password 'password' should not meet complexity - no capital, number, or special char");
    }
    
    /**
     * Test: Password does not meet complexity - too short
     * Test Data: "Pass1!"
     * Expected: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_TooShort() {
        String password = "Pass1!";
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Password 'Pass1!' should be invalid - less than 8 characters");
    }
    
    /**
     * Test: Password does not meet complexity - missing capital letter
     * Test Data: "password1!"
     * Expected: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_NoCapital() {
        String password = "password1!";
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Password 'password1!' should be invalid - missing capital letter");
    }
    
    /**
     * Test: Password does not meet complexity - missing number
     * Test Data: "Password!"
     * Expected: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_NoNumber() {
        String password = "Password!";
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Password 'Password!' should be invalid - missing number");
    }
    
    /**
     * Test: Password does not meet complexity - missing special character
     * Test Data: "Password1"
     * Expected: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_NoSpecialChar() {
        String password = "Password1";
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Password 'Password1' should be invalid - missing special character");
    }
    
    /**
     * Test: Password does not meet complexity - null
     * Expected: False
     */
    
    public void testCheckPasswordComplexity_DoesNotMeetRequirements_Null() {
        String password = null;
        boolean result = login.checkPasswordComplexity(password);
        assertFalse(result, "Null password should be invalid");
    }
    
    // ==================== checkCellPhoneNumber() Tests ====================
    
    /**
     * Test: Cell phone number correctly formatted
     * Test Data: "+27838968976"
     * Expected: The cell phone is correctly formatted
     * The system returns: True
     */
    
    public void testCheckCellPhoneNumber_CorrectlyFormatted_ValidSA() {
        String cellPhone = "+27838968976";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertTrue(result, "Cell phone '+27838968976' should be correctly formatted");
    }
    
    /**
     * Test: Cell phone number correctly formatted - another valid number
     * Test Data: "+27123456789"
     * Expected: True
     */
    
    public void testCheckCellPhoneNumber_CorrectlyFormatted_AnotherValid() {
        String cellPhone = "+27123456789";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertTrue(result, "Cell phone '+27123456789' should be correctly formatted");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted
     * Test Data: "08966553"
     * Expected: The cell phone number is incorrectly formatted
     * The system returns: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_NoInternationalCode() {
        String cellPhone = "08966553";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Cell phone '08966553' should be invalid - missing international code");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted - too short
     * Test Data: "+2783896"
     * Expected: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_TooShort() {
        String cellPhone = "+2783896";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Cell phone '+2783896' should be invalid - too short");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted - too long
     * Test Data: "+278389689761234"
     * Expected: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_TooLong() {
        String cellPhone = "+278389689761234";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Cell phone '+278389689761234' should be invalid - too long");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted - wrong country code
     * Test Data: "+1838968976"
     * Expected: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_WrongCountryCode() {
        String cellPhone = "+1838968976";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Cell phone '+1838968976' should be invalid - wrong country code");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted - contains letters
     * Test Data: "+27abc456789"
     * Expected: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_ContainsLetters() {
        String cellPhone = "+27abc456789";
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Cell phone '+27abc456789' should be invalid - contains letters");
    }
    
    /**
     * Test: Cell phone number incorrectly formatted - null
     * Expected: False
     */
    
    public void testCheckCellPhoneNumber_IncorrectlyFormatted_Null() {
        String cellPhone = null;
        boolean result = login.checkCellPhoneNumber(cellPhone);
        assertFalse(result, "Null cell phone should be invalid");
    }
    
    // ==================== registerUser() Tests ====================
    
    /**
     * Test: Successful registration with all valid data
     * Test Data: username="kyl_4", password="Ch&sse@ke99!", cellPhone="+27838968976"
     * Expected: Success message with all three success messages
     */
    
    public void testRegisterUser_Successful_AllValid() {
        String username = "kyl_4";
        String password = "Ch&sse@ke99!";
        String cellPhone = "+27838968976";
        
        String result = login.registerUser(username, password, cellPhone);
        
        assertTrue(result.contains("Username successfully captured"), 
                   "Should contain username success message");
        assertTrue(result.contains("Password successfully captured"), 
                   "Should contain password success message");
        assertTrue(result.contains("Cell phone number successfully added"), 
                   "Should contain cell phone success message");
    }
    
    /**
     * Test: Registration fails - invalid username
     * Expected: Username error message
     */
    
    public void testRegisterUser_InvalidUsername() {
        String username = "kyle!!!!!!!";
        String password = "Ch&sse@ke99!";
        String cellPhone = "+27838968976";
        
        String result = login.registerUser(username, password, cellPhone);
        
        assertTrue(result.contains("Username is not correctly formatted"), 
                   "Should return username format error");
        assertTrue(result.contains("underscore"), 
                   "Error message should mention underscore requirement");
    }
    
    /**
     * Test: Registration fails - invalid password
     * Expected: Password error message
     */
    
    public void testRegisterUser_InvalidPassword() {
        String username = "kyl_4";
        String password = "password";
        String cellPhone = "+27838968976";
        
        String result = login.registerUser(username, password, cellPhone);
        
        assertTrue(result.contains("Password is not correctly formatted"), 
                   "Should return password format error");
        assertTrue(result.contains("eight characters"), 
                   "Error message should mention eight characters requirement");
    }
    
    /**
     * Test: Registration fails - invalid cell phone
     * Expected: Cell phone error message
     */
    
    public void testRegisterUser_InvalidCellPhone() {
        String username = "kyl_4";
        String password = "Ch&sse@ke99!";
        String cellPhone = "08966553";
        
        String result = login.registerUser(username, password, cellPhone);
        
        assertTrue(result.contains("Cell phone number incorrectly formatted"), 
                   "Should return cell phone format error");
        assertTrue(result.contains("international code"), 
                   "Error message should mention international code");
    }
    
    /**
     * Test: Registration validation order - username checked first
     */
    
    public void testRegisterUser_ValidationOrder_UsernameFirst() {
        // All three are invalid, but username should be checked first
        String username = "invalid";
        String password = "weak";
        String cellPhone = "123";
        
        String result = login.registerUser(username, password, cellPhone);
        
        assertTrue(result.contains("Username"), 
                   "Username validation should be checked first");
    }
    
    // ==================== loginUser() Tests ====================
    
    /**
     * Test: Login Successful
     * Expected: True
     */
    
    public void testLoginUser_Successful() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        // Then try to login with correct credentials
        boolean result = login.loginUser("kyl_4", "Ch&sse@ke99!");
        assertTrue(result, "Login should succeed with correct credentials");
    }
    
    /**
     * Test: Login Failed - wrong password
     * Expected: False
     */
    
    public void testLoginUser_Failed_WrongPassword() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        // Then try to login with wrong password
        boolean result = login.loginUser("kyl_4", "wrongpassword");
        assertFalse(result, "Login should fail with wrong password");
    }
    
    /**
     * Test: Login Failed - wrong username
     * Expected: False
     */
    
    public void testLoginUser_Failed_WrongUsername() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        // Then try to login with wrong username
        boolean result = login.loginUser("wrong_user", "Ch&sse@ke99!");
        assertFalse(result, "Login should fail with wrong username");
    }
    
    /**
     * Test: Login Failed - both wrong
     * Expected: False
     */
    
    public void testLoginUser_Failed_BothWrong() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        // Then try to login with wrong credentials
        boolean result = login.loginUser("wrong_user", "wrongpassword");
        assertFalse(result, "Login should fail with wrong username and password");
    }
    
    /**
     * Test: Login Failed - not registered
     * Expected: False
     */
    
    public void testLoginUser_Failed_NotRegistered() {
        Login newLogin = new Login();
        boolean result = newLogin.loginUser("kyl_4", "Ch&sse@ke99!");
        assertFalse(result, "Login should fail when user not registered");
    }
    
    // ==================== returnLoginStatus() Tests ====================
    
    /**
     * Test: returnLoginStatus - Successful login message
     * Test Data: username="kyl_4", password="Ch&sse@ke99!"
     * Expected: "Welcome kyl 4 it is great to see you again."
     */
    
    public void testReturnLoginStatus_Successful() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        String status = login.returnLoginStatus("kyl_4", "Ch&sse@ke99!");
        
        assertEquals("Welcome kyl 4 it is great to see you again.", status,
                    "Should return welcome message with user's name");
    }
    
    /**
     * Test: returnLoginStatus - Successful login with different user
     * Test Data: username="joh_d", password="Secure123!"
     * Expected: "Welcome joh d it is great to see you again."
     */
    
    public void testReturnLoginStatus_Successful_DifferentUser() {
        // First register a user
        login.registerUser("joh_d", "Secure123!", "+27838968976");
        
        String status = login.returnLoginStatus("joh_d", "Secure123!");
        
        assertEquals("Welcome joh d it is great to see you again.", status,
                    "Should return welcome message with user's name");
    }
    
    /**
     * Test: returnLoginStatus - Failed login message
     * Expected: "Username or password incorrect, please try again."
     */
   
    public void testReturnLoginStatus_Failed() {
        // First register a user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        String status = login.returnLoginStatus("wrong_user", "wrongpass");
        
        assertEquals("Username or password incorrect, please try again.", status,
                    "Should contain error message");
    }
    
    /**
     * Test: returnLoginStatus - Login before registration
     * Expected: "Username or password incorrect, please try again."
     */
    
    public void testReturnLoginStatus_NotRegistered() {
        Login newLogin = new Login();
        String status = newLogin.returnLoginStatus("kyl_4", "Ch&sse@ke99!");
        
        assertEquals("Username or password incorrect, please try again.", status,
                    "Should fail when user not registered");
    }
    
    // ==================== Integration Tests ====================
    
    /**
     * Integration Test: Complete registration and login flow
     */
    public void testCompleteRegistrationAndLoginFlow() {
        // Step 1: Register a new user
        String registerResult = login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        assertTrue(registerResult.contains("successfully"), "Registration should succeed");
        
        // Step 2: Login with correct credentials
        boolean loginResult = login.loginUser("kyl_4", "Ch&sse@ke99!");
        assertTrue(loginResult, "Login should succeed");
        
        // Step 3: Get login status
        String status = login.returnLoginStatus("kyl_4", "Ch&sse@ke99!");
        assertTrue(status.contains("Welcome"), "Should show welcome message");
        assertTrue(status.contains("kyl"), "Should contain first name");
        assertTrue(status.contains("4"), "Should contain last name");
    }
    
    /**
     * Integration Test: Registration validation - all fields invalid
     */
    
    public void testRegistrationAllFieldsInvalid() {
        String result = login.registerUser("invalid", "weak", "123");
        
        // Should fail on username first
        assertTrue(result.contains("Username"), "Should check username first");
    }
    
    /**
     * Integration Test: Multiple failed login attempts
     */
    
    public void testMultipleFailedLoginAttempts() {
        // Register user
        login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        
        // Try multiple failed attempts
        assertFalse(login.loginUser("kyl_4", "wrong1"), "First attempt should fail");
        assertFalse(login.loginUser("wrong", "Ch&sse@ke99!"), "Second attempt should fail");
        assertFalse(login.loginUser("wrong", "wrong"), "Third attempt should fail");
        
        // Correct credentials should still work
        assertTrue(login.loginUser("kyl_4", "Ch&sse@ke99!"), "Correct credentials should work");
    }
}