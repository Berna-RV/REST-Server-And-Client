package servidor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface AdRepository extends JpaRepository<Ad, Long> {
    
    List<Ad> findAllByEstado(String estado);
    
    List<Ad> findAllByEstadoAndTipoAnuncio(String estado, String tipoAnuncio);
    
    List<Ad> findAllByDetalhesAndLocalizacaoAndEstado(String detalhes, String localizacao, String estado);
    
    @Query("SELECT u FROM Ad AS u JOIN FETCH u.mensagens WHERE u.aid=:aid")
    public Ad findAllMensagensByAid(@Param("aid") Long aid);
}
