package ar.com.educacionit.web.enums;

public enum ViewJSPEnums implements IEnumerable{

    LOGIN("/login.jsp"),
    LOGIN_SUCCESS("/loginSuccess.jsp"),
    HOME("/index.jsp"), 
    UPLOAD_PREVIEW("/uploadPreview.jsp"), 
    UPLOAD("/upload.jsp"),
    RESULTADO_PREVIEW("/resultadoPreview.jsp"),
    LISTADO_GENERAL("/listadoGeneral.jsp"),
    RESULT_PREVIEW("/resultadoPreview.jsp");
    
    private final String view;

    private ViewJSPEnums(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    @Override
    public String getParam() {
        return this.getView();
    }
}
