package nums;

import domain.idiomas.Aleman;
import domain.idiomas.Español;
import domain.idiomas.Idioma;
import domain.idiomas.Frances;
import domain.idiomas.Ingles;
import domain.idiomas.Italiano;
import domain.idiomas.Latin;
import domain.idiomas.Noruego;
import domain.idiomas.Polaco;
import domain.idiomas.Portugues;

public enum IdiomasEnum {
	ES(Español.class), AL(Aleman.class), FR(Frances.class), IN(Ingles.class), IT(Italiano.class), NG(Noruego.class), PL(Polaco.class), PT(Portugues.class), LT(Latin.class);
	private Class<? extends Idioma> idioma;
	private IdiomasEnum(Class<? extends Idioma> idioma) {
		this.idioma = idioma;
	}	
	public Class<? extends Idioma> getIdioma() {
		return this.idioma;
	}
}
