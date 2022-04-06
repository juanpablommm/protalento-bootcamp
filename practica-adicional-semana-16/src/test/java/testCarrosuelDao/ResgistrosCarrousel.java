package testCarrosuelDao;

import com.educacionit.dao.ICarrouselDao;
import com.educacionit.dao.Impl.CarrouselDaoImplPostgret;
import com.educacionit.domain.Carrousel;
import com.educacionit.exception.GenericException;

public class ResgistrosCarrousel {

    public static void main(String[] args) throws GenericException {
        ICarrouselDao dao = new CarrouselDaoImplPostgret();
//        Carrousel carrousel = new Carrousel("biña del mar", "carrosel en biña del mar chile", "https://blog.facialix.com/seguridad-por-niveles-libro-gratis/amp/", 1l);
        Carrousel carrouse2 = new Carrousel("biña del mar", "carrosel en biña del mar braizl", "https://blog.facialix.com/seguridad-por-niveles-libro-gratis/amp/", 4l);
//        dao.deletet(2l);
        dao.insert(carrouse2);
        System.out.println(dao.selectFindAll());
    }
}
