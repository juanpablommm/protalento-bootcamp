package ar.com.educacionit.web.enums;

public enum ViewsKeysEnum implements IEnumerable{

    USERNAME("username"),
    PASSWORD("password"),
    ERROR_GENERAL("errror"),
    USUARIO_PASSWORD_INVALID("usuario/password incorrectos"),
    USER("user"),
    EXITO("exito"),
    UPLOAD_FILE("uploadFile"), 
    UPLOAD_PREVIEW_KEY("upload_preview_key"), 
    ARTICULOS_OK("articulos_ok"),
    ARTICULOS_FAILS("articulos_fails"), 
    FORMATO("typeFile"), 
    LISTADO("listado"), 
    KEYWORD("keyword"),
    VALOR_TOTAL("valor total"),
    ID_ELIMINAR("id"), 
    MARCAS("marcas"),
    CATEGORIAS("categorias");
    
    private final String name;

    private ViewsKeysEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getParam() {
        return this.getName();
    }
}
