package servidor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity      
class Ad implements Serializable{

    private @Id @GeneratedValue Long aid;

    private String tipoAnuncio;
    private String tipologia;
    private String detalhes;
    private String localizacao;
    private String genero;
    private String preco;
    private String anunciante;
    private String contacto;
    private String data;
    private String estado;
    
    @ElementCollection
    private List<String> mensagens;

    public Ad() {
    }

    public Ad(String tipo_anuncio) {
        this.tipoAnuncio = tipo_anuncio;
        mensagens= new ArrayList<>();
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getAid() {
        return aid;
    }

    public void setTipo_Anuncio(String tipo_anuncio) {
        this.tipoAnuncio = tipo_anuncio;
    }

    public String getTipo_Anuncio() {
        return tipoAnuncio;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPreco() {
        return preco;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    public List<String> getMessages(){
        return mensagens;
    }
    
    public void setMensagens(List<String> mensagens){
        this.mensagens=mensagens;
    }

    @Override
    public String toString() {
        return "Ad{"
                + "aid= " + aid.toString()
                + ", tipo de anuncio= " + tipoAnuncio
                + ", tipologia= " + tipologia
                + ", detalhes= " + detalhes
                + ", localização= " + localizacao
                + ", género= " + genero
                + ", preço= " + preco
                + ", anunciante= " + anunciante
                + ", contacto= " + contacto
                + ", data= " + data
                + ", estado= " + estado + '}';
    }
}
