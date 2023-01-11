package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author berna-dev
 */
public class ClienteGestao {

    public static HttpClient client;

    public static void listByState() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Estado:");
        String estado = input.readLine();

        HttpGet request = new HttpGet("http://localhost:8080/gestao/anuncios/" + estado);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void aprouveAdByAid() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Aid:");

        String aid = input.readLine();

        HttpPost request = new HttpPost("http://localhost:8080/gestao/anuncios/aprovar/" + aid);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void alterStateByAid() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Aid:");

        String aid = input.readLine();

        HttpPost request = new HttpPost("http://localhost:8080/gestao/anuncios/alterar/" + aid);
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
            System.out.println("\n Selecinar a opção:\n"
                    + "  1-> Listar anuncios por estado\n"
                    + "  2-> Aprovar um anuncio, alterando o estado do mesmo para ativo\n"
                    + "  3-> Alterar o estado de um anuncio\n"
                    + "  4-> Sair\n"
                    + "Opcão:");

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int opcao = Integer.parseInt(input.readLine());

            switch (opcao) {
                case 1:
                    listByState();
                    break;
                case 2:
                    aprouveAdByAid();
                    break;
                case 3:
                    alterStateByAid();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Introduzir um número válido.");
            }

        }

    }
}
