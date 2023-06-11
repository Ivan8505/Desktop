package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Vitor :)
 */

public class SolicitacaoCEP {
    
    CEP apod;
    
    public CEP solicitarCEP(String cep){
      solicitar("https://viacep.com.br/ws/"+cep+"/json/");
      return apod;
    }
    
    
    public void solicitar(String url){
        try {
            URL url2 = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url2.openConnection();
            con.setRequestProperty("accept", "application/json");
            InputStream resposta = con.getInputStream();
            
            ObjectMapper mapper = new ObjectMapper();
            apod = mapper.readValue(resposta, CEP.class);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
