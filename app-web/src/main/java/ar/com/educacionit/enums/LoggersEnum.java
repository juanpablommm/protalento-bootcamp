package ar.com.educacionit.enums;

public enum LoggersEnum {

	FS("FS", 1) /* 0 */, CONSOLE("CONSOLE", 2);// 1

	private String descripcion;
	private Integer valor;

	private LoggersEnum(String descripcion, Integer valor) {
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getValor() {
		return valor;
	}

	public static LoggersEnum getEnumFromStr(String strEnum) {
		LoggersEnum aux = null;
		if (strEnum != null) {
			LoggersEnum enums[] = LoggersEnum.values();

			for (LoggersEnum _enum : enums) {
				if (strEnum.equalsIgnoreCase(_enum.getDescripcion())) {
					aux = _enum;
					break;
				}
			}
		}
		return aux;
	}
}
