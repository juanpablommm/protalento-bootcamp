package ar.com.educacionit.web.enums;

public enum ViewsKeysEnum {

    USERNAME("username"),
    PASSWORD("password"),
    ERROR_GENERAL("errror"),
    USUARIO_PASSWORD_INVALID("usuario/password incorrectos"),
    USER("user"),
    UPLOAD_FILE("uploadFile"), 
    UPLOAD_PREVIEW_KEY("upload_preview_key");
    
    private final String name;

    private ViewsKeysEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
