package telefonia.db;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import telefonia.model.Chiamata;

@Repository
public interface ChiamataRepository extends CrudRepository<Chiamata, Integer> {
	
	Chiamata findByCodChiamata(Integer codChiamata);
	Chiamata deleteByCodChiamata(Integer codChiamata);
	
	@Query(value="SELECT SUM(durata)"
			+ "	FROM public.chiamata"
			+ "	WHERE (cod_linea_chiamante=:codLinea OR cod_linea_chiamato=:codLinea) AND (data_inizio>=:dateStart AND data_fine<=:dateEnd)", nativeQuery=true)
	Long sommaDurate(@Param("codLinea")Integer codLinea, @Param("dateStart")Date dateStart, @Param("dateEnd")Date dateEnd);
}
