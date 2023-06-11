/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 *
 * @author Vitor.hvieira1
 */
public class CEP {

    public final String cep;
    public final String logradouro;
    public final String complmento;
    public final String bairro;
    public final String localidade;
    public final String uf;
    public final String ibge;
    public final String gia;
    public final String ddd;
    public final String siafi;

    public CEP(@JsonProperty("cep") String cep, @JsonProperty("logradouro") String logradouro, @JsonProperty("complemento") String complemento, @JsonProperty("bairro") String bairro, @JsonProperty("localidade") String localidade, @JsonProperty("uf") String uf, @JsonProperty("ibge") String ibge, @JsonProperty("gia") String gia, @JsonProperty("ddd") String ddd, @JsonProperty("siafi") String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complmento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}
