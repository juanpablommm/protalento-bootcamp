package files;

public interface IParser<T> {
	public T parse() throws ParseException;
	//public Collection<T> parseFile();
}
