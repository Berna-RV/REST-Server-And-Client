package servidor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface AdRepository extends JpaRepository<Ad, Long> {

    List<AdWithoutMessages> findAllByEstado(String estado);

    List<AdWithoutMessages> findAllByEstadoAndTipoAnuncio(String estado, String tipoAnuncio);

    List<AdWithoutMessages> findAllByDetalhesAndLocalizacaoAndEstado(String detalhes, String localizacao, String estado);

    AdWithoutMessages findByAid(Long aid);

}

interface AdWithoutMessages {

    Long getAid();

    String getTipoAnuncio();

    String getTipologia();

    String getDetalhes();

    String getLocalizacao();

    String getGenero();

    String getPreco();

    String getAnunciante();

    String getContacto();

    String getData();

    String getEstado();
}
