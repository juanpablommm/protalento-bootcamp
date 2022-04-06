package ar.com.educacionit.web.enums;

public enum LoginViewEnum {

    USERNAME("username"),
    PASSWORD("password"),
    ERROR_GENERAL("errror");
    private final String name;

    private LoginViewEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
