class Login {
    // Private fields (Encapsulation)
    private String registeredUsername;
    private String registeredPassword;
    private String registeredPhone; 

    // 1. Constructor: Initializes the object with data
    public Login(String registeredUsername, String registeredPassword, String registeredPhone) {
        this.registeredUsername = registeredUsername;
        this.registeredPassword = registeredPassword;
        this.registeredPhone = registeredPhone;
    }
    
    // Default constructor (optional, if you create an empty object first)
    public Login() {}

    // 2. Getters: Allow other classes to read the private data
    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getRegisteredPhone() {
        return registeredPhone;
    }

    // 3. Setters: Allow other classes to update the private data
    public void setRegisteredUsername(String registeredUsername) {
        this.registeredUsername = registeredUsername;
    }

    public void setRegisteredPassword(String registeredPassword) {
        this.registeredPassword = registeredPassword;
    }

    public void setRegisteredPhone(String registeredPhone) {
        this.registeredPhone = registeredPhone;
    }

    // Logic Methods
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    //Check whether the password meets the requirements
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;
        boolean hasCapital = false, hasNumber = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    public String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "The username is incorrectly formatted.";
        } else if (!checkPasswordComplexity(password)) {
            return "The password does not meet the complexity requirements.";
        } else {
            // Using setters internally
            setRegisteredUsername(username);
            setRegisteredPassword(password);
            setRegisteredPhone(phone);
            return "The user has been registered successfully.";
        }
    }

    public boolean loginUser(String username, String password) {
        // Using getters internally
        return username.equals(getRegisteredUsername()) && password.equals(getRegisteredPassword());
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "A successful login! Welcome, " + getRegisteredUsername() + ".";
        } else {
            return "A failed login. Invalid username or password.";
        }
    }
}

