package ar.com.educacionit.files.parser;

import java.io.IOException;

public interface IParser<T> {
	public T parse() throws ParseException;
	//public Collection<T> parseFile();
}
