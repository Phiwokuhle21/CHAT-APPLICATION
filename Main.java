/**
 * Main class to demonstrate the Login system functionality
 * This shows how the Login class is used in a real application
 */
public class Main {
    
    public static void main(String[] args) {
        Login login = new Login();
        
        System.out.println("=== LOGIN SYSTEM DEMO ===\n");
        
        // Test 1: Valid Registration
        System.out.println("Test 1: Valid Registration");
        System.out.println("----------------------------");
        String result1 = login.registerUser("kyl_4", "Ch&sse@ke99!", "+27838968976");
        System.out.println(result1);
        System.out.println();
        
        // Test 2: Valid Login
        System.out.println("Test 2: Valid Login");
        System.out.println("----------------------------");
        String loginStatus = login.returnLoginStatus("kyl_4", "Ch&sse@ke99!");
        System.out.println(loginStatus);
        System.out.println();
        
        // Test 3: Invalid Username
        System.out.println("Test 3: Invalid Username (no underscore)");
        System.out.println("----------------------------");
        Login login2 = new Login();
        String result2 = login2.registerUser("kyle", "Ch&sse@ke99!", "+27838968976");
        System.out.println(result2);
        System.out.println();
        
        // Test 4: Invalid Password
        System.out.println("Test 4: Invalid Password (too simple)");
        System.out.println("----------------------------");
        Login login3 = new Login();
        String result3 = login3.registerUser("kyl_4", "password", "+27838968976");
        System.out.println(result3);
        System.out.println();
        
        // Test 5: Invalid Cell Phone
        System.out.println("Test 5: Invalid Cell Phone (no international code)");
        System.out.println("----------------------------");
        Login login4 = new Login();
        String result4 = login4.registerUser("kyl_4", "Ch&sse@ke99!", "0838968976");
        System.out.println(result4);
        System.out.println();
        
        // Test 6: Failed Login
        System.out.println("Test 6: Failed Login (wrong password)");
        System.out.println("----------------------------");
        String failedLogin = login.returnLoginStatus("kyl_4", "wrongpassword");
        System.out.println(failedLogin);
        System.out.println();
        
        System.out.println("=== DEMO COMPLETE ===");
    }
}