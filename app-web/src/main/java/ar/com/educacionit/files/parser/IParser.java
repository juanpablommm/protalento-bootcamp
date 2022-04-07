package ar.com.educacionit.files.parser;

public interface IParser<T> {
	public T parse() throws ParseException;
	//public Collection<T> parseFile();
}
