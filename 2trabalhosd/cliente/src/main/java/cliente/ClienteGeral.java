package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import net.minidev.json.JSONObject;

/**
 *
 * @authors Bernardo e Daniel
 */
public class ClienteGeral {

    public static HttpClient client;

    public static void newOffer() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduza as caracteristicas do anuncio:");

        System.out.print("Tipologia: ");
        String tipologia_O = input.readLine();

        System.out.print("Detalhes: ");
        String detalhes_O = input.readLine();

        System.err.print("Localizacao: ");
        String localizacao_O = input.readLine();

        System.out.print("Genero: ");
        String genero_O = input.readLine();

        System.err.print("Preço: ");
        String preco_O = input.readLine();

        System.out.print("Anunciante: ");
        String anunciante_O = input.readLine();

        System.out.print("Contacto: ");
        String contacto_O = input.readLine();

        System.out.print("Data: ");
        String data_O = input.readLine();

        HttpPost post = new HttpPost("http://localhost:8080/geral/anuncios/ofertas");

        JSONObject json = new JSONObject();

        json.put("tipologia", tipologia_O);
        json.put("detalhes", detalhes_O);
        json.put("localizacao", localizacao_O);
        json.put("genero", genero_O);
        json.put("preco", preco_O);
        json.put("anunciante", anunciante_O);
        json.put("contacto", contacto_O);
        json.put("data", data_O);

        StringEntity se = new StringEntity(json.toJSONString());

        se.setContentType("application/json");
        post.setEntity(se);
        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public static void newSearch() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduza as caracteristicas do anuncio:");

        System.out.print("Tipologia: ");
        String tipologia_O = input.readLine();

        System.out.print("Detalhes: ");
        String detalhes_O = input.readLine();

        System.err.print("Localizacao: ");
        String localizacao_O = input.readLine();

        System.out.print("Genero: ");
        String genero_O = input.readLine();

        System.err.print("Preço: ");
        String preco_O = input.readLine();

        System.out.print("Anunciante: ");
        String anunciante_O = input.readLine();

        System.out.print("Contacto: ");
        String contacto_O = input.readLine();

        System.out.print("Data: ");
        String data_O = input.readLine();

        HttpPost post = new HttpPost("http://localhost:8080/geral/anuncios/pesquisas");

        JSONObject json = new JSONObject();

        json.put("tipologia", tipologia_O);
        json.put("detalhes", detalhes_O);
        json.put("localizacao", localizacao_O);
        json.put("genero", genero_O);
        json.put("preco", preco_O);
        json.put("anunciante", anunciante_O);
        json.put("contacto", contacto_O);
        json.put("data", data_O);

        StringEntity se = new StringEntity(json.toJSONString());

        se.setContentType("application/json");
        post.setEntity(se);
        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public static void listOffers() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8080/geral/anuncios/ofertas/lista");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void listSearches() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8080/geral/anuncios/procuras/lista");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void listByDetails() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Descrição: ");
        String descricao = input.readLine();
        System.out.println("Zona:");
        String zona = input.readLine();

        HttpGet request = new HttpGet("http://localhost:8080/geral/anuncios/" + descricao + "/" + zona);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void getById() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Aid: ");
        String aid = input.readLine();

        HttpGet request = new HttpGet("http://localhost:8080/geral/anuncios/" + aid);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public static void sendMessageById() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Aid: ");
        String aid = input.readLine();

        System.out.println("Mensagem: ");
        String mensagem = input.readLine();

        HttpPost post = new HttpPost("http://localhost:8080/geral/anuncios/mensagens");

        JSONObject json = new JSONObject();

        json.put("id", aid);
        json.put("mensagem", mensagem);

        StringEntity se = new StringEntity(json.toJSONString());

        se.setContentType("application/json");
        post.setEntity(se);
        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public static void readMensagens() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Aid: ");
        String aid = input.readLine();

        HttpGet request = new HttpGet("http://localhost:8080/geral/anuncios/mensagens/" + aid);

        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }

    }

    public static void main(String[] args) throws IOException {

        client = new DefaultHttpClient();

        while (true) {
            System.out.println("\nSelecinar a opção:\n"
                    + "  1-> Registar novo anuncio do tipo oferta\n"
                    + "  2-> Registar novo anuncio do tipo procura\n"
                    + "  3-> Listar anuncios (com estado ativo) do tipo oferta\n"
                    + "  4-> Listar anuncios (com estado ativo) do tipo procura\n"
                    + "  5-> Listar todos os anuncios enviando texto a pesquisar na descrição, e opcionalmente localizacao\n"
                    + "  6-> Obter todos os detalhes de um anuncio, dado o seu aid\n"
                    + "  7-> Enviar nova mensagem ao anunciante de um anuncio, pelo aid\n"
                    + "  8-> Consultar as mensagens inseridas para um determinado anúncio\n"
                    + "  9-> Sair\n"
                    + "Opção:");

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int opcao = Integer.parseInt(input.readLine());

            switch (opcao) {
                case 1:
                    newOffer();
                    break;
                case 2:
                    newSearch();
                    break;
                case 3:
                    listOffers();
                    break;
                case 4:
                    listSearches();
                    break;
                case 5:
                    listByDetails();
                    break;
                case 6:
                    getById();
                    break;
                case 7:
                    sendMessageById();
                    break;
                case 8:
                    readMensagens();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Introduza um valor possivel (1-8).");
                    break;
            }
        }
    }
}
