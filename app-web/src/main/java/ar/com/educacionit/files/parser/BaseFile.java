package ar.com.educacionit.files.parser;

import javax.servlet.http.Part;

public abstract class BaseFile {

	protected String filePath;//alt+shit+r
	protected Part filepart;
	
	
	
	public BaseFile(Part filepart) {
	    if(filepart == null) {
            throw new IllegalArgumentException("Debe ingresar un part valido");
        }
        this.filepart = filepart;
    }

    public BaseFile(String path) {
		if(path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filePath = path;
	}

	public String getFilePath() {
		
		//hay lógica
		if(filePath == null) {
			//uso path por defecto...
		}
		
		return filePath;
	}

}
