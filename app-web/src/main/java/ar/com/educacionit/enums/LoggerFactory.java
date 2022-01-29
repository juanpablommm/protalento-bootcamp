package ar.com.educacionit.enums;

public final class LoggerFactory {

	public static ILoger getLoggerFromEnum(LoggersEnum loggersEnum) throws RuntimeException{
		if(loggersEnum == null) {
			throw new RuntimeException("Debe indicar un LoggerEnum valido");
		}
		
		if(loggersEnum == LoggersEnum.FS) {
			return new FSLogger();
			
		}else {
			return new ConsoleLogger();
		}
	}
}
