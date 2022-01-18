package ar.com.educacionit.Exeptions;

public class Conexion {

	private boolean open;
	private boolean error;
	
	
	
	public void open() throws ConexionAlreadyOpenException{
		if(open) {
			throw new ConexionAlreadyOpenException();
		}else {
			open = true;
		}
	}
	
	public void close() throws ConectionIsNoOpenException{
		if(!open) {
			throw new ConectionIsNoOpenException();
		}else {
			open = false;
		}
	}
	
	
	public void commit() throws CommitException{
		if(!open) {
			throw new CommitException("Error: connection close");
		}
		
		if(error) {
			throw new CommitException("Error:");
		}
	
		System.out.println("commiting changes");
	}
	
	
	public void rolback() {
		
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	
}
