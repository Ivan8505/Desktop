/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objs;

/**
 *
 * @author ivan.grodrigues
 */
public class Medicamentos {

    /**
     * @return the Quantidade
     */
    public String getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }

    /**
     * @return the nomeMed
     */
    public String getNomeMed() {
        return nomeMed;
    }

    /**
     * @param nomeMed the nomeMed to set
     */
    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    /**
     * @return the codMed
     */
    public String getCodMed() {
        return codMed;
    }

    /**
     * @param codMed the codMed to set
     */
    public void setCodMed(String codMed) {
        this.codMed = codMed;
    }

    /**
     * @return the descrição
     */
    public String getDescrição() {
        return descrição;
    }

    /**
     * @param descrição the descrição to set
     */
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    /**
     * @return the dataUltimaCompra
     */
    public String getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    /**
     * @param dataUltimaCompra the dataUltimaCompra to set
     */
    public void setDataUltCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    /**
     * @return the quantidade
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setTipo(String quantidade) {
        this.Tipo = quantidade;
    }

    /**
     * @return the valorVenda
     */
    public String getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the valorCusto
     */
    public String getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(String valorCusto) {
        this.valorCusto = valorCusto;
    }
    private String nomeMed;
    private String codMed;
    private String descrição;
    private String dataUltimaCompra;
    private String Tipo;
    private String Quantidade;
    private String valorVenda;
    private String valorCusto;
}
