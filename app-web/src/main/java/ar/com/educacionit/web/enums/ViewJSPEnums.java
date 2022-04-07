package ar.com.educacionit.web.enums;

public enum ViewJSPEnums {

    LOGIN("/login.jsp"),
    LOGIN_SUCCESS("/loginSuccess.jsp"),
    HOME("/index.jsp");
    
    private final String view;

    private ViewJSPEnums(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
