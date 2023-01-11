package servidor;

import java.util.List;
import net.minidev.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AdController {

    private final AdRepository repository;

    AdController(AdRepository repository) {
        this.repository = repository;
    }

    /*Registar novo anuncio do tipo oferta*/
    @PostMapping("/geral/anuncios/ofertas")
    public Ad registerOffer(@RequestBody JSONObject object) {

        Ad newOffer = new Ad("oferta");
        newOffer.setAnunciante(object.getAsString("anunciante"));
        newOffer.setContacto(object.getAsString("contacto"));
        newOffer.setData(object.getAsString("data"));
        newOffer.setDetalhes(object.getAsString("detalhes"));
        newOffer.setEstado("inativo");
        newOffer.setGenero(object.getAsString("genero"));
        newOffer.setLocalizacao(object.getAsString("localizacao"));
        newOffer.setPreco(object.getAsString("preco"));
        newOffer.setTipologia(object.getAsString("tipologia"));

        return repository.save(newOffer);
    }

    /*Registar novo anuncio do tipo pesquisa*/
    @PostMapping("/geral/anuncios/pesquisas")
    public Ad registerSearch(@RequestBody JSONObject object) {

        Ad newSearch = new Ad("procura");
        newSearch.setAnunciante(object.getAsString("anunciante"));
        newSearch.setContacto(object.getAsString("contacto"));
        newSearch.setData(object.getAsString("data"));
        newSearch.setDetalhes(object.getAsString("detalhes"));
        newSearch.setEstado("inativo");
        newSearch.setGenero(object.getAsString("genero"));
        newSearch.setLocalizacao(object.getAsString("localizacao"));
        newSearch.setPreco(object.getAsString("preco"));
        newSearch.setTipologia(object.getAsString("tipologia"));

        return repository.save(newSearch);
    }

    /*Listar anuncios (com estado ativo) do tipo oferta*/
    @GetMapping("/geral/anuncios/ofertas/lista")
    public List<Ad> listOfOffers() {
        return repository.findAllByEstadoAndTipoAnuncio("ativo", "oferta");

    }

    /*Listar anuncios (com estado ativo) do tipo procura*/
    @GetMapping("/geral/anuncios/pesquisas/lista")
    public List<Ad> listOfSearches() {

        return repository.findAllByEstadoAndTipoAnuncio("ativo", "procura");

    }

    /*Procurar anúncios, enviando texto a pesquisar na descrição, e opcionalmente uma localização*/
    @GetMapping("/geral/anuncios/{descricao}/{zona}")
    public List<Ad> listByDescription(@PathVariable String descricao, @PathVariable String zona) {
        return repository.findAllByDetalhesAndLocalizacaoAndEstado(descricao, zona, "ativo");

    }

    /*Obter todos os detalhes de um anúncio, dado o seu identificador (aid)*/
    @GetMapping("/geral/anuncios/{id}")
    public Ad getAdByAid(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new AdNotFoundException(id));
    }

    @PostMapping("/geral/anuncios/mensagens")
    public Ad sendMessageByAid(@RequestBody JSONObject object) {
        List<String> mensagens;
        mensagens = repository.findById(Long.valueOf(object.getAsString("id"))).get().getMessages();

        mensagens.add(object.getAsString("mensagem"));

        Ad anuncio = repository.findById(Long.valueOf(object.getAsString("id"))).get();
        anuncio.setMensagens(mensagens);
        return repository.save(anuncio);
    }

    @GetMapping("/geral/anuncios/mensagens/{aid}")
    public Ad listMessagesByAid(@PathVariable Long aid) {

        return repository.findAllMensagensByAid(aid);

    }
    
    @GetMapping("/gestao/anuncios/{estado}")
    public List<Ad> listAdsByState(@PathVariable String estado){
        return repository.findAllByEstado(estado);
    }
    
    @PostMapping("/gestao/anuncios/aprovar/{aid}")
    public Ad aprouveAdByAid(@PathVariable Long aid){
        Ad anuncio = repository.findById(aid).get();
        anuncio.setEstado("ativo");
        return repository.save(anuncio);
    }
    
    @PostMapping("/gestao/anuncios/alterar/{aid}")
    public Ad alterStateAdByAid(@PathVariable Long aid){
        Ad anuncio = repository.findById(aid).get();
        
        String estado= anuncio.getEstado();
        
        if(estado.equals("ativo")){
            anuncio.setEstado("inativo");
        }else{
            anuncio.setEstado("ativo");
        }
        
        return repository.save(anuncio);
    }
}
