package com.educacionit.files;

import com.educacionit.exeptions.ParseException;

public interface IParser<T> {
	public T parse() throws ParseException;
	//public Collection<T> parseFile();
}
