package ModelTables;

import Objs.Funcionarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionariosTableModel extends AbstractTableModel{
    private List<Funcionarios> f = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome", "Login", "E-mail", "Função", "Data de nascimento", "Telefone Celular", "Telefone residencial", "Telefone adicional"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return f.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 -> {return f.get(linha).getId();}
            case 1 -> {return f.get(linha).getNome();}
            case 2 -> {return f.get(linha).getUser();}
            case 3 -> {return f.get(linha).getEmail();}
            case 4 -> {return f.get(linha).getTipoFunc();}
            case 5 -> {return f.get(linha).getDataNasc();}
            case 6 -> {return f.get(linha).getFoneCel();}
            case 7 -> {return f.get(linha).getFoneRes();}
            case 8 -> {return f.get(linha).getFoneAlt();}
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0 -> f.get(linha).setId((String) valor);
            case 1 -> f.get(linha).setNome((String) valor);
            case 2 -> f.get(linha).setUser(((String) valor));
            case 3 -> f.get(linha).setEmail(((String) valor));
            case 4 -> f.get(linha).setTipoFunc(((String) valor));
            case 5 -> f.get(linha).setDataNasc(((String) valor));
            case 6 -> f.get(linha).setFoneCel(((String) valor));
            case 7 -> f.get(linha).setFoneRes(((String) valor));
            case 8 -> f.get(linha).setFoneAlt(((String) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public  void addLinha(Funcionarios f) {
        this.f.add(f);
        this.fireTableDataChanged();
    }
    public void removeall() {
        this.f.clear();
        this.fireTableDataChanged();
    }
    public void addlist(ArrayList<Funcionarios> ls){
        this.f = ls;
        this.fireTableDataChanged();
    }
}
