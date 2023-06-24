package Interfaces;

import API.CEP;
import API.LimitaCaracteres;
import API.SolicitacaoCEP;
import BD.ComprasDao;
import BD.DrogariasDao;
import BD.FuncionariosDao;
import BD.LaboratoriosDao;
import BD.MedicamentosDao;
import ModelTables.DrogariasTableModel;
import ModelTables.FuncionariosTableModel;
import ModelTables.LaboratoriosTableModel;
import ModelTables.MedicamentosTableModel;
import Objs.Compras;
import Objs.Drogarias;
import Objs.Funcionarios;
import Objs.Laboratorios;
import Objs.Medicamentos;
import com.melloware.jintellitype.JIntellitype;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();

        this.cl = (CardLayout) mainPainel.getLayout();

        //<editor-fold defaultstate="collapsed" desc="Atalhos">
        JIntellitype.getInstance().addHotKeyListener(hotkeyId -> {
            if (menuBar.isVisible()) {
                if (hotkeyId == 1 && barUser.isVisible()) {
                    tela("Cadastrar Funcionários");
                    jtextNomeCadUser.requestFocus();
                } else if (hotkeyId == 2) {
                    tela("Login");
                } else if (hotkeyId == 3 && barUser.isVisible()) {
                    tela("Deletar Funcionários");
                    tablePesquisa();
                } else if (hotkeyId == 4) {
                    tela("Cadastrar Drogarias");
                } else if (hotkeyId == 5) {
                    tela("Alterar Drogarias");
                } else if (hotkeyId == 6) {
                    tela("Cadastrar Laboratórios");
                } else if (hotkeyId == 7) {
                    tela("Alterar Laboratórios");
                } else if (hotkeyId == 8) {
                    tela("Cadastrar Medicamentos");
                } else if (hotkeyId == 9) {
                    tela("Alterar Medicamentos");
                } else if (hotkeyId == 10) {
                    tela("Deletar Medicamento");
                } else if (hotkeyId == 11) {
                    tela("Compras");
                } else if (hotkeyId == 12) {
                    tela("Vendas");
                }

            }
        });

        JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_CONTROL, (int) 'U');
        JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT + JIntellitype.MOD_ALT, (int) 'L');
        JIntellitype.getInstance().registerHotKey(3, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT, (int) 'U');
        JIntellitype.getInstance().registerHotKey(4, JIntellitype.MOD_CONTROL, (int) 'D');
        JIntellitype.getInstance().registerHotKey(5, JIntellitype.MOD_ALT, (int) 'D');
        JIntellitype.getInstance().registerHotKey(6, JIntellitype.MOD_CONTROL, (int) 'L');
        JIntellitype.getInstance().registerHotKey(7, JIntellitype.MOD_ALT, (int) 'L');
        JIntellitype.getInstance().registerHotKey(8, JIntellitype.MOD_CONTROL, (int) 'M');
        JIntellitype.getInstance().registerHotKey(9, JIntellitype.MOD_ALT, (int) 'M');
        JIntellitype.getInstance().registerHotKey(10, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT, (int) 'M');
        JIntellitype.getInstance().registerHotKey(11, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT, (int) 'C');
        JIntellitype.getInstance().registerHotKey(12, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT, (int) 'V');
//</editor-fold>

        tables();
        menuBar.setVisible(false);
        barUser.setVisible(false);
        tela("Login");
    }

    //<editor-fold defaultstate="collapsed" desc="Variaveis">
    private final CardLayout cl;
    FuncionariosTableModel FTM = new FuncionariosTableModel();
    DrogariasTableModel DTM = new DrogariasTableModel();
    LaboratoriosTableModel LTM = new LaboratoriosTableModel();
    MedicamentosTableModel MTM = new MedicamentosTableModel();
    Funcionarios f = new Funcionarios();
    Drogarias d = new Drogarias();
    Laboratorios l = new Laboratorios();
    Medicamentos m = new Medicamentos();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupbtnDelFun = new javax.swing.ButtonGroup();
        groupbrnAltDrog = new javax.swing.ButtonGroup();
        mainPainel = new javax.swing.JPanel();
        telaLogin = new javax.swing.JPanel();
        labelSenhaLog = new javax.swing.JLabel();
        btnEntrarLogin = new javax.swing.JButton();
        jtextUserLog = new javax.swing.JTextField();
        jpassSenhaLogin = new javax.swing.JPasswordField();
        labelUserLog = new javax.swing.JLabel();
        telaVendas = new javax.swing.JPanel();
        telaCompras = new javax.swing.JPanel();
        cbxCnpjComp = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxMedCompra = new javax.swing.JComboBox<>();
        jtextQtnCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        labelValMedicamento = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        jtextPesquisaCbx = new javax.swing.JTextField();
        jtextPesquisaNomeCompra = new javax.swing.JTextField();
        jformDataCompra = new javax.swing.JFormattedTextField();
        jformDataEntregaCompra = new javax.swing.JFormattedTextField();
        telaCadMed = new javax.swing.JPanel();
        jtextValCusCadMed = new javax.swing.JTextField();
        labelValCusCadMed = new javax.swing.JLabel();
        jtextValVenCadMed = new javax.swing.JTextField();
        labelDescCadMed = new javax.swing.JLabel();
        labelValVenCadMed = new javax.swing.JLabel();
        labelTipoCadMed = new javax.swing.JLabel();
        jtextQtndCadMed = new javax.swing.JTextField();
        labelNomeCadMed = new javax.swing.JLabel();
        labelDataUltCompCadMed = new javax.swing.JLabel();
        labelQtndCadMed = new javax.swing.JLabel();
        jtextNomeCadMed = new javax.swing.JTextField();
        btnCadMed = new javax.swing.JButton();
        jtextTipoCadMed = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jareaDescCadMed = new javax.swing.JTextArea();
        telaAltMed = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMed = new javax.swing.JTable();
        labelNomeAltLab1 = new javax.swing.JLabel();
        labelIDAltLab1 = new javax.swing.JLabel();
        radioCresAltMed = new javax.swing.JRadioButton();
        jtextIDAltMed = new javax.swing.JTextField();
        radioDescAltMed = new javax.swing.JRadioButton();
        labelOrderByMed = new javax.swing.JLabel();
        jtextNomeAltMed = new javax.swing.JTextField();
        cbxOrderByMed = new javax.swing.JComboBox<>();
        labelPesquisaAltLab1 = new javax.swing.JLabel();
        btnAltMed = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jareaDescAltMed = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jtextTipoAltMed = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtextQtndAltMed = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtextValorVendaAltMed = new javax.swing.JTextField();
        telaCadLab = new javax.swing.JPanel();
        jtextBairroCadLab = new javax.swing.JTextField();
        labelCEPCadLab = new javax.swing.JLabel();
        labelBairroCadLab = new javax.swing.JLabel();
        labelCNPJCadLab = new javax.swing.JLabel();
        jtextNumCadLab = new javax.swing.JTextField();
        labelNumCadLab = new javax.swing.JLabel();
        labelEstadoCadDLab = new javax.swing.JLabel();
        btnCadDrog1 = new javax.swing.JButton();
        jtextCidadeCadLab = new javax.swing.JTextField();
        jformCEPCadLab = new javax.swing.JFormattedTextField();
        labelCidadeCadLab = new javax.swing.JLabel();
        jformCNPJCadLab = new javax.swing.JFormattedTextField();
        jtextRuaCadLab = new javax.swing.JTextField();
        labelRuaCadLab = new javax.swing.JLabel();
        jtextComplementoCadLab = new javax.swing.JTextField();
        labelNomeCadLab = new javax.swing.JLabel();
        labelCompCadLab = new javax.swing.JLabel();
        jtextNomeCadLab = new javax.swing.JTextField();
        labelInsEstCadLab = new javax.swing.JLabel();
        cbxEstadoCadLab = new javax.swing.JComboBox<>();
        jformInsEstCadLab = new javax.swing.JFormattedTextField();
        telaAltLab = new javax.swing.JPanel();
        btnAltAtivarLab = new javax.swing.JButton();
        cbxStatusAltLab = new javax.swing.JComboBox<>();
        labelNomeAltLab = new javax.swing.JLabel();
        labelStatusLab = new javax.swing.JLabel();
        jtextIDAltLab = new javax.swing.JTextField();
        labelCEPAltLab = new javax.swing.JLabel();
        jtextCNPJAltLab = new javax.swing.JTextField();
        jformCEPAltLab = new javax.swing.JFormattedTextField();
        jtextNomeAltLab = new javax.swing.JTextField();
        labelPesquisaAltLab = new javax.swing.JLabel();
        jtextRuaAltLab = new javax.swing.JTextField();
        labelRuaAltLab = new javax.swing.JLabel();
        jtextComplementoAltLab = new javax.swing.JTextField();
        labelCompAltLab = new javax.swing.JLabel();
        jtextBairroAltLab = new javax.swing.JTextField();
        labelBairroAltLab = new javax.swing.JLabel();
        jtextNumAltLab = new javax.swing.JTextField();
        labelNumAltLab = new javax.swing.JLabel();
        labelEstadoAltLab = new javax.swing.JLabel();
        jtextCidadeAltLab = new javax.swing.JTextField();
        labelCidadeAltLab = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAltLab = new javax.swing.JTable();
        btnAltLab = new javax.swing.JButton();
        labelIDAltLab = new javax.swing.JLabel();
        radioCresAltLab = new javax.swing.JRadioButton();
        labelCNPJAltLab = new javax.swing.JLabel();
        radioDescAltLab = new javax.swing.JRadioButton();
        cbxEstadoAltLab = new javax.swing.JComboBox<>();
        labelOrderByLab = new javax.swing.JLabel();
        cbxOrderByAltLab = new javax.swing.JComboBox<>();
        labelInsEstAltLab = new javax.swing.JLabel();
        jtextInsEstAltLab = new javax.swing.JTextField();
        telaCadDrog = new javax.swing.JPanel();
        labelNomeCadDrog = new javax.swing.JLabel();
        jtextNomeCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog1 = new javax.swing.JLabel();
        labelCNPJCadDrog = new javax.swing.JLabel();
        labelNomeCadDrog2 = new javax.swing.JLabel();
        jtextCidadeCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog3 = new javax.swing.JLabel();
        jtextRuaCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog4 = new javax.swing.JLabel();
        jtextComplementoCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog5 = new javax.swing.JLabel();
        jtextBairroCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog6 = new javax.swing.JLabel();
        jtextNumCadDrog = new javax.swing.JTextField();
        labelNomeCadDrog7 = new javax.swing.JLabel();
        btnCadDrog = new javax.swing.JButton();
        jformCEPCadDrog = new javax.swing.JFormattedTextField();
        jformCNPJCadDrog = new javax.swing.JFormattedTextField();
        cbxEstadoCadDrog = new javax.swing.JComboBox<>();
        telaAltDrog = new javax.swing.JPanel();
        labelIDAltDrog = new javax.swing.JLabel();
        labelCNPJAltDrog = new javax.swing.JLabel();
        labelNomeAltDrog = new javax.swing.JLabel();
        jtextIDAltDrog = new javax.swing.JTextField();
        jtextCNPJAltDrog = new javax.swing.JTextField();
        jtextNomeAltDrog = new javax.swing.JTextField();
        labelPesquisaAltDrog = new javax.swing.JLabel();
        jtextRuaAltDrog = new javax.swing.JTextField();
        labelRuaAltDrog = new javax.swing.JLabel();
        jtextComplementoAltDrog = new javax.swing.JTextField();
        labelCompAltDrog = new javax.swing.JLabel();
        jtextBairroAltDrog = new javax.swing.JTextField();
        labelBairroAltDrog = new javax.swing.JLabel();
        jtextNumAltDrog = new javax.swing.JTextField();
        labelNumAltDrog = new javax.swing.JLabel();
        labelEstadoAltDrog = new javax.swing.JLabel();
        jtextCidadeAltDrog = new javax.swing.JTextField();
        labelCidadeAltDrog = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAltDrog = new javax.swing.JTable();
        btnAlt = new javax.swing.JButton();
        btnAltAtivar = new javax.swing.JButton();
        cbxStatusAltDrog = new javax.swing.JComboBox<>();
        labelStatusAltDrog = new javax.swing.JLabel();
        labelCepAltDrog = new javax.swing.JLabel();
        jformCEPAltDrog = new javax.swing.JFormattedTextField();
        radioCresAltDrog = new javax.swing.JRadioButton();
        radioDescAltDrog = new javax.swing.JRadioButton();
        labelOrderBy = new javax.swing.JLabel();
        cbxOrderByAltDrog = new javax.swing.JComboBox<>();
        cbxEstadoAltDrog = new javax.swing.JComboBox<>();
        telaDelUser = new javax.swing.JPanel();
        labelLogDelUser = new javax.swing.JLabel();
        jtextUserDelUser = new javax.swing.JTextField();
        labelEmailDelUser = new javax.swing.JLabel();
        jtextEmailDelUser = new javax.swing.JTextField();
        labelTipolDelUser = new javax.swing.JLabel();
        cbxTipoUserDelUser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDelUser = new javax.swing.JTable();
        btnPesquisaDelUser = new javax.swing.JButton();
        btnDelDelUser = new javax.swing.JButton();
        cbxOrderByDelUser = new javax.swing.JComboBox<>();
        radioDescDelFun = new javax.swing.JRadioButton();
        radioCrescDelFun = new javax.swing.JRadioButton();
        telaCadUser = new javax.swing.JPanel();
        labelNomeCadUser = new javax.swing.JLabel();
        labelLoginCadUser = new javax.swing.JLabel();
        labelSenhaCadUser = new javax.swing.JLabel();
        labelEmailCadUser = new javax.swing.JLabel();
        labelTipoCadUser = new javax.swing.JLabel();
        labelDateCadUser = new javax.swing.JLabel();
        labelTelCelCadUser = new javax.swing.JLabel();
        labelTelResCadUser = new javax.swing.JLabel();
        labelTelAdCadUser = new javax.swing.JLabel();
        jtextSenhaCadUser = new javax.swing.JTextField();
        jtextNomeCadUser = new javax.swing.JTextField();
        jtextLoginCadUser = new javax.swing.JTextField();
        jtextEmailCadUser = new javax.swing.JTextField();
        jtextTelResCadUser = new javax.swing.JTextField();
        jtextTelCelCadUser = new javax.swing.JTextField();
        cbxTipoUserCadUser = new javax.swing.JComboBox<>();
        jFormDateCadUser = new javax.swing.JFormattedTextField();
        btnCadUser = new javax.swing.JButton();
        jtextTelAltCadUser = new javax.swing.JTextField();
        telaHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelBemVindo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        barVendas = new javax.swing.JMenu();
        barCompras = new javax.swing.JMenu();
        barMed = new javax.swing.JMenu();
        itemCadMed = new javax.swing.JMenuItem();
        barLab = new javax.swing.JMenu();
        itemCadLab = new javax.swing.JMenuItem();
        itemAltLab = new javax.swing.JMenuItem();
        barDrog = new javax.swing.JMenu();
        itemCadDrog = new javax.swing.JMenuItem();
        itemAltDrog = new javax.swing.JMenuItem();
        barUser = new javax.swing.JMenu();
        itemCadFun = new javax.swing.JMenuItem();
        itemDelFun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1170, 500));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        mainPainel.setLayout(new java.awt.CardLayout());

        labelSenhaLog.setText("Senha");

        btnEntrarLogin.setText("Entrar");
        btnEntrarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarLoginMouseClicked(evt);
            }
        });

        jtextUserLog.setText("ivan");
        jtextUserLog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextUserLogKeyPressed(evt);
            }
        });

        jpassSenhaLogin.setText("ivan");
        jpassSenhaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpassSenhaLoginKeyPressed(evt);
            }
        });

        labelUserLog.setText("Usuário");

        javax.swing.GroupLayout telaLoginLayout = new javax.swing.GroupLayout(telaLogin);
        telaLogin.setLayout(telaLoginLayout);
        telaLoginLayout.setHorizontalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLoginLayout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtextUserLog)
                    .addComponent(jpassSenhaLogin)
                    .addComponent(btnEntrarLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSenhaLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUserLog, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(500, 500, 500))
        );
        telaLoginLayout.setVerticalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLoginLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(labelUserLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtextUserLog, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSenhaLog)
                .addGap(9, 9, 9)
                .addComponent(jpassSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );

        jtextUserLog.getAccessibleContext().setAccessibleName("");

        mainPainel.add(telaLogin, "Login");

        javax.swing.GroupLayout telaVendasLayout = new javax.swing.GroupLayout(telaVendas);
        telaVendas.setLayout(telaVendasLayout);
        telaVendasLayout.setHorizontalGroup(
            telaVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
        );
        telaVendasLayout.setVerticalGroup(
            telaVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        mainPainel.add(telaVendas, "card2");

        cbxCnpjComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCnpjCompKeyPressed(evt);
            }
        });

        jLabel6.setText("CNPJ");

        jLabel7.setText("Medicamentos");

        jLabel8.setText("Quantidade");

        cbxMedCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedCompraActionPerformed(evt);
            }
        });
        cbxMedCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxMedCompraKeyPressed(evt);
            }
        });

        jtextQtnCompra.setText("0");
        jtextQtnCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextQtnCompraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextQtnCompraKeyReleased(evt);
            }
        });

        jLabel9.setText("Forma de Pagamento");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão de Credito", "Cartão de Debito", "Dinheiro" }));
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });

        jLabel10.setText("Valor do Medicamento");

        labelValMedicamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel11.setText("Valor Total");

        labelValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel12.setText("Data compra");

        jLabel13.setText("Data Entrega");

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jtextPesquisaCbx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextPesquisaCbxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextPesquisaCbxKeyReleased(evt);
            }
        });

        jtextPesquisaNomeCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextPesquisaNomeCompraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextPesquisaNomeCompraKeyReleased(evt);
            }
        });

        try {
            jformDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformDataCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformDataCompraKeyPressed(evt);
            }
        });

        try {
            jformDataEntregaCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformDataEntregaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jformDataEntregaCompraActionPerformed(evt);
            }
        });
        jformDataEntregaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformDataEntregaCompraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout telaComprasLayout = new javax.swing.GroupLayout(telaCompras);
        telaCompras.setLayout(telaComprasLayout);
        telaComprasLayout.setHorizontalGroup(
            telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaComprasLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaComprasLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jformDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jformDataEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(telaComprasLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(telaComprasLayout.createSequentialGroup()
                        .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtextPesquisaCbx, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCnpjComp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMedCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(labelValMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextPesquisaNomeCompra))
                        .addGap(32, 32, 32)
                        .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtextQtnCompra)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        telaComprasLayout.setVerticalGroup(
            telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaComprasLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextPesquisaCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextPesquisaNomeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCnpjComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMedCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextQtnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(16, 16, 16)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(16, 16, 16)
                .addGroup(telaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jformDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jformDataEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        mainPainel.add(telaCompras, "Compras");

        jtextValCusCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextValCusCadMedKeyPressed(evt);
            }
        });

        labelValCusCadMed.setText("Valor custo*");

        jtextValVenCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextValVenCadMedKeyPressed(evt);
            }
        });

        labelDescCadMed.setText("Descrição*");

        labelValVenCadMed.setText("Valor venda*");

        labelTipoCadMed.setText("Tipo*");

        jtextQtndCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextQtndCadMedKeyPressed(evt);
            }
        });

        labelNomeCadMed.setText("Nome*");

        labelDataUltCompCadMed.setText("Data da Ultima Compra*");

        labelQtndCadMed.setText("Quantidade*");

        jtextNomeCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNomeCadMedKeyPressed(evt);
            }
        });

        btnCadMed.setText("Cadastrar");
        btnCadMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadMedActionPerformed(evt);
            }
        });

        jtextTipoCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextTipoCadMedKeyPressed(evt);
            }
        });

        jareaDescCadMed.setColumns(20);
        jareaDescCadMed.setRows(5);
        jareaDescCadMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jareaDescCadMedKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jareaDescCadMed);

        javax.swing.GroupLayout telaCadMedLayout = new javax.swing.GroupLayout(telaCadMed);
        telaCadMed.setLayout(telaCadMedLayout);
        telaCadMedLayout.setHorizontalGroup(
            telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadMedLayout.createSequentialGroup()
                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaCadMedLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNomeCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextNomeCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTipoCadMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextTipoCadMed, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                    .addGroup(telaCadMedLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(labelDescCadMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaCadMedLayout.createSequentialGroup()
                                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelValCusCadMed, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(jtextValCusCadMed, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelValVenCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextValVenCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(telaCadMedLayout.createSequentialGroup()
                                .addComponent(labelDataUltCompCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelQtndCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(telaCadMedLayout.createSequentialGroup()
                                .addComponent(btnCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtextQtndCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        telaCadMedLayout.setVerticalGroup(
            telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadMedLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCadMed)
                    .addComponent(labelTipoCadMed))
                .addGap(18, 18, 18)
                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtextTipoCadMed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNomeCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelValCusCadMed)
                        .addComponent(labelValVenCadMed))
                    .addComponent(labelDescCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaCadMedLayout.createSequentialGroup()
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextValCusCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextValVenCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataUltCompCadMed)
                            .addComponent(labelQtndCadMed))
                        .addGap(18, 18, 18)
                        .addComponent(jtextQtndCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadMed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        mainPainel.add(telaCadMed, "Cadastrar Medicamentos");

        tblMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMed);

        labelNomeAltLab1.setText("Nome");

        labelIDAltLab1.setText("CODIGO");

        groupbrnAltDrog.add(radioCresAltMed);
        radioCresAltMed.setText("Cresente");
        radioCresAltMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCresAltMedActionPerformed(evt);
            }
        });

        jtextIDAltMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextIDAltMedKeyReleased(evt);
            }
        });

        groupbrnAltDrog.add(radioDescAltMed);
        radioDescAltMed.setText("Decrescente");
        radioDescAltMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDescAltMedActionPerformed(evt);
            }
        });

        labelOrderByMed.setText("Ordem");

        jtextNomeAltMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextNomeAltMedKeyReleased(evt);
            }
        });

        cbxOrderByMed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome" }));
        cbxOrderByMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderByMedActionPerformed(evt);
            }
        });

        labelPesquisaAltLab1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPesquisaAltLab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPesquisaAltLab1.setText("Pesquisa");

        btnAltMed.setText("Alterar");
        btnAltMed.setEnabled(false);
        btnAltMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltMedActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descrição");

        jareaDescAltMed.setColumns(20);
        jareaDescAltMed.setRows(5);
        jScrollPane6.setViewportView(jareaDescAltMed);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tipo");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quantidade");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Valor Venda");

        javax.swing.GroupLayout telaAltMedLayout = new javax.swing.GroupLayout(telaAltMed);
        telaAltMed.setLayout(telaAltMedLayout);
        telaAltMedLayout.setHorizontalGroup(
            telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltMedLayout.createSequentialGroup()
                .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaAltMedLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPesquisaAltLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(telaAltMedLayout.createSequentialGroup()
                                    .addComponent(labelIDAltLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtextIDAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addComponent(labelNomeAltLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtextNomeAltMed))
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioDescAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioCresAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxOrderByMed, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelOrderByMed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addComponent(jtextTipoAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtextQtndAltMed))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextValorVendaAltMed))
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, telaAltMedLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        telaAltMedLayout.setVerticalGroup(
            telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaAltMedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaAltMedLayout.createSequentialGroup()
                        .addComponent(labelPesquisaAltLab1)
                        .addGap(14, 14, 14)
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelIDAltLab1))
                            .addComponent(jtextIDAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(labelNomeAltLab1))
                            .addComponent(jtextNomeAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltMedLayout.createSequentialGroup()
                                .addComponent(radioCresAltMed)
                                .addGap(7, 7, 7)
                                .addComponent(radioDescAltMed))
                            .addComponent(labelOrderByMed, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltMedLayout.createSequentialGroup()
                                .addComponent(cbxOrderByMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaAltMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextTipoAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextQtndAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextValorVendaAltMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAltMed)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPainel.add(telaAltMed, "Alterar Medicamentos");

        jtextBairroCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextBairroCadLabKeyPressed(evt);
            }
        });

        labelCEPCadLab.setText("CEP*");

        labelBairroCadLab.setText("Bairro*");

        labelCNPJCadLab.setText("CNPJ*");

        jtextNumCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNumCadLabKeyPressed(evt);
            }
        });

        labelNumCadLab.setText("Número*");

        labelEstadoCadDLab.setText("Estado*");

        btnCadDrog1.setText("Cadastrar");
        btnCadDrog1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadDrog1ActionPerformed(evt);
            }
        });

        jtextCidadeCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextCidadeCadLabKeyPressed(evt);
            }
        });

        try {
            jformCEPCadLab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCEPCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCEPCadLabKeyPressed(evt);
            }
        });

        labelCidadeCadLab.setText("Cidade*");

        try {
            jformCNPJCadLab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCNPJCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCNPJCadLabKeyPressed(evt);
            }
        });

        jtextRuaCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextRuaCadLabKeyPressed(evt);
            }
        });

        labelRuaCadLab.setText("Rua*");

        jtextComplementoCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextComplementoCadLabKeyPressed(evt);
            }
        });

        labelNomeCadLab.setText("Nome*");

        labelCompCadLab.setText("Complemento");

        jtextNomeCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNomeCadLabKeyPressed(evt);
            }
        });

        labelInsEstCadLab.setText("Inscrição Estadual");

        cbxEstadoCadLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstadoCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxEstadoCadLabKeyPressed(evt);
            }
        });

        try {
            jformInsEstCadLab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformInsEstCadLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformInsEstCadLabKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout telaCadLabLayout = new javax.swing.GroupLayout(telaCadLab);
        telaCadLab.setLayout(telaCadLabLayout);
        telaCadLabLayout.setHorizontalGroup(
            telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadLabLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaCadLabLayout.createSequentialGroup()
                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaCadLabLayout.createSequentialGroup()
                                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelNomeCadLab, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(jtextNomeCadLab)
                                    .addComponent(labelEstadoCadDLab, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(cbxEstadoCadLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaCadLabLayout.createSequentialGroup()
                                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(telaCadLabLayout.createSequentialGroup()
                                                .addComponent(labelCNPJCadLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18))
                                            .addGroup(telaCadLabLayout.createSequentialGroup()
                                                .addComponent(jformCNPJCadLab, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelCEPCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jformCEPCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(telaCadLabLayout.createSequentialGroup()
                                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCidadeCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtextCidadeCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelBairroCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtextBairroCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(telaCadLabLayout.createSequentialGroup()
                                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelRuaCadLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtextRuaCadLab, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCadDrog1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(telaCadLabLayout.createSequentialGroup()
                                        .addComponent(jtextNumCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtextComplementoCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(telaCadLabLayout.createSequentialGroup()
                                        .addComponent(labelNumCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelCompCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(229, 229, 229))
                    .addGroup(telaCadLabLayout.createSequentialGroup()
                        .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jformInsEstCadLab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInsEstCadLab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        telaCadLabLayout.setVerticalGroup(
            telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadLabLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCadLab)
                    .addComponent(labelCNPJCadLab)
                    .addComponent(labelCEPCadLab))
                .addGap(18, 18, 18)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jformCEPCadLab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextNomeCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jformCNPJCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidadeCadLab)
                    .addComponent(labelEstadoCadDLab)
                    .addComponent(labelBairroCadLab))
                .addGap(18, 18, 18)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextCidadeCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextBairroCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstadoCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRuaCadLab)
                    .addComponent(labelNumCadLab)
                    .addComponent(labelCompCadLab))
                .addGap(18, 18, 18)
                .addGroup(telaCadLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextRuaCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNumCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextComplementoCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(labelInsEstCadLab)
                .addGap(18, 18, 18)
                .addComponent(jformInsEstCadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnCadDrog1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPainel.add(telaCadLab, "Cadastrar Laboratórios");

        btnAltAtivarLab.setText("Ativar/Desativar");
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltAtivarLabActionPerformed(evt);
            }
        });

        cbxStatusAltLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Desativo" }));
        cbxStatusAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusAltLabActionPerformed(evt);
            }
        });

        labelNomeAltLab.setText("Nome");

        labelStatusLab.setText("Status");

        jtextIDAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextIDAltLabKeyReleased(evt);
            }
        });

        labelCEPAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCEPAltLab.setText("CEP");

        jtextCNPJAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextCNPJAltLabKeyReleased(evt);
            }
        });

        try {
            jformCEPAltLab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCEPAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCEPAltLabKeyPressed(evt);
            }
        });

        jtextNomeAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextNomeAltLabKeyReleased(evt);
            }
        });

        labelPesquisaAltLab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPesquisaAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPesquisaAltLab.setText("Pesquisa");

        jtextRuaAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextRuaAltLabKeyPressed(evt);
            }
        });

        labelRuaAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRuaAltLab.setText("Rua");

        jtextComplementoAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextComplementoAltLabKeyPressed(evt);
            }
        });

        labelCompAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCompAltLab.setText("Complemento");

        jtextBairroAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextBairroAltLabKeyPressed(evt);
            }
        });

        labelBairroAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBairroAltLab.setText("Bairro");

        jtextNumAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNumAltLabKeyPressed(evt);
            }
        });

        labelNumAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumAltLab.setText("Número");

        labelEstadoAltLab.setText("Estado");

        jtextCidadeAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextCidadeAltLabKeyPressed(evt);
            }
        });

        labelCidadeAltLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCidadeAltLab.setText("Cidade");

        tblAltLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAltLabMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblAltLab);

        btnAltLab.setText("Alterar");
        btnAltLab.setEnabled(false);
        btnAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltLabActionPerformed(evt);
            }
        });

        labelIDAltLab.setText("CODIGO");

        groupbrnAltDrog.add(radioCresAltLab);
        radioCresAltLab.setText("Cresente");
        radioCresAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCresAltLabActionPerformed(evt);
            }
        });

        labelCNPJAltLab.setText("CNPJ");

        groupbrnAltDrog.add(radioDescAltLab);
        radioDescAltLab.setText("Decrescente");
        radioDescAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDescAltLabActionPerformed(evt);
            }
        });

        cbxEstadoAltLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstadoAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxEstadoAltLabKeyPressed(evt);
            }
        });

        labelOrderByLab.setText("Ordem");

        cbxOrderByAltLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "CNPJ", "Nome", "Inscrição Estadual" }));
        cbxOrderByAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderByAltLabActionPerformed(evt);
            }
        });

        labelInsEstAltLab.setText("Inscrição Estadual");

        jtextInsEstAltLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextInsEstAltLabKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout telaAltLabLayout = new javax.swing.GroupLayout(telaAltLab);
        telaAltLab.setLayout(telaAltLabLayout);
        telaAltLabLayout.setHorizontalGroup(
            telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaAltLabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(telaAltLabLayout.createSequentialGroup()
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelEstadoAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(cbxEstadoAltLab, 0, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtextRuaAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(labelRuaAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextNumAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(telaAltLabLayout.createSequentialGroup()
                            .addComponent(btnAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(btnAltAtivarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPesquisaAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(telaAltLabLayout.createSequentialGroup()
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelNomeAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelCNPJAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelIDAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextIDAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextCNPJAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextNomeAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(labelBairroAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextBairroAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextCidadeAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaAltLabLayout.createSequentialGroup()
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jformCEPAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(labelCEPAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCompAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextComplementoAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelCidadeAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaAltLabLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioDescAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioCresAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxOrderByAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelOrderByLab, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaAltLabLayout.createSequentialGroup()
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelInsEstAltLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelStatusLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxStatusAltLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextInsEstAltLab))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaAltLabLayout.setVerticalGroup(
            telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltLabLayout.createSequentialGroup()
                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaAltLabLayout.createSequentialGroup()
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltLabLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(labelPesquisaAltLab)
                                .addGap(14, 14, 14)
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltLabLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelIDAltLab))
                                    .addComponent(jtextIDAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltLabLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelCNPJAltLab))
                                    .addComponent(jtextCNPJAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltLabLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelNomeAltLab))
                                    .addComponent(jtextNomeAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(telaAltLabLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxStatusAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStatusLab))))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelInsEstAltLab)
                            .addComponent(jtextInsEstAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltLabLayout.createSequentialGroup()
                                .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(telaAltLabLayout.createSequentialGroup()
                                        .addComponent(radioCresAltLab)
                                        .addGap(7, 7, 7)
                                        .addComponent(radioDescAltLab))
                                    .addComponent(labelOrderByLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltLabLayout.createSequentialGroup()
                                .addComponent(cbxOrderByAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCEPAltLab)
                            .addComponent(labelCompAltLab))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jformCEPAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextComplementoAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRuaAltLab)
                            .addComponent(labelEstadoAltLab)
                            .addComponent(labelNumAltLab))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextRuaAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadoAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextNumAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(labelCidadeAltLab)
                        .addGap(18, 18, 18)
                        .addComponent(jtextCidadeAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelBairroAltLab)
                        .addGap(18, 18, 18)
                        .addComponent(jtextBairroAltLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(telaAltLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAltAtivarLab)
                            .addComponent(btnAltLab))))
                .addGap(14, 14, 14))
        );

        mainPainel.add(telaAltLab, "Alterar Laboratórios");

        labelNomeCadDrog.setText("Nome*");

        jtextNomeCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNomeCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog1.setText("CEP*");

        labelCNPJCadDrog.setText("CNPJ*");

        labelNomeCadDrog2.setText("Estado*");

        jtextCidadeCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextCidadeCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog3.setText("Cidade*");

        jtextRuaCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextRuaCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog4.setText("Rua*");

        jtextComplementoCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextComplementoCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog5.setText("Complemento");

        jtextBairroCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextBairroCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog6.setText("Bairro*");

        jtextNumCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNumCadDrogKeyPressed(evt);
            }
        });

        labelNomeCadDrog7.setText("Número*");

        btnCadDrog.setText("Cadastrar");
        btnCadDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadDrogActionPerformed(evt);
            }
        });

        try {
            jformCEPCadDrog.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCEPCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCEPCadDrogKeyPressed(evt);
            }
        });

        try {
            jformCNPJCadDrog.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCNPJCadDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCNPJCadDrogKeyPressed(evt);
            }
        });

        cbxEstadoCadDrog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout telaCadDrogLayout = new javax.swing.GroupLayout(telaCadDrog);
        telaCadDrog.setLayout(telaCadDrogLayout);
        telaCadDrogLayout.setHorizontalGroup(
            telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadDrogLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNomeCadDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jtextNomeCadDrog)
                            .addComponent(labelNomeCadDrog2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(cbxEstadoCadDrog, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaCadDrogLayout.createSequentialGroup()
                                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                                        .addComponent(labelCNPJCadDrog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                                        .addComponent(jformCNPJCadDrog)
                                        .addGap(18, 18, 18)))
                                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelNomeCadDrog1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jformCEPCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(telaCadDrogLayout.createSequentialGroup()
                                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomeCadDrog3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextCidadeCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomeCadDrog6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextBairroCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNomeCadDrog4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextRuaCadDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(labelNomeCadDrog5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtextComplementoCadDrog))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeCadDrog7, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextNumCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(229, 229, 229))
        );
        telaCadDrogLayout.setVerticalGroup(
            telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadDrogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCadDrog)
                    .addComponent(labelCNPJCadDrog)
                    .addComponent(labelNomeCadDrog1))
                .addGap(18, 18, 18)
                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jformCEPCadDrog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextNomeCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jformCNPJCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomeCadDrog3)
                            .addComponent(labelNomeCadDrog2)
                            .addComponent(labelNomeCadDrog6))
                        .addGap(18, 18, 18)
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextCidadeCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextBairroCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadoCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(telaCadDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaCadDrogLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNomeCadDrog4)
                                .addGap(18, 18, 18)
                                .addComponent(jtextRuaCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaCadDrogLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNomeCadDrog7)
                                .addGap(18, 18, 18)
                                .addComponent(jtextNumCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(telaCadDrogLayout.createSequentialGroup()
                        .addComponent(labelNomeCadDrog5)
                        .addGap(18, 18, 18)
                        .addComponent(jtextComplementoCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(btnCadDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPainel.add(telaCadDrog, "Cadastrar Drogarias");

        labelIDAltDrog.setText("CODIGO");

        labelCNPJAltDrog.setText("CNPJ");

        labelNomeAltDrog.setText("Nome");

        jtextIDAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextIDAltDrogKeyReleased(evt);
            }
        });

        jtextCNPJAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextCNPJAltDrogKeyReleased(evt);
            }
        });

        jtextNomeAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextNomeAltDrogKeyReleased(evt);
            }
        });

        labelPesquisaAltDrog.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPesquisaAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPesquisaAltDrog.setText("Pesquisa");

        jtextRuaAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextRuaAltDrogKeyPressed(evt);
            }
        });

        labelRuaAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRuaAltDrog.setText("Rua");

        jtextComplementoAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextComplementoAltDrogKeyPressed(evt);
            }
        });

        labelCompAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCompAltDrog.setText("Complemento");

        jtextBairroAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextBairroAltDrogKeyPressed(evt);
            }
        });

        labelBairroAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBairroAltDrog.setText("Bairro");

        jtextNumAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNumAltDrogKeyPressed(evt);
            }
        });

        labelNumAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumAltDrog.setText("Número");

        labelEstadoAltDrog.setText("Estado");

        jtextCidadeAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextCidadeAltDrogKeyPressed(evt);
            }
        });

        labelCidadeAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCidadeAltDrog.setText("Cidade");

        tblAltDrog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAltDrog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAltDrogMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblAltDrog);

        btnAlt.setText("Alterar");
        btnAlt.setEnabled(false);
        btnAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltActionPerformed(evt);
            }
        });

        btnAltAtivar.setText("Ativar/Desativar");
        btnAltAtivar.setEnabled(false);
        btnAltAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltAtivarActionPerformed(evt);
            }
        });

        cbxStatusAltDrog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Desativo" }));
        cbxStatusAltDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusAltDrogActionPerformed(evt);
            }
        });

        labelStatusAltDrog.setText("Status");

        labelCepAltDrog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCepAltDrog.setText("CEP");

        try {
            jformCEPAltDrog.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformCEPAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jformCEPAltDrogKeyPressed(evt);
            }
        });

        groupbrnAltDrog.add(radioCresAltDrog);
        radioCresAltDrog.setText("Cresente");
        radioCresAltDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCresAltDrogActionPerformed(evt);
            }
        });

        groupbrnAltDrog.add(radioDescAltDrog);
        radioDescAltDrog.setText("Decrescente");

        labelOrderBy.setText("Ordem");

        cbxOrderByAltDrog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "CNPJ", "Nome" }));
        cbxOrderByAltDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderByAltDrogActionPerformed(evt);
            }
        });

        cbxEstadoAltDrog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbxEstadoAltDrog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxEstadoAltDrogKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout telaAltDrogLayout = new javax.swing.GroupLayout(telaAltDrog);
        telaAltDrog.setLayout(telaAltDrogLayout);
        telaAltDrogLayout.setHorizontalGroup(
            telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaAltDrogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(telaAltDrogLayout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(radioDescAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(radioCresAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxOrderByAltDrog, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(telaAltDrogLayout.createSequentialGroup()
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelEstadoAltDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(cbxEstadoAltDrog, 0, 1, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtextRuaAltDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(labelRuaAltDrog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNumAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextNumAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(telaAltDrogLayout.createSequentialGroup()
                                .addComponent(btnAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnAltAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelPesquisaAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(telaAltDrogLayout.createSequentialGroup()
                                    .addComponent(labelIDAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtextIDAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(telaAltDrogLayout.createSequentialGroup()
                                    .addComponent(labelCNPJAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtextCNPJAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(telaAltDrogLayout.createSequentialGroup()
                                    .addComponent(labelNomeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtextNomeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(labelBairroAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextBairroAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextCidadeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(telaAltDrogLayout.createSequentialGroup()
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelStatusAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelOrderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(cbxStatusAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(telaAltDrogLayout.createSequentialGroup()
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jformCEPAltDrog, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(labelCepAltDrog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelCompAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextComplementoAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(labelCidadeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaAltDrogLayout.setVerticalGroup(
            telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltDrogLayout.createSequentialGroup()
                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaAltDrogLayout.createSequentialGroup()
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltDrogLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(labelPesquisaAltDrog)
                                .addGap(14, 14, 14)
                                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltDrogLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelIDAltDrog))
                                    .addComponent(jtextIDAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltDrogLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelCNPJAltDrog))
                                    .addComponent(jtextCNPJAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(telaAltDrogLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(labelNomeAltDrog))
                                    .addComponent(jtextNomeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(telaAltDrogLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxStatusAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStatusAltDrog))))
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaAltDrogLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(telaAltDrogLayout.createSequentialGroup()
                                        .addComponent(radioCresAltDrog)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioDescAltDrog))
                                    .addComponent(labelOrderBy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaAltDrogLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(cbxOrderByAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCepAltDrog)
                            .addComponent(labelCompAltDrog))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jformCEPAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextComplementoAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRuaAltDrog)
                            .addComponent(labelEstadoAltDrog)
                            .addComponent(labelNumAltDrog))
                        .addGap(18, 18, 18)
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextRuaAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadoAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextNumAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(labelCidadeAltDrog)
                        .addGap(18, 18, 18)
                        .addComponent(jtextCidadeAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelBairroAltDrog)
                        .addGap(18, 18, 18)
                        .addComponent(jtextBairroAltDrog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(telaAltDrogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAltAtivar)
                            .addComponent(btnAlt))))
                .addGap(14, 14, 14))
        );

        mainPainel.add(telaAltDrog, "Alterar Drogarias");

        labelLogDelUser.setText("Login");

        jtextUserDelUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextUserDelUserKeyReleased(evt);
            }
        });

        labelEmailDelUser.setText("E-mail");

        jtextEmailDelUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextEmailDelUserKeyReleased(evt);
            }
        });

        labelTipolDelUser.setText("Tipo");

        cbxTipoUserDelUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionario" }));
        cbxTipoUserDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoUserDelUserActionPerformed(evt);
            }
        });

        tblDelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDelUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDelUser);

        btnPesquisaDelUser.setText("Pesquisar");
        btnPesquisaDelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisaDelUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPesquisaDelUserMousePressed(evt);
            }
        });

        btnDelDelUser.setText("Deletar");
        btnDelDelUser.setEnabled(false);
        btnDelDelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelDelUserMouseClicked(evt);
            }
        });

        cbxOrderByDelUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Login", "E-mail", "Nome", "Data de nascimento" }));
        cbxOrderByDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrderByDelUserActionPerformed(evt);
            }
        });

        groupbtnDelFun.add(radioDescDelFun);
        radioDescDelFun.setText("Descresente");
        radioDescDelFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDescDelFunActionPerformed(evt);
            }
        });

        groupbtnDelFun.add(radioCrescDelFun);
        radioCrescDelFun.setText("Cresente");
        radioCrescDelFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCrescDelFunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaDelUserLayout = new javax.swing.GroupLayout(telaDelUser);
        telaDelUser.setLayout(telaDelUserLayout);
        telaDelUserLayout.setHorizontalGroup(
            telaDelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaDelUserLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(telaDelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtextEmailDelUser)
                    .addComponent(labelEmailDelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLogDelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTipolDelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTipoUserDelUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisaDelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelDelUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrderByDelUser, 0, 129, Short.MAX_VALUE)
                    .addComponent(radioDescDelFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioCrescDelFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextUserDelUser))
                .addGap(94, 94, 94)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                .addContainerGap())
        );
        telaDelUserLayout.setVerticalGroup(
            telaDelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaDelUserLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelLogDelUser)
                .addGap(18, 18, 18)
                .addComponent(jtextUserDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelEmailDelUser)
                .addGap(18, 18, 18)
                .addComponent(jtextEmailDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTipolDelUser)
                .addGap(18, 18, 18)
                .addComponent(cbxTipoUserDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisaDelUser)
                .addGap(18, 18, 18)
                .addComponent(btnDelDelUser)
                .addGap(18, 18, 18)
                .addComponent(cbxOrderByDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radioDescDelFun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioCrescDelFun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(telaDelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPainel.add(telaDelUser, "Deletar Funcionários");

        labelNomeCadUser.setText("Nome*");

        labelLoginCadUser.setText("Login*");

        labelSenhaCadUser.setText("Senha*");

        labelEmailCadUser.setText("E-mail*");

        labelTipoCadUser.setText("Tipo de Funcionario*");

        labelDateCadUser.setText("Data de nascimento*");

        labelTelCelCadUser.setText("Telefone  Celular");

        labelTelResCadUser.setText("Telefone  Residencial");

        labelTelAdCadUser.setText("Telefone  Adicional");

        jtextSenhaCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextSenhaCadUserKeyPressed(evt);
            }
        });

        jtextNomeCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextNomeCadUserKeyPressed(evt);
            }
        });

        jtextLoginCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextLoginCadUserKeyPressed(evt);
            }
        });

        jtextEmailCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextEmailCadUserKeyPressed(evt);
            }
        });

        jtextTelResCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextTelResCadUserKeyPressed(evt);
            }
        });

        jtextTelCelCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextTelCelCadUserKeyPressed(evt);
            }
        });

        cbxTipoUserCadUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrador", "Funcionario" }));
        cbxTipoUserCadUser.setToolTipText("");
        cbxTipoUserCadUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbxTipoUserCadUserMouseReleased(evt);
            }
        });
        cbxTipoUserCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxTipoUserCadUserKeyPressed(evt);
            }
        });

        try {
            jFormDateCadUser.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormDateCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormDateCadUserKeyPressed(evt);
            }
        });

        btnCadUser.setText("Cadastrar");
        btnCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadUserActionPerformed(evt);
            }
        });

        jtextTelAltCadUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextTelAltCadUserKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout telaCadUserLayout = new javax.swing.GroupLayout(telaCadUser);
        telaCadUser.setLayout(telaCadUserLayout);
        telaCadUserLayout.setHorizontalGroup(
            telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadUserLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaCadUserLayout.createSequentialGroup()
                        .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNomeCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jtextNomeCadUser))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtextEmailCadUser)
                    .addComponent(labelTelCelCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(labelEmailCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextTelCelCadUser))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLoginCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(jtextLoginCadUser)
                    .addComponent(labelTipoCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTelResCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextTelResCadUser)
                    .addComponent(cbxTipoUserCadUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDateCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(labelTelAdCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtextSenhaCadUser)
                    .addComponent(labelSenhaCadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormDateCadUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtextTelAltCadUser))
                .addGap(216, 216, 216))
        );
        telaCadUserLayout.setVerticalGroup(
            telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaCadUserLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCadUser)
                    .addComponent(labelLoginCadUser)
                    .addComponent(labelSenhaCadUser))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextSenhaCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNomeCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextLoginCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmailCadUser)
                    .addComponent(labelTipoCadUser)
                    .addComponent(labelDateCadUser))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextEmailCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoUserCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormDateCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelCelCadUser)
                    .addComponent(labelTelResCadUser)
                    .addComponent(labelTelAdCadUser))
                .addGap(32, 32, 32)
                .addGroup(telaCadUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextTelCelCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextTelResCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextTelAltCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        mainPainel.add(telaCadUser, "Cadastrar Funcionários");

        jLabel1.setText("Bem vindo: ");

        javax.swing.GroupLayout telaHomeLayout = new javax.swing.GroupLayout(telaHome);
        telaHome.setLayout(telaHomeLayout);
        telaHomeLayout.setHorizontalGroup(
            telaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaHomeLayout.createSequentialGroup()
                .addGap(513, 513, 513)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        telaHomeLayout.setVerticalGroup(
            telaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaHomeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(telaHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(558, Short.MAX_VALUE))
        );

        mainPainel.add(telaHome, "Home");

        barVendas.setText("Vendas");
        menuBar.add(barVendas);

        barCompras.setText("Compras");
        menuBar.add(barCompras);

        barMed.setText("Medicamentos");

        itemCadMed.setText("Cadastrar     Ctrl+M");
        barMed.add(itemCadMed);

        menuBar.add(barMed);

        barLab.setText("Laboratorios");

        itemCadLab.setText("Cadastrar     Ctrl+L");
        itemCadLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadLabActionPerformed(evt);
            }
        });
        barLab.add(itemCadLab);

        itemAltLab.setText("Alterar          Alt+L");
        itemAltLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAltLabActionPerformed(evt);
            }
        });
        barLab.add(itemAltLab);

        menuBar.add(barLab);

        barDrog.setText("Drogarias");

        itemCadDrog.setText("Cadastrar     Ctrl+D");
        itemCadDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadDrogActionPerformed(evt);
            }
        });
        barDrog.add(itemCadDrog);

        itemAltDrog.setText("Alterar           Alt+D");
        itemAltDrog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAltDrogActionPerformed(evt);
            }
        });
        barDrog.add(itemAltDrog);

        menuBar.add(barDrog);

        barUser.setText("Usuarios");

        itemCadFun.setText("Cadastrar      Ctrl+U");
        itemCadFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemCadFunMousePressed(evt);
            }
        });
        barUser.add(itemCadFun);

        itemDelFun.setText("Deletar           Ctrl+Shift+U");
        itemDelFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemDelFunMousePressed(evt);
            }
        });
        barUser.add(itemDelFun);

        menuBar.add(barUser);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtextUserLogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextUserLogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpassSenhaLogin.requestFocus();
        }
    }//GEN-LAST:event_jtextUserLogKeyPressed

    private void jpassSenhaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpassSenhaLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_jpassSenhaLoginKeyPressed

    private void btnEntrarLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarLoginMouseClicked
        entrar();
    }//GEN-LAST:event_btnEntrarLoginMouseClicked

    private void itemCadFunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCadFunMousePressed
        clearTxt();
        tela("Cadastrar Funcionários");
        jtextNomeCadUser.requestFocus();
    }//GEN-LAST:event_itemCadFunMousePressed

    private void btnCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadUserActionPerformed
        cadastrarFuncionario();
    }//GEN-LAST:event_btnCadUserActionPerformed

    private void jtextNomeCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextLoginCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextNomeCadUserKeyPressed

    private void jtextLoginCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextLoginCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextSenhaCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextLoginCadUserKeyPressed

    private void jtextSenhaCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextSenhaCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextEmailCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextSenhaCadUserKeyPressed

    private void cbxTipoUserCadUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTipoUserCadUserMouseReleased
        cbxTipoUserCadUser.removeItem("Selecione");
    }//GEN-LAST:event_cbxTipoUserCadUserMouseReleased

    private void cbxTipoUserCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxTipoUserCadUserKeyPressed
        cbxTipoUserCadUser.removeItem("Selecione");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jFormDateCadUser.requestFocus();
        }
    }//GEN-LAST:event_cbxTipoUserCadUserKeyPressed

    private void jtextEmailCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextEmailCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxTipoUserCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextEmailCadUserKeyPressed

    private void jFormDateCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormDateCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isValidDate(jFormDateCadUser.getText()) != null) {
                jtextTelCelCadUser.requestFocus();
            }

        }
    }//GEN-LAST:event_jFormDateCadUserKeyPressed

    private void jtextTelCelCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextTelCelCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextTelResCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextTelCelCadUserKeyPressed

    private void jtextTelResCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextTelResCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextTelAltCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextTelResCadUserKeyPressed

    private void jtextTelAltCadUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextTelAltCadUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarFuncionario();
            jtextNomeCadUser.requestFocus();
        }
    }//GEN-LAST:event_jtextTelAltCadUserKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_0 && evt.getKeyCode() == KeyEvent.VK_1) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyReleased

    private void itemDelFunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemDelFunMousePressed
        tela("Deletar Funcionários");
    }//GEN-LAST:event_itemDelFunMousePressed

    private void btnPesquisaDelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaDelUserMouseClicked
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_btnPesquisaDelUserMouseClicked

    private void btnPesquisaDelUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaDelUserMousePressed
        tablePesquisa();
    }//GEN-LAST:event_btnPesquisaDelUserMousePressed

    private void jtextUserDelUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextUserDelUserKeyReleased
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_jtextUserDelUserKeyReleased

    private void jtextEmailDelUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextEmailDelUserKeyReleased
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_jtextEmailDelUserKeyReleased

    private void cbxTipoUserDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoUserDelUserActionPerformed
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_cbxTipoUserDelUserActionPerformed

    private void tblDelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDelUserMouseClicked
        if (tblDelUser.getSelectedRow() != -1) {

            f.setId((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 0));
            f.setNome((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 1));
            f.setUser((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 2));
            f.setEmail((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 3));
            f.setTipoFunc((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 4));
            f.setDataNasc((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 5));
            f.setFoneCel((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 6));
            f.setFoneAlt((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 7));
            f.setFoneRes((String) FTM.getValueAt(tblDelUser.getSelectedRow(), 8));

            FTM.removeall();
            FTM.addLinha(f);
            btnDelDelUser.setEnabled(true);
        }
    }//GEN-LAST:event_tblDelUserMouseClicked

    private void btnDelDelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelDelUserMouseClicked
        btnDelDelUser.setEnabled(false);
        FuncionariosDao fd = new FuncionariosDao();
        if (fd.delete(f)) {
            tablePesquisa();
        }
    }//GEN-LAST:event_btnDelDelUserMouseClicked

    private void cbxOrderByDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderByDelUserActionPerformed
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_cbxOrderByDelUserActionPerformed

    private void radioDescDelFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDescDelFunActionPerformed
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_radioDescDelFunActionPerformed

    private void radioCrescDelFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCrescDelFunActionPerformed
        tablePesquisa();
        btnDel();
    }//GEN-LAST:event_radioCrescDelFunActionPerformed

    private void itemCadDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadDrogActionPerformed
        tela("Cadastrar Drogarias");
    }//GEN-LAST:event_itemCadDrogActionPerformed

    private void jformCEPCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCEPCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (viaCepCadDrog()) {
                jtextComplementoCadDrog.requestFocus();
            } else {
                cbxEstadoCadDrog.requestFocus();
            }
        }
    }//GEN-LAST:event_jformCEPCadDrogKeyPressed

    private void jtextNomeCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformCNPJCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextNomeCadDrogKeyPressed

    private void jformCNPJCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCNPJCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformCEPCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jformCNPJCadDrogKeyPressed

    private void jtextCidadeCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCidadeCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextBairroCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextCidadeCadDrogKeyPressed

    private void jtextBairroCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextBairroCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextRuaCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextBairroCadDrogKeyPressed

    private void jtextRuaCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextRuaCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextComplementoCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextRuaCadDrogKeyPressed

    private void jtextComplementoCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextComplementoCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextNumCadDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextComplementoCadDrogKeyPressed

    private void jtextNumCadDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNumCadDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarDrog();
        }
    }//GEN-LAST:event_jtextNumCadDrogKeyPressed

    private void btnCadDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadDrogActionPerformed
        cadastrarDrog();
    }//GEN-LAST:event_btnCadDrogActionPerformed

    private void itemAltDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltDrogActionPerformed
        tela("Alterar Drogarias");
    }//GEN-LAST:event_itemAltDrogActionPerformed

    private void cbxStatusAltDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusAltDrogActionPerformed
        tableAltDrog();
        btnAlt.setEnabled(false);
        btnAltAtivar.setEnabled(false);
        btnAltAtivar.setText("Ativar/Desativar");

    }//GEN-LAST:event_cbxStatusAltDrogActionPerformed

    private void btnAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltActionPerformed
        alterarDrog();
    }//GEN-LAST:event_btnAltActionPerformed

    private void tblAltDrogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAltDrogMouseClicked
        if (tblAltDrog.getSelectedRow() != -1) {

            d.setIDdroga((String) DTM.getValueAt(tblAltDrog.getSelectedRow(), 0));

            DrogariasDao dd = new DrogariasDao();
            d = dd.Verifica(d);
            DTM.removeall();
            DTM.addLinha(d);

            btnAlt.setEnabled(true);
            btnAltAtivar.setEnabled(true);

            if ("     -   ".equals(jformCEPAltDrog.getText())) {
                jformCEPAltDrog.setText(d.getCEP());
                cbxEstadoAltDrog.setSelectedItem(d.getEstado());
                jtextRuaAltDrog.setText(d.getRua());
                jtextNumAltDrog.setText(d.getNumero());
                jtextCidadeAltDrog.setText(d.getCidade());
                jtextBairroAltDrog.setText(d.getBairro());
                jtextComplementoAltDrog.setText(d.getComplemento());
            }

            if ("1".equals(d.getStatus())) {
                btnAltAtivar.setText("Ativar");
            } else {
                btnAltAtivar.setText("Desativar");
            }
        }
    }//GEN-LAST:event_tblAltDrogMouseClicked

    private void jtextCidadeAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCidadeAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextBairroAltDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextCidadeAltDrogKeyPressed

    private void jtextNumAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNumAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextCidadeAltDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextNumAltDrogKeyPressed

    private void jtextBairroAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextBairroAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (btnAlt.isEnabled()) {
                alterarDrog();
            }
        }
    }//GEN-LAST:event_jtextBairroAltDrogKeyPressed

    private void jtextComplementoAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextComplementoAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbxEstadoAltDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextComplementoAltDrogKeyPressed

    private void jtextRuaAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextRuaAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextNumAltDrog.requestFocus();
        }
    }//GEN-LAST:event_jtextRuaAltDrogKeyPressed

    private void jtextNomeAltDrogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeAltDrogKeyReleased
        tableAltDrog();
        btnAlt.setEnabled(false);
        btnAltAtivar.setEnabled(false);
        btnAltAtivar.setText("Ativar/Desativar");
    }//GEN-LAST:event_jtextNomeAltDrogKeyReleased

    private void jtextCNPJAltDrogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCNPJAltDrogKeyReleased
        tableAltDrog();
        btnAlt.setEnabled(false);
        btnAltAtivar.setEnabled(false);
        btnAltAtivar.setText("Ativar/Desativar");

    }//GEN-LAST:event_jtextCNPJAltDrogKeyReleased

    private void jtextIDAltDrogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextIDAltDrogKeyReleased
        tableAltDrog();
        btnAlt.setEnabled(false);
        btnAltAtivar.setEnabled(false);
        btnAltAtivar.setText("Ativar/Desativar");

    }//GEN-LAST:event_jtextIDAltDrogKeyReleased

    private void btnAltAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltAtivarActionPerformed
        desativarAtivar();
    }//GEN-LAST:event_btnAltAtivarActionPerformed

    private void jformCEPAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCEPAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (viaCepAltDrog()) {
                jtextComplementoAltDrog.requestFocus();
            } else {
                cbxEstadoAltDrog.requestFocus();
            }
        }
    }//GEN-LAST:event_jformCEPAltDrogKeyPressed

    private void radioCresAltDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCresAltDrogActionPerformed
        tableAltDrog();
    }//GEN-LAST:event_radioCresAltDrogActionPerformed

    private void cbxOrderByAltDrogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderByAltDrogActionPerformed
        tableAltDrog();
    }//GEN-LAST:event_cbxOrderByAltDrogActionPerformed

    private void jtextBairroCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextBairroCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextRuaCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextBairroCadLabKeyPressed

    private void jtextNumCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNumCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextComplementoCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextNumCadLabKeyPressed

    private void btnCadDrog1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadDrog1ActionPerformed
        cadastrarLab();
    }//GEN-LAST:event_btnCadDrog1ActionPerformed

    private void jtextCidadeCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCidadeCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextBairroCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextCidadeCadLabKeyPressed

    private void jformCEPCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCEPCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (viaCepCadLab()) {
                jtextNumCadLab.requestFocus();
            } else {
                cbxEstadoCadLab.requestFocus();
            }
        }
    }//GEN-LAST:event_jformCEPCadLabKeyPressed

    private void jformCNPJCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCNPJCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformCEPCadLab.requestFocus();
        }
    }//GEN-LAST:event_jformCNPJCadLabKeyPressed

    private void jtextRuaCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextRuaCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextNumCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextRuaCadLabKeyPressed

    private void jtextComplementoCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextComplementoCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformInsEstCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextComplementoCadLabKeyPressed

    private void jtextNomeCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformCNPJCadLab.requestFocus();
        }
    }//GEN-LAST:event_jtextNomeCadLabKeyPressed

    private void itemCadLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadLabActionPerformed
        tela("Cadastrar Laboratórios");
    }//GEN-LAST:event_itemCadLabActionPerformed

    private void cbxEstadoAltDrogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxEstadoAltDrogKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextRuaAltDrog.requestFocus();
        }
    }//GEN-LAST:event_cbxEstadoAltDrogKeyPressed

    private void cbxEstadoCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxEstadoCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextCidadeCadLab.requestFocus();
        }
    }//GEN-LAST:event_cbxEstadoCadLabKeyPressed

    private void jformInsEstCadLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformInsEstCadLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarLab();
        }
    }//GEN-LAST:event_jformInsEstCadLabKeyPressed

    private void btnAltAtivarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltAtivarLabActionPerformed
        desativarAtivarLab();
    }//GEN-LAST:event_btnAltAtivarLabActionPerformed

    private void cbxStatusAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusAltLabActionPerformed
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_cbxStatusAltLabActionPerformed

    private void jtextIDAltLabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextIDAltLabKeyReleased
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_jtextIDAltLabKeyReleased

    private void jtextCNPJAltLabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCNPJAltLabKeyReleased
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_jtextCNPJAltLabKeyReleased

    private void jformCEPAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformCEPAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (viaCepAltLab()) {
                jtextComplementoAltLab.requestFocus();
            } else {
                cbxEstadoAltLab.requestFocus();
            }
        }
    }//GEN-LAST:event_jformCEPAltLabKeyPressed

    private void jtextNomeAltLabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeAltLabKeyReleased
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_jtextNomeAltLabKeyReleased

    private void jtextRuaAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextRuaAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextNumAltLab.requestFocus();
        }
    }//GEN-LAST:event_jtextRuaAltLabKeyPressed

    private void jtextComplementoAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextComplementoAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (btnAltLab.isEnabled()) {
                alterarLab();
            }
        }
    }//GEN-LAST:event_jtextComplementoAltLabKeyPressed

    private void jtextBairroAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextBairroAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextComplementoAltLab.requestFocus();
        }
    }//GEN-LAST:event_jtextBairroAltLabKeyPressed

    private void jtextNumAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNumAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextCidadeAltLab.requestFocus();
        }
    }//GEN-LAST:event_jtextNumAltLabKeyPressed

    private void jtextCidadeAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextCidadeAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextBairroAltLab.requestFocus();
        }
    }//GEN-LAST:event_jtextCidadeAltLabKeyPressed

    private void tblAltLabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAltLabMouseClicked
        if (tblAltLab.getSelectedRow() != -1) {

            l.setIdFornecedor((String) LTM.getValueAt(tblAltLab.getSelectedRow(), 0));

            LaboratoriosDao ld = new LaboratoriosDao();
            l = ld.Verifica(l);
            LTM.removeall();
            LTM.addLinha(l);

            btnAltLab.setEnabled(true);
            btnAltAtivarLab.setEnabled(true);

            if ("     -   ".equals(jformCEPAltLab.getText())) {
                jformCEPAltLab.setText(l.getCEP());
                cbxEstadoAltLab.setSelectedItem(l.getEstado());
                jtextRuaAltLab.setText(l.getRua());
                jtextNumAltLab.setText(l.getNumero());
                jtextCidadeAltLab.setText(l.getCidade());
                jtextBairroAltLab.setText(l.getBairro());
                jtextComplementoAltLab.setText(l.getComplemento());
            }

            if ("1".equals(l.getStatus())) {
                btnAltAtivarLab.setText("Ativar");
            } else {
                btnAltAtivarLab.setText("Desativar");
            }
        }
    }//GEN-LAST:event_tblAltLabMouseClicked

    private void btnAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltLabActionPerformed
        alterarLab();
    }//GEN-LAST:event_btnAltLabActionPerformed

    private void radioCresAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCresAltLabActionPerformed
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_radioCresAltLabActionPerformed

    private void cbxEstadoAltLabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxEstadoAltLabKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextRuaAltLab.requestFocus();
        }
    }//GEN-LAST:event_cbxEstadoAltLabKeyPressed

    private void cbxOrderByAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderByAltLabActionPerformed
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_cbxOrderByAltLabActionPerformed

    private void radioDescAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDescAltLabActionPerformed
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_radioDescAltLabActionPerformed

    private void jtextInsEstAltLabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextInsEstAltLabKeyReleased
        tableAltLab();
        btnAltLab.setEnabled(false);
        btnAltAtivarLab.setEnabled(false);
        btnAltAtivarLab.setText("Ativar/Desativar");
    }//GEN-LAST:event_jtextInsEstAltLabKeyReleased

    private void itemAltLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltLabActionPerformed
        tela("Alterar Laboratórios");
    }//GEN-LAST:event_itemAltLabActionPerformed

    private void jtextValCusCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextValCusCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextValVenCadMed.requestFocus();
        }
    }//GEN-LAST:event_jtextValCusCadMedKeyPressed

    private void jtextValVenCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextValVenCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformDataCompra.requestFocus();
        }
    }//GEN-LAST:event_jtextValVenCadMedKeyPressed

    private void jtextQtndCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextQtndCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarMed();
        }
    }//GEN-LAST:event_jtextQtndCadMedKeyPressed

    private void jtextNomeCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextTipoCadMed.requestFocus();
        }
    }//GEN-LAST:event_jtextNomeCadMedKeyPressed

    private void btnCadMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadMedActionPerformed
        cadastrarMed();
    }//GEN-LAST:event_btnCadMedActionPerformed

    private void jtextTipoCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextTipoCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jareaDescCadMed.requestFocus();
        }
    }//GEN-LAST:event_jtextTipoCadMedKeyPressed

    private void jareaDescCadMedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jareaDescCadMedKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextValCusCadMed.requestFocus();
        }
    }//GEN-LAST:event_jareaDescCadMedKeyPressed

    private void jformDataCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformDataCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isValidDate(jformDataCompra.getText()) != null) {
                jformDataEntregaCompra.requestFocus();
            }
        }
    }//GEN-LAST:event_jformDataCompraKeyPressed

    private void radioCresAltMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCresAltMedActionPerformed
        tableAltMed();
        btnAltMed.setEnabled(false);
    }//GEN-LAST:event_radioCresAltMedActionPerformed

    private void jtextIDAltMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextIDAltMedKeyReleased
        tableAltMed();
        btnAltMed.setEnabled(false);
    }//GEN-LAST:event_jtextIDAltMedKeyReleased

    private void radioDescAltMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDescAltMedActionPerformed
        tableAltMed();
        btnAltMed.setEnabled(false);
    }//GEN-LAST:event_radioDescAltMedActionPerformed

    private void jtextNomeAltMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNomeAltMedKeyReleased
        tableAltMed();
        btnAltMed.setEnabled(false);
    }//GEN-LAST:event_jtextNomeAltMedKeyReleased

    private void cbxOrderByMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrderByMedActionPerformed
        tableAltMed();
        btnAltMed.setEnabled(false);
    }//GEN-LAST:event_cbxOrderByMedActionPerformed

    private void btnAltMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltMedActionPerformed
        alterarMed();
    }//GEN-LAST:event_btnAltMedActionPerformed

    private void tblMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedMouseClicked
        if (tblMed.getSelectedRow() != -1) {

            m.setCodMed((String) MTM.getValueAt(tblMed.getSelectedRow(), 0));

            MedicamentosDao md = new MedicamentosDao();
            m = md.Verifica(m);
            MTM.removeall();
            MTM.addLinha(m);

            jareaDescAltMed.setText(m.getDescrição());
            jtextTipoAltMed.setText(m.getTipo());
            jtextQtndAltMed.setText(m.getQuantidade());
            if (jtextValorVendaAltMed.isEditable()) {
                jtextValorVendaAltMed.setText(m.getValorVenda());
            }

            btnAltMed.setEnabled(true);
        }
    }//GEN-LAST:event_tblMedMouseClicked

    private void jtextPesquisaCbxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextPesquisaCbxKeyReleased
        comboboxCNPJ();
    }//GEN-LAST:event_jtextPesquisaCbxKeyReleased

    private void jtextPesquisaNomeCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextPesquisaNomeCompraKeyReleased
        comboboxMed();
    }//GEN-LAST:event_jtextPesquisaNomeCompraKeyReleased

    private void cbxMedCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedCompraActionPerformed
        if (cbxMedCompra.getItemCount() != 0) {
            Valor();
        }
    }//GEN-LAST:event_cbxMedCompraActionPerformed

    private void jtextQtnCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextQtnCompraKeyReleased
        Valor();
    }//GEN-LAST:event_jtextQtnCompraKeyReleased

    private void jtextPesquisaCbxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextPesquisaCbxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comboboxCNPJ();
            cbxCnpjComp.requestFocus();
        }
    }//GEN-LAST:event_jtextPesquisaCbxKeyPressed

    private void cbxCnpjCompKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCnpjCompKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextPesquisaNomeCompra.requestFocus();
        }
    }//GEN-LAST:event_cbxCnpjCompKeyPressed

    private void jtextPesquisaNomeCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextPesquisaNomeCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comboboxMed();
            cbxMedCompra.requestFocus();
        }
    }//GEN-LAST:event_jtextPesquisaNomeCompraKeyPressed

    private void cbxMedCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxMedCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtextQtnCompra.requestFocus();
        }
    }//GEN-LAST:event_cbxMedCompraKeyPressed

    private void jtextQtnCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextQtnCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jtextQtnCompraKeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jformDataCompra.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        comprar();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void jformDataEntregaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jformDataEntregaCompraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isValidDate(jformDataEntregaCompra.getText()) != null) {
                comprar();
            }
        }
    }//GEN-LAST:event_jformDataEntregaCompraKeyPressed

    private void jformDataEntregaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jformDataEntregaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jformDataEntregaCompraActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu barCompras;
    private javax.swing.JMenu barDrog;
    private javax.swing.JMenu barLab;
    private javax.swing.JMenu barMed;
    private javax.swing.JMenu barUser;
    private javax.swing.JMenu barVendas;
    private javax.swing.JButton btnAlt;
    private javax.swing.JButton btnAltAtivar;
    private javax.swing.JButton btnAltAtivarLab;
    private javax.swing.JButton btnAltLab;
    private javax.swing.JButton btnAltMed;
    private javax.swing.JButton btnCadDrog;
    private javax.swing.JButton btnCadDrog1;
    private javax.swing.JButton btnCadMed;
    private javax.swing.JButton btnCadUser;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDelDelUser;
    private javax.swing.JButton btnEntrarLogin;
    private javax.swing.JButton btnPesquisaDelUser;
    private javax.swing.JComboBox<String> cbxCnpjComp;
    private javax.swing.JComboBox<String> cbxEstadoAltDrog;
    private javax.swing.JComboBox<String> cbxEstadoAltLab;
    private javax.swing.JComboBox<String> cbxEstadoCadDrog;
    private javax.swing.JComboBox<String> cbxEstadoCadLab;
    private javax.swing.JComboBox<String> cbxMedCompra;
    private javax.swing.JComboBox<String> cbxOrderByAltDrog;
    private javax.swing.JComboBox<String> cbxOrderByAltLab;
    private javax.swing.JComboBox<String> cbxOrderByDelUser;
    private javax.swing.JComboBox<String> cbxOrderByMed;
    private javax.swing.JComboBox<String> cbxStatusAltDrog;
    private javax.swing.JComboBox<String> cbxStatusAltLab;
    private javax.swing.JComboBox<String> cbxTipoUserCadUser;
    private javax.swing.JComboBox<String> cbxTipoUserDelUser;
    private javax.swing.ButtonGroup groupbrnAltDrog;
    private javax.swing.ButtonGroup groupbtnDelFun;
    private javax.swing.JMenuItem itemAltDrog;
    private javax.swing.JMenuItem itemAltLab;
    private javax.swing.JMenuItem itemCadDrog;
    private javax.swing.JMenuItem itemCadFun;
    private javax.swing.JMenuItem itemCadLab;
    private javax.swing.JMenuItem itemCadMed;
    private javax.swing.JMenuItem itemDelFun;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormDateCadUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jareaDescAltMed;
    private javax.swing.JTextArea jareaDescCadMed;
    private javax.swing.JFormattedTextField jformCEPAltDrog;
    private javax.swing.JFormattedTextField jformCEPAltLab;
    private javax.swing.JFormattedTextField jformCEPCadDrog;
    private javax.swing.JFormattedTextField jformCEPCadLab;
    private javax.swing.JFormattedTextField jformCNPJCadDrog;
    private javax.swing.JFormattedTextField jformCNPJCadLab;
    private javax.swing.JFormattedTextField jformDataCompra;
    private javax.swing.JFormattedTextField jformDataEntregaCompra;
    private javax.swing.JFormattedTextField jformInsEstCadLab;
    private javax.swing.JPasswordField jpassSenhaLogin;
    private javax.swing.JTextField jtextBairroAltDrog;
    private javax.swing.JTextField jtextBairroAltLab;
    private javax.swing.JTextField jtextBairroCadDrog;
    private javax.swing.JTextField jtextBairroCadLab;
    private javax.swing.JTextField jtextCNPJAltDrog;
    private javax.swing.JTextField jtextCNPJAltLab;
    private javax.swing.JTextField jtextCidadeAltDrog;
    private javax.swing.JTextField jtextCidadeAltLab;
    private javax.swing.JTextField jtextCidadeCadDrog;
    private javax.swing.JTextField jtextCidadeCadLab;
    private javax.swing.JTextField jtextComplementoAltDrog;
    private javax.swing.JTextField jtextComplementoAltLab;
    private javax.swing.JTextField jtextComplementoCadDrog;
    private javax.swing.JTextField jtextComplementoCadLab;
    private javax.swing.JTextField jtextEmailCadUser;
    private javax.swing.JTextField jtextEmailDelUser;
    private javax.swing.JTextField jtextIDAltDrog;
    private javax.swing.JTextField jtextIDAltLab;
    private javax.swing.JTextField jtextIDAltMed;
    private javax.swing.JTextField jtextInsEstAltLab;
    private javax.swing.JTextField jtextLoginCadUser;
    private javax.swing.JTextField jtextNomeAltDrog;
    private javax.swing.JTextField jtextNomeAltLab;
    private javax.swing.JTextField jtextNomeAltMed;
    private javax.swing.JTextField jtextNomeCadDrog;
    private javax.swing.JTextField jtextNomeCadLab;
    private javax.swing.JTextField jtextNomeCadMed;
    private javax.swing.JTextField jtextNomeCadUser;
    private javax.swing.JTextField jtextNumAltDrog;
    private javax.swing.JTextField jtextNumAltLab;
    private javax.swing.JTextField jtextNumCadDrog;
    private javax.swing.JTextField jtextNumCadLab;
    private javax.swing.JTextField jtextPesquisaCbx;
    private javax.swing.JTextField jtextPesquisaNomeCompra;
    private javax.swing.JTextField jtextQtnCompra;
    private javax.swing.JTextField jtextQtndAltMed;
    private javax.swing.JTextField jtextQtndCadMed;
    private javax.swing.JTextField jtextRuaAltDrog;
    private javax.swing.JTextField jtextRuaAltLab;
    private javax.swing.JTextField jtextRuaCadDrog;
    private javax.swing.JTextField jtextRuaCadLab;
    private javax.swing.JTextField jtextSenhaCadUser;
    private javax.swing.JTextField jtextTelAltCadUser;
    private javax.swing.JTextField jtextTelCelCadUser;
    private javax.swing.JTextField jtextTelResCadUser;
    private javax.swing.JTextField jtextTipoAltMed;
    private javax.swing.JTextField jtextTipoCadMed;
    private javax.swing.JTextField jtextUserDelUser;
    private javax.swing.JTextField jtextUserLog;
    private javax.swing.JTextField jtextValCusCadMed;
    private javax.swing.JTextField jtextValVenCadMed;
    private javax.swing.JTextField jtextValorVendaAltMed;
    private javax.swing.JLabel labelBairroAltDrog;
    private javax.swing.JLabel labelBairroAltLab;
    private javax.swing.JLabel labelBairroCadLab;
    private javax.swing.JLabel labelBemVindo;
    private javax.swing.JLabel labelCEPAltLab;
    private javax.swing.JLabel labelCEPCadLab;
    private javax.swing.JLabel labelCNPJAltDrog;
    private javax.swing.JLabel labelCNPJAltLab;
    private javax.swing.JLabel labelCNPJCadDrog;
    private javax.swing.JLabel labelCNPJCadLab;
    private javax.swing.JLabel labelCepAltDrog;
    private javax.swing.JLabel labelCidadeAltDrog;
    private javax.swing.JLabel labelCidadeAltLab;
    private javax.swing.JLabel labelCidadeCadLab;
    private javax.swing.JLabel labelCompAltDrog;
    private javax.swing.JLabel labelCompAltLab;
    private javax.swing.JLabel labelCompCadLab;
    private javax.swing.JLabel labelDataUltCompCadMed;
    private javax.swing.JLabel labelDateCadUser;
    private javax.swing.JLabel labelDescCadMed;
    private javax.swing.JLabel labelEmailCadUser;
    private javax.swing.JLabel labelEmailDelUser;
    private javax.swing.JLabel labelEstadoAltDrog;
    private javax.swing.JLabel labelEstadoAltLab;
    private javax.swing.JLabel labelEstadoCadDLab;
    private javax.swing.JLabel labelIDAltDrog;
    private javax.swing.JLabel labelIDAltLab;
    private javax.swing.JLabel labelIDAltLab1;
    private javax.swing.JLabel labelInsEstAltLab;
    private javax.swing.JLabel labelInsEstCadLab;
    private javax.swing.JLabel labelLogDelUser;
    private javax.swing.JLabel labelLoginCadUser;
    private javax.swing.JLabel labelNomeAltDrog;
    private javax.swing.JLabel labelNomeAltLab;
    private javax.swing.JLabel labelNomeAltLab1;
    private javax.swing.JLabel labelNomeCadDrog;
    private javax.swing.JLabel labelNomeCadDrog1;
    private javax.swing.JLabel labelNomeCadDrog2;
    private javax.swing.JLabel labelNomeCadDrog3;
    private javax.swing.JLabel labelNomeCadDrog4;
    private javax.swing.JLabel labelNomeCadDrog5;
    private javax.swing.JLabel labelNomeCadDrog6;
    private javax.swing.JLabel labelNomeCadDrog7;
    private javax.swing.JLabel labelNomeCadLab;
    private javax.swing.JLabel labelNomeCadMed;
    private javax.swing.JLabel labelNomeCadUser;
    private javax.swing.JLabel labelNumAltDrog;
    private javax.swing.JLabel labelNumAltLab;
    private javax.swing.JLabel labelNumCadLab;
    private javax.swing.JLabel labelOrderBy;
    private javax.swing.JLabel labelOrderByLab;
    private javax.swing.JLabel labelOrderByMed;
    private javax.swing.JLabel labelPesquisaAltDrog;
    private javax.swing.JLabel labelPesquisaAltLab;
    private javax.swing.JLabel labelPesquisaAltLab1;
    private javax.swing.JLabel labelQtndCadMed;
    private javax.swing.JLabel labelRuaAltDrog;
    private javax.swing.JLabel labelRuaAltLab;
    private javax.swing.JLabel labelRuaCadLab;
    private javax.swing.JLabel labelSenhaCadUser;
    private javax.swing.JLabel labelSenhaLog;
    private javax.swing.JLabel labelStatusAltDrog;
    private javax.swing.JLabel labelStatusLab;
    private javax.swing.JLabel labelTelAdCadUser;
    private javax.swing.JLabel labelTelCelCadUser;
    private javax.swing.JLabel labelTelResCadUser;
    private javax.swing.JLabel labelTipoCadMed;
    private javax.swing.JLabel labelTipoCadUser;
    private javax.swing.JLabel labelTipolDelUser;
    private javax.swing.JLabel labelUserLog;
    private javax.swing.JLabel labelValCusCadMed;
    private javax.swing.JLabel labelValMedicamento;
    private javax.swing.JLabel labelValVenCadMed;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel mainPainel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JRadioButton radioCresAltDrog;
    private javax.swing.JRadioButton radioCresAltLab;
    private javax.swing.JRadioButton radioCresAltMed;
    private javax.swing.JRadioButton radioCrescDelFun;
    private javax.swing.JRadioButton radioDescAltDrog;
    private javax.swing.JRadioButton radioDescAltLab;
    private javax.swing.JRadioButton radioDescAltMed;
    private javax.swing.JRadioButton radioDescDelFun;
    private javax.swing.JTable tblAltDrog;
    private javax.swing.JTable tblAltLab;
    private javax.swing.JTable tblDelUser;
    private javax.swing.JTable tblMed;
    private javax.swing.JPanel telaAltDrog;
    private javax.swing.JPanel telaAltLab;
    private javax.swing.JPanel telaAltMed;
    private javax.swing.JPanel telaCadDrog;
    private javax.swing.JPanel telaCadLab;
    private javax.swing.JPanel telaCadMed;
    private javax.swing.JPanel telaCadUser;
    private javax.swing.JPanel telaCompras;
    private javax.swing.JPanel telaDelUser;
    private javax.swing.JPanel telaHome;
    private javax.swing.JPanel telaLogin;
    private javax.swing.JPanel telaVendas;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="Configurações Da Janela">
    private void tela(String tela) {
        cl.show(mainPainel, tela);
        createAndShowGUI(tela);
        switch (tela) {
            case "Deletar Funcionários" ->
                radioDescDelFun.setSelected(true);
            case "Login" ->
                menuBar.setVisible(false);
            case "Cadastrar Drogarias" ->
                clearTxt();
            case "Alterar Drogarias" ->
                radioCresAltDrog.setSelected(true);
            case "Cadastrar Medicamentos" ->
                jareaDescCadMed.setLineWrap(true);
            case "Alterar Medicamentos" ->
                jareaDescAltMed.setLineWrap(true);
        }
    }

    private void tables() {
        tblDelUser.setModel(FTM);
        tblDelUser.getColumnModel().getColumn(0).setPreferredWidth(1);
        tblDelUser.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblDelUser.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblDelUser.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblDelUser.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblDelUser.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblDelUser.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblDelUser.getColumnModel().getColumn(7).setPreferredWidth(80);
        tblDelUser.getColumnModel().getColumn(8).setPreferredWidth(80);

        tblAltDrog.setModel(DTM);
        tblAltDrog.getColumnModel().getColumn(0).setPreferredWidth(1);
        tblAltDrog.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblAltDrog.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblAltDrog.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblAltDrog.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblAltDrog.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblAltDrog.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblAltDrog.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblAltDrog.getColumnModel().getColumn(8).setPreferredWidth(40);
        tblAltDrog.getColumnModel().getColumn(9).setPreferredWidth(1);

        tblAltLab.setModel(LTM);
        tblAltLab.getColumnModel().getColumn(0).setPreferredWidth(1);
        tblAltLab.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblAltLab.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblAltLab.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblAltLab.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblAltLab.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblAltLab.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblAltLab.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblAltLab.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblAltLab.getColumnModel().getColumn(9).setPreferredWidth(50);
        tblAltLab.getColumnModel().getColumn(10).setPreferredWidth(150);

        tblMed.setModel(MTM);
    }

    private void clearTxt() {
        txtLoginClear();
        txtCadFunClear();
        txtClearCadDrog();
    }

    public void configPage() {
        ImageIcon icon = new ImageIcon("");
        this.setIconImage(icon.getImage());
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamanhoTela);
        createAndShowGUI("Login");
        setVisible(true);
        documentacaoText();

    }

    private void createAndShowGUI(String title) {
        Font f = this.getFont();
        FontMetrics fm = this.getFontMetrics(f);
        int x = fm.stringWidth(title);
        int y = fm.stringWidth(" ");
        int z = this.getWidth() / 2 - (x / 2);
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        this.setTitle(pad + title);
        this.setLocationRelativeTo(null);
    }

    private void documentacaoText() {
        //Tela Login
        jtextUserLog.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.LOGIN));
        jpassSenhaLogin.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.SENHA));
        //Tela Cadastro de Usuarios
        jtextNomeCadUser.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextLoginCadUser.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.LOGIN));
        jtextSenhaCadUser.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.SENHA));
        jtextEmailCadUser.setDocument(new LimitaCaracteres(80, LimitaCaracteres.TipoEntrada.EMAIL));
        jtextTelAltCadUser.setDocument(new LimitaCaracteres(9, LimitaCaracteres.TipoEntrada.TELEFONE));
        jtextTelResCadUser.setDocument(new LimitaCaracteres(9, LimitaCaracteres.TipoEntrada.TELEFONE));
        jtextTelCelCadUser.setDocument(new LimitaCaracteres(9, LimitaCaracteres.TipoEntrada.TELEFONE));
        //Tela Deleção de Usuarios
        jtextUserDelUser.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.LOGIN));
        jtextEmailDelUser.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.EMAIL));
        //Tela Cadastro de Drogarias
        jtextNomeCadDrog.setDocument(new LimitaCaracteres(40, LimitaCaracteres.TipoEntrada.NOME));
        jtextCidadeCadDrog.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.NOME));
        jtextBairroCadDrog.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextRuaCadDrog.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.LOGIN));
        jtextComplementoCadDrog.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextNumCadDrog.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        //Tela Alteração de Drogaria
        jtextIDAltDrog.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        jtextCNPJAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.CNPJ));
        jtextNomeAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.NOME));
        jtextComplementoAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextRuaAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextNumAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        jtextCidadeAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.NOME));
        jtextBairroAltDrog.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.NOME));
        //Tela Cadastro de Laboratorio
        jtextNomeCadLab.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextCidadeCadLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.NOME));
        jtextBairroCadLab.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextRuaCadLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextNumCadLab.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        jtextComplementoCadLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.DESCRICAO));
        //Tela Alteração de Laboratorio
        jtextIDAltLab.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        jtextCNPJAltLab.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.CNPJ));
        jtextNomeAltLab.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextInsEstAltLab.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NUMERODECIMAL));
        jtextComplementoAltLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextRuaAltLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextNumAltLab.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        jtextCidadeAltLab.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.NOME));
        jtextBairroAltLab.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        //Tela Cadastro de Medicamentos
        jtextNomeCadMed.setDocument(new LimitaCaracteres(50, LimitaCaracteres.TipoEntrada.NOME));
        jtextTipoCadMed.setDocument(new LimitaCaracteres(80, LimitaCaracteres.TipoEntrada.NOME));
        jareaDescCadMed.setDocument(new LimitaCaracteres(250, LimitaCaracteres.TipoEntrada.DESCRICAO));
        jtextValCusCadMed.setDocument(new LimitaCaracteres(6, LimitaCaracteres.TipoEntrada.NUMERODECIMAL));
        jtextValVenCadMed.setDocument(new LimitaCaracteres(6, LimitaCaracteres.TipoEntrada.NUMERODECIMAL));
        jtextQtndCadMed.setDocument(new LimitaCaracteres(10, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
        //Tela Alteração de Medicamentos
        
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Login">
    private void entrar() {
        FuncionariosDao fd = new FuncionariosDao();
        String a = fd.verifica(txtLogin());
        if (null == a) {
            jtextUserLog.requestFocus();
            txtLoginClear();
        } else {
            switch (a) {
                case "Administrador" -> {
                    tela("Home");
                    labelBemVindo.setText(fd.Verifica(txtLogin()).getNome().toUpperCase());
                    menuBar.setVisible(true);
                    barUser.setVisible(true);
                    jtextValorVendaAltMed.setEditable(true);
                }
                case "Funcionario" -> {
                    tela("Home");
                    labelBemVindo.setText(fd.Verifica(txtLogin()).getNome().toUpperCase());
                    menuBar.setVisible(true);
                    barUser.setVisible(false);
                    jtextValorVendaAltMed.setEditable(false);
                }

            }
        }
    }

    private Funcionarios txtLogin() {
        Funcionarios f = new Funcionarios();
        f.setUser(jtextUserLog.getText().trim());
        f.setSenha(jpassSenhaLogin.getText().trim());
        return f;
    }

    private void txtLoginClear() {
        jtextUserLog.setText(null);
        jpassSenhaLogin.setText(null);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Cadastro de Usuarios">
    private Funcionarios txtCadFun() {
        Funcionarios f = new Funcionarios();

        f.setNome(jtextNomeCadUser.getText());
        f.setUser(jtextLoginCadUser.getText());
        f.setSenha(jtextSenhaCadUser.getText());
        f.setEmail(jtextEmailCadUser.getText());
        f.setTipoFunc((String) cbxTipoUserCadUser.getSelectedItem());
        f.setDataNasc(isValidDate(jFormDateCadUser.getText()));
        f.setFoneCel(jtextTelCelCadUser.getText());
        f.setFoneRes(jtextTelResCadUser.getText());
        f.setFoneAlt(jtextTelAltCadUser.getText());

        return f;
    }

    private void txtCadFunClear() {
        jtextNomeCadUser.setText(null);
        jtextLoginCadUser.setText(null);
        jtextSenhaCadUser.setText(null);
        jtextEmailCadUser.setText(null);
        jFormDateCadUser.setText(null);
        jtextTelAltCadUser.setText(null);
        jtextTelResCadUser.setText(null);
        jtextTelCelCadUser.setText(null);
    }

    private String isValidDate(String date2) {
        int day, month, year, yearNow;
        yearNow = LocalDate.now().getYear();
        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (!date2.equals("  /  /    ")) {
            String[] date = date2.split("/");
            day = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);
            String stringDate = year + "-" + month + "-" + day;
            if (month < 1 || month > 12) {
                jFormDateCadUser.setText(null);
                JOptionPane.showMessageDialog(null, "Mês Invalido");
            } else if (day < 1 || day > maxDays[month - 1]) {
                jFormDateCadUser.setText(null);
            } else if (year < 1923 || year > yearNow) {
                jFormDateCadUser.setText(null);
                JOptionPane.showMessageDialog(null, "Ano Invalido");
            } else {
                return stringDate;
            }
        }
        return null;
    }

    private void cadastrarFuncionario() {
        if (isValidDate(jFormDateCadUser.getText()) != null) {
            Funcionarios f = txtCadFun();
            FuncionariosDao fd = new FuncionariosDao();

            if (fd.adicionar(f)) {
                txtCadFunClear();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

            } else {
                txtCadFunClear();
                JOptionPane.showMessageDialog(null, "Já há um usuario Cadastrado");
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Deleção de Usuaios">
    private Funcionarios txtDelFun() {
        Funcionarios f = new Funcionarios();

        f.setUser(jtextUserDelUser.getText());
        f.setEmail(jtextEmailDelUser.getText());
        f.setTipoFunc((String) cbxTipoUserDelUser.getSelectedItem());

        return f;
    }

    private void tablePesquisa() {
        String order = null;
        String desc;
        FuncionariosDao fd = new FuncionariosDao();
        FTM.removeall();
        switch ((String) cbxOrderByDelUser.getSelectedItem()) {
            case "ID" -> {
                order = "ID_Func";
            }
            case "E-mail" -> {
                order = "Email";
            }
            case "Nome" -> {
                order = "Nome_Func";
            }
            case "Data de Nascimento" -> {
                order = "Data_Nasc";
            }
        }
        if (radioDescDelFun.isSelected()) {
            desc = "Desc";
        } else {
            desc = "";
        }
        FTM.addlist(fd.VerificaLike(txtDelFun(), order, desc));
    }

    private void btnDel() {
        btnDelDelUser.setEnabled(false);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Cadastro de Drogarias">
    private boolean viaCepCadDrog() {
        SolicitacaoCEP CEP = new SolicitacaoCEP();
        CEP cep = CEP.solicitarCEP(jformCEPCadDrog.getText().replace("-", ""));
        if (cep != null) {

            cbxEstadoCadDrog.setSelectedItem(cep.uf);
            jtextCidadeCadDrog.setText(cep.localidade);
            jtextBairroCadDrog.setText(cep.bairro);
            jtextRuaCadDrog.setText(cep.logradouro);

            return true;
        }
        return false;
    }

    private void cadastrarDrog() {
        DrogariasDao dd = new DrogariasDao();
        Drogarias d = txtCadDrog();
        d.setStatus("1");
        if (isCampValidCadDrog(d)) {
            dd.adicionar(d);
            clearTxt();
        } else {
            JOptionPane.showMessageDialog(null, "Há Campos para preencher");
        }
    }

    private boolean isCampValidCadDrog(Drogarias d) {
        if (d.getDrogaria().equals("")) {
            jtextNomeCadDrog.requestFocus();
            return false;
        } else if (d.getCNPJ().equals("  .   .   /    -  ")) {
            jformCNPJCadDrog.requestFocus();
            return false;
        } else if (d.getCEP().equals("     -   ")) {
            jformCEPCadDrog.requestFocus();
            return false;
        } else if (d.getEstado().equals("")) {
            cbxEstadoCadDrog.requestFocus();
            return false;
        } else if (d.getCidade().equals("")) {
            jtextCidadeCadDrog.requestFocus();
            return false;
        } else if (d.getBairro().equals("")) {
            jtextBairroCadDrog.requestFocus();
            return false;
        } else if (d.getRua().equals("")) {
            jtextRuaCadDrog.requestFocus();
            return false;
        } else if (d.getNumero().equals("")) {
            jtextNumCadDrog.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private Drogarias txtCadDrog() {
        Drogarias d = new Drogarias();

        d.setDrogaria(jtextNomeCadDrog.getText());
        d.setCNPJ(jformCNPJCadDrog.getText());
        d.setCEP(jformCEPCadDrog.getText());
        d.setEstado((String) cbxEstadoCadDrog.getSelectedItem());
        d.setCidade(jtextCidadeCadDrog.getText());
        d.setBairro(jtextBairroCadDrog.getText());
        d.setRua(jtextRuaCadDrog.getText());
        d.setComplemento(jtextComplementoCadDrog.getText());
        d.setNumero(jtextNumCadDrog.getText());

        return d;
    }

    private void txtClearCadDrog() {

        jtextNomeCadDrog.setText(null);
        jformCNPJCadDrog.setText(null);
        jformCEPCadDrog.setText(null);
        cbxEstadoCadDrog.setSelectedIndex(1);
        jtextCidadeCadDrog.setText(null);
        jtextBairroCadDrog.setText(null);
        jtextRuaCadDrog.setText(null);
        jtextComplementoCadDrog.setText(null);
        jtextNumCadDrog.setText(null);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Alteração de Drogarias">
    private void tableAltDrog() {
        DrogariasDao dd = new DrogariasDao();
        String status = "0";
        String desc;
        String order = "";
        switch ((String) cbxOrderByAltDrog.getSelectedItem()) {
            case "ID" ->
                order = "Id_Droga";
            case "CNPJ" ->
                order = "CNPJ_Droga";
            case "Nome" ->
                order = "Nome_Droga";
        }
        if (radioCresAltDrog.isSelected()) {
            desc = "";
        } else {
            desc = "Desc";
        }
        if ("Ativo".equals((String) cbxStatusAltDrog.getSelectedItem())) {
            status = "1";
        }
        DTM.addlist(dd.VerificaLike(txtAltDrogPesquisa(),
                jtextIDAltDrog.getText(),
                jtextCNPJAltDrog.getText(),
                jtextNomeAltDrog.getText(),
                status, order, desc));

    }

    private Drogarias txtAltDrogPesquisa() {
        d.setDrogaria(jtextNomeAltDrog.getText());
        d.setIDdroga(jtextIDAltDrog.getText());
        d.setCNPJ(jtextCNPJAltDrog.getText());

        return d;
    }

    private Drogarias txtAltDrog() {
        d.setCEP(jformCEPAltDrog.getText());
        d.setComplemento(jtextComplementoAltDrog.getText());
        d.setEstado((String) cbxEstadoAltDrog.getSelectedItem());
        d.setRua(jtextRuaAltDrog.getText());
        d.setNumero(jtextNumAltDrog.getText());
        d.setCidade(jtextCidadeAltDrog.getText());
        d.setBairro(jtextBairroAltDrog.getText());
        return d;
    }

    private void alterarDrog() {
        DrogariasDao dd = new DrogariasDao();
        if (dd.update(txtAltDrog())) {
            DTM.removeall();
            DTM.addLinha(dd.Verifica(d));
            btnAlt.setEnabled(false);
            btnAltAtivar.setEnabled(false);
            txtClearAltDrog();
        }
    }

    private void txtClearAltDrog() {
        jformCEPAltDrog.setText(null);
        jtextComplementoAltDrog.setText(null);
        jtextRuaAltDrog.setText(null);
        jtextNumAltDrog.setText(null);
        jtextCidadeAltDrog.setText(null);
        jtextBairroAltDrog.setText(null);
    }

    private boolean viaCepAltDrog() {
        SolicitacaoCEP CEP = new SolicitacaoCEP();
        CEP cep = CEP.solicitarCEP(jformCEPAltDrog.getText().replace("-", ""));
        if (cep != null) {

            cbxEstadoAltDrog.setSelectedItem(cep.uf);
            jtextCidadeAltDrog.setText(cep.localidade);
            jtextBairroAltDrog.setText(cep.bairro);
            jtextRuaAltDrog.setText(cep.logradouro);

            return true;
        }
        return false;
    }

    private void desativarAtivar() {
        if (btnAltAtivar.getText().equals("Ativar")) {
            d.setStatus("1");
        } else {
            d.setStatus("0");
        }

        DrogariasDao dd = new DrogariasDao();
        if (dd.updateStatus(d)) {
            DTM.removeall();
            btnAlt.setEnabled(false);
            btnAltAtivar.setEnabled(false);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Cadastro de Laboratórios">
    private boolean viaCepCadLab() {
        SolicitacaoCEP CEP = new SolicitacaoCEP();
        CEP cep = CEP.solicitarCEP(jformCEPCadLab.getText().replace("-", ""));
        if (cep != null) {

            cbxEstadoCadLab.setSelectedItem(cep.uf);
            jtextCidadeCadLab.setText(cep.localidade);
            jtextBairroCadLab.setText(cep.bairro);
            jtextRuaCadLab.setText(cep.logradouro);

            return true;
        }
        return false;
    }

    private void cadastrarLab() {
        LaboratoriosDao ld = new LaboratoriosDao();
        Laboratorios l = txtCadLab();
        l.setStatus("1");
        if (isCampValidCadLab(l)) {
            ld.adicionar(l);
            txtClearCadLab();
        } else {
            JOptionPane.showMessageDialog(null, "Há Campos para preencher");
        }
    }

    private boolean isCampValidCadLab(Laboratorios l) {
        if (l.getFornecedor().equals("")) {
            jtextNomeCadLab.requestFocus();
            return false;
        } else if (l.getCNPJ().equals("  .   .   /    -  ")) {
            jformCNPJCadLab.requestFocus();
            return false;
        } else if (l.getCEP().equals("     -   ")) {
            jformCEPCadLab.requestFocus();
            return false;
        } else if (l.getEstado().equals("")) {
            cbxEstadoCadLab.requestFocus();
            return false;
        } else if (l.getCidade().equals("")) {
            jtextCidadeCadLab.requestFocus();
            return false;
        } else if (l.getBairro().equals("")) {
            jtextBairroCadLab.requestFocus();
            return false;
        } else if (l.getRua().equals("")) {
            jtextRuaCadLab.requestFocus();
            return false;
        } else if (l.getNumero().equals("")) {
            jtextNumCadLab.requestFocus();
            return false;
        } else if (l.getInscriçãoEstadual().equals("   .   .   .   ")) {
            jformInsEstCadLab.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private Laboratorios txtCadLab() {
        Laboratorios l = new Laboratorios();

        l.setFornecedor(jtextNomeCadLab.getText());
        l.setCNPJ(jformCNPJCadLab.getText());
        l.setCEP(jformCEPCadLab.getText());
        l.setEstado((String) cbxEstadoCadLab.getSelectedItem());
        l.setCidade(jtextCidadeCadLab.getText());
        l.setBairro(jtextBairroCadLab.getText());
        l.setRua(jtextRuaCadLab.getText());
        l.setComplemento(jtextComplementoCadLab.getText());
        l.setNumero(jtextNumCadLab.getText());
        l.setInscriçãoEstadual(jformInsEstCadLab.getText());

        return l;
    }

    private void txtClearCadLab() {

        jtextNomeCadLab.setText(null);
        jformCNPJCadLab.setText(null);
        jformCEPCadLab.setText(null);
        cbxEstadoCadLab.setSelectedIndex(1);
        jtextCidadeCadLab.setText(null);
        jtextBairroCadLab.setText(null);
        jtextRuaCadLab.setText(null);
        jtextComplementoCadLab.setText(null);
        jtextNumCadLab.setText(null);
        jformInsEstCadLab.setText(null);

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Alteração de Laboratórios">
    private void tableAltLab() {
        LaboratoriosDao ld = new LaboratoriosDao();
        String status = "0";
        String desc;
        String order = "";
        switch ((String) cbxOrderByAltLab.getSelectedItem()) {
            case "ID" ->
                order = "Id_Lab";
            case "CNPJ" ->
                order = "CNPJ_Lab";
            case "Nome" ->
                order = "Nome_Lab";
            case "Inscrição Estadual" ->
                order = "Insc_Estadual";
        }
        if (radioCresAltLab.isSelected()) {
            desc = "";
        } else {
            desc = "Desc";
        }
        if ("Ativo".equals((String) cbxStatusAltLab.getSelectedItem())) {
            status = "1";
        }
        LTM.addlist(ld.VerificaLike(txtAltLabPesquisa(),
                jtextIDAltLab.getText(),
                jtextCNPJAltLab.getText(),
                jtextNomeAltLab.getText(),
                jtextInsEstAltLab.getText(),
                order, desc, status));

    }

    private Laboratorios txtAltLabPesquisa() {
        l.setFornecedor(jtextNomeAltLab.getText());
        l.setIdFornecedor(jtextIDAltLab.getText());
        l.setCNPJ(jtextCNPJAltLab.getText());
        l.setInscriçãoEstadual(jtextInsEstAltLab.getText());

        return l;
    }

    private Laboratorios txtAltLab() {
        l.setCEP(jformCEPAltLab.getText());
        l.setComplemento(jtextComplementoAltLab.getText());
        l.setEstado((String) cbxEstadoAltLab.getSelectedItem());
        l.setRua(jtextRuaAltLab.getText());
        l.setNumero(jtextNumAltLab.getText());
        l.setCidade(jtextCidadeAltLab.getText());
        l.setBairro(jtextBairroAltLab.getText());
        return l;
    }

    private void alterarLab() {
        LaboratoriosDao ld = new LaboratoriosDao();
        if (ld.update(txtAltLab())) {
            LTM.removeall();
            LTM.addLinha(ld.Verifica(l));
            btnAltLab.setEnabled(false);
            btnAltAtivarLab.setEnabled(false);
            txtClearAltLab();
        }
    }

    private void txtClearAltLab() {
        jformCEPAltLab.setText(null);
        jtextComplementoAltLab.setText(null);
        jtextRuaAltLab.setText(null);
        jtextNumAltLab.setText(null);
        jtextCidadeAltLab.setText(null);
        jtextBairroAltLab.setText(null);
    }

    private boolean viaCepAltLab() {
        SolicitacaoCEP CEP = new SolicitacaoCEP();
        CEP cep = CEP.solicitarCEP(jformCEPAltLab.getText().replace("-", ""));
        if (cep != null) {

            cbxEstadoAltLab.setSelectedItem(cep.uf);
            jtextCidadeAltLab.setText(cep.localidade);
            jtextBairroAltLab.setText(cep.bairro);
            jtextRuaAltLab.setText(cep.logradouro);

            return true;
        }
        return false;
    }

    private void desativarAtivarLab() {
        if (btnAltAtivarLab.getText().equals("Ativar")) {
            l.setStatus("1");
        } else {
            l.setStatus("0");
        }

        LaboratoriosDao ld = new LaboratoriosDao();
        if (ld.updateStatus(l)) {
            LTM.removeall();
            btnAltLab.setEnabled(false);
            btnAltAtivarLab.setEnabled(false);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Cadastro de Medicamentos">
    private void cadastrarMed() {
        if (isCamposValidMed()) {
            MedicamentosDao md = new MedicamentosDao();
            if (md.adicionar(txtCadMed())) {
                txtCadMedClear();
                jtextNomeCadMed.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos invalidos");
        }
    }

    private boolean isCamposValidMed() {
        if (jtextNomeCadMed.getText().equals("")) {
            jtextNomeCadMed.requestFocus();
            return false;
        } else if (jtextTipoCadMed.getText().equals("")) {
            jtextTipoCadMed.requestFocus();
            return false;
        } else if (jtextValCusCadMed.getText().equals("")) {
            jtextValCusCadMed.requestFocus();
            return false;
        } else if (jtextValVenCadMed.getText().equals("")) {
            jtextValVenCadMed.requestFocus();
            return false;
        } else if (jtextQtndCadMed.getText().equals("")) {
            jtextQtndCadMed.requestFocus();
            return false;
        }
        return true;
    }

    private Medicamentos txtCadMed() {
        Medicamentos m = new Medicamentos();

        m.setNomeMed(jtextNomeCadMed.getText());
        m.setTipo(jtextTipoCadMed.getText());
        m.setDescrição(jareaDescCadMed.getText());
        m.setValorCusto(jtextValCusCadMed.getText());
        m.setValorVenda(jtextValVenCadMed.getText());
        m.setDataUltCompra(isValidDate(jformDataCompra.getText()));
        m.setQuantidade(jtextQtndCadMed.getText());

        return m;
    }

    private void txtCadMedClear() {
        jtextNomeCadMed.setText(null);
        jtextTipoCadMed.setText(null);
        jareaDescCadMed.setText("");
        jtextValCusCadMed.setText(null);
        jtextValVenCadMed.setText(null);
        jformDataCompra.setText(null);
        jtextQtndCadMed.setText(null);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tela Alteração de Medicamentos">
    private void tableAltMed() {
        MedicamentosDao md = new MedicamentosDao();
        String desc;
        String order = "";
        switch ((String) cbxOrderByMed.getSelectedItem()) {

            case "ID" ->
                order = "Cod_Med";
            case "" ->
                order = "";
            case "Nome" ->
                order = "Nome_Med";
            /*case "" ->
                order = "";*/
        }
        if (radioCresAltMed.isSelected()) {
            desc = "";
        } else {
            desc = "Desc";
        }
        MTM.addList(md.VerificaLike(txtAltMedPesquisa(),
                jtextIDAltMed.getText(),
                jtextNomeAltMed.getText(),
                order, desc));

    }

    private Medicamentos txtAltMedPesquisa() {
        m.setCodMed(jtextIDAltMed.getText());
        m.setNomeMed(jtextNomeAltMed.getText());
        return m;
    }

    private void alterarMed() {
        MedicamentosDao md = new MedicamentosDao();
        if (md.update(txtAltMed())) {
            MTM.removeall();
            MTM.addLinha(md.Verifica(m));
            btnAltMed.setEnabled(false);
            txtClearMed();
        }
    }

    private Medicamentos txtAltMed() {
        m.setDescrição(jareaDescAltMed.getText());
        m.setTipo(jtextTipoAltMed.getText());
        m.setQuantidade(jtextQtndAltMed.getText());
        m.setValorVenda(jtextValorVendaAltMed.getText());

        return m;
    }

    private void txtClearMed() {
        jareaDescAltMed.setText(null);
        jtextTipoAltMed.setText(null);
        jtextQtndAltMed.setText(null);
        jtextValorVendaAltMed.setText(null);
        jtextIDAltMed.setText(null);
        jtextNomeAltMed.setText(null);
        cbxOrderByMed.setSelectedIndex(0);
    }
//</editor-fold>

    

//<editor-fold defaultstate="collapsed" desc="Tela Compra">
    private void comboboxCNPJ() {
        cbxCnpjComp.removeAllItems();
        ComprasDao cd = new ComprasDao();
        for (Object col : cd.comboboxCNPJ(jtextPesquisaCbx.getText())) {
            cbxCnpjComp.addItem((String) col);
        }
    }

    private void comboboxMed() {
        cbxMedCompra.removeAllItems();
        ComprasDao cd = new ComprasDao();
        for (Object col : cd.comboboxMedicamento(jtextPesquisaNomeCompra.getText())) {
            cbxMedCompra.addItem((String) col);
        }
    }

    private void Valor() {
        ComprasDao cd = new ComprasDao();
        String[] a = cbxMedCompra.getSelectedItem().toString().split(" - ");
        String cod = a[0];
        String valorUnitario = cd.Valor(cod);
        String qtn = jtextQtnCompra.getText();
        if ("".equals(jtextQtnCompra.getText())) {qtn = "0";}
        int numQtn = Integer.parseInt(qtn);
        double numValorUnitario = Double.parseDouble(valorUnitario);
        labelValMedicamento.setText(valorUnitario);
        labelValorTotal.setText(String.valueOf(numQtn * numValorUnitario));
    }

    private void comprar() {
        if (isCamposValidCompra()) {
            Compras c = txtCompras();
            ComprasDao cd = new ComprasDao();
            if (cd.inserir(c)) {
                txtClearCompra();
            }
        }
    }

    private Compras txtCompras() {
        Compras c = new Compras();
        String[] a = cbxMedCompra.getSelectedItem().toString().split(" - ");

        c.setCnpj_Lab((String) cbxCnpjComp.getSelectedItem());
        c.setCod_Med(a[1]);
        c.setQntd_Med(Integer.parseInt(jtextQtnCompra.getText()));
        c.setValor_Unit(labelValMedicamento.getText());
        c.setValorTotal(labelValorTotal.getText());
        c.setTotalNota_L(labelValorTotal.getText());
        c.setFormaPag_L((String) jComboBox3.getSelectedItem());
        c.setDataCompra_L(isValidDate(jformDataCompra.getText()));
        c.setDataEntega_L(isValidDate(jformDataEntregaCompra.getText()));

        return c;
    }

    private boolean isCamposValidCompra() {
        if (cbxCnpjComp.getSelectedItem() == null) {
            cbxCnpjComp.requestFocus();
            return false;
        } else if (cbxMedCompra.getSelectedItem() == null) {
            cbxMedCompra.requestFocus();
            return false;
        } else if (Integer.parseInt(jtextQtnCompra.getText()) <= 0) {
            jtextValCusCadMed.requestFocus();
            return false;
        } else if (jformDataCompra.getText().equals("")) {
            jtextValVenCadMed.requestFocus();
            return false;
        } else if (isValidDate(jformDataCompra.getText()) == null) {
            jformDataCompra.requestFocus();
            return false;
        } else if (isValidDate(jformDataEntregaCompra.getText()) == null) {
            jformDataEntregaCompra.requestFocus();
            return false;
        }
        return true;
    }

    private void txtClearCompra() {
        jtextPesquisaCbx.setText(null);
        jtextPesquisaNomeCompra.setText(null);
        jtextQtnCompra.setText("0");
        labelValMedicamento.setText(null);
        labelValorTotal.setText(null);
        jformDataCompra.setText(null);
        jformDataEntregaCompra.setText(null);
    }

//</editor-fold>
}
