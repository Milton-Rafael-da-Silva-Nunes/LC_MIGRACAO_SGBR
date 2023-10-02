package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemas.LC_SISTEMAS.model.entidades.Produto;
import sistemas.SGBR.model.dao.ProdutoDao;
import util.DataHoraUtil;
import util.ObjetoUtil;

/**
 *
 * @author supor
 */
public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public ProdutoDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }

    @Override
    public List<Produto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT * FROM testoque WHERE produto <> '' ORDER BY controle");
            rs = st.executeQuery();

            List<Produto> lista = new ArrayList<>();
            List<Produto> produtosNulos = new ArrayList<>();

            while (rs.next()) {
                Produto produto = instanciacaoProduto(rs);
                if (produto != null) {
                    lista.add(produto);
                } else {
                    // Produtos nulos
                    produtosNulos.add(produto);
                }
            }

            // Gerar log com produtos não migrados.
            String path = "C:/Users/supor/Documents/TESTE-PROGRAMA-JAVA-MIGRACAO/Produtos-não-migrados.txt";
            gerarTxtProdutosNulos(produtosNulos, path);
            
            return lista;
            
        } catch (SQLException e) {
            throw new DbException("Erro ao carregar lista de produtos em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Produto produto) {
        PreparedStatement st = null;
        
        try {
            st = conn2.prepareStatement("INSERT INTO produto(codigo, referencia, codigo_barras, nome, descricao, id_grupotributacao, id_categoria, id_cfop, id_cst, id_ncm, id_cest, id_fabricante, id_fornecedor, id_unidade, id_unidadeatacado2, id_unidadeatacado3, id_unidadeatacado4, id_unidadeembalagem, id_subcategoria, id_empresa, pode_desconto, pode_fracionado, pode_balanca, pode_lote, pode_comissao, pode_lerpeso, pode_atualizarncm, datahora_cadastro, datahora_alteracao, preco_compra, valor_compra, preco_custo, custo_medio, preco_venda, desconto_max, preco_venda2, qtd_minimapv2, desconto_max2, preco_venda3, qtd_minimapv3, desconto_max3, preco_venda4, qtd_minimapv4, desconto_max4, preco_antigo, valor_frete, ipi, preco_promocao, data_promocaoinicial, data_promocaofinal, comissao, comissao_valor, fidelidade_pontos, estoque, estoque_minimo, estoque_max, estoque_tara, qtd_embalagem, qtd_diasvalidade, peso_bruto, peso_liquido, tipo_produto, origem_produto, ex_tipi, ativo, observacoes, local, ref_cruzada1, ref_cruzada2, ref_cruzada3, ref_cruzada4, ref_cruzada5, ref_cruzada6, cod_ean, codigo_med, tipo_med, tabela_med, linha_med, ref_anvisa_med, portaria_med, rms_med, edicao_pharmacos, comb_cprodanp, comb_descanp, comb_percentualgaspetroleo, comb_percentualgasnaturalnacional, comb_percentualgasnaturalimportado, comb_valorpartida, med_classeterapeutica, med_unidademedida, med_usoprolongado, med_podeatualizar, med_precovendafpop, med_apresentacaofpop, trib_issaliqsaida, trib_icmsaliqsaida, trib_icmsaliqredbasecalcsaida, trib_icmsobs, trib_icmsfcpaliq, trib_ipisaida, trib_ipialiqsaida, trib_pissaida, trib_pisaliqsaida, trib_cofinssaida, trib_cofinsaliqsaida, trib_genero, imendes_codigointerno, imendes_produtonome) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setString(1, produto.getCodigo());
            st.setString(2, produto.getReferencia());
            st.setString(3, produto.getCodigoBarras());
            st.setString(4, produto.getNome());
            st.setString(5, produto.getDescricao());
            st.setInt(6, produto.getIdGrupoTributacao());
            st.setInt(7, produto.getIdCategoria());
            st.setInt(8, produto.getIdCfop());
            st.setInt(9, produto.getIdCst());
            st.setInt(10, produto.getIdNcm());
            st.setInt(11, produto.getIdCest());
            st.setInt(12, produto.getIdFabricante());
            st.setInt(13, produto.getIdFornecedor());
            st.setInt(14, produto.getIdUnidade());
            st.setInt(15, produto.getIdUnidadeAtacado2());
            st.setInt(16, produto.getIdUnidadeAtacado3());
            st.setInt(17, produto.getIdUnidadeAtacado4());
            st.setInt(18, produto.getIdUnidadeEmbalagem());
            st.setInt(19, produto.getIdSubcategoria());
            st.setInt(20, produto.getIdEmpresa());
            st.setString(21, produto.getPodeDesconto());
            st.setString(22, produto.getPodeFracionado());
            st.setString(23, produto.getPodeBalanca());
            st.setString(24, produto.getPodeLote());
            st.setString(25, produto.getPodeComissao());
            st.setString(26, produto.getPodeLerPeso());
            st.setString(27, produto.getPodeAtualizarNcm());
            st.setString(28, produto.getDataHoraCadastro());
            st.setString(29, DataHoraUtil.getDataHoraAtual());
            st.setDouble(30, produto.getPrecoCompra());
            st.setDouble(31, produto.getValorCompra());
            st.setDouble(32, produto.getPrecoCusto());
            st.setDouble(33, produto.getCustoMedio());
            st.setDouble(34, produto.getPrecoVenda());
            st.setDouble(35, produto.getDescontoMax());
            st.setDouble(36, produto.getPrecoVenda2());
            st.setDouble(37, produto.getQtdMinimaPv2());
            st.setDouble(38, produto.getDescontoMax2());
            st.setDouble(39, produto.getPrecoVenda3());
            st.setDouble(40, produto.getQtdMinimaPv3());
            st.setDouble(41, produto.getDescontoMax3());
            st.setDouble(42, produto.getPrecoVenda4());
            st.setDouble(43, produto.getQtdMinimaPv4());
            st.setDouble(44, produto.getDescontoMax4());
            st.setDouble(45, produto.getPrecoAntigo());
            st.setDouble(46, produto.getValorFrete());
            st.setString(47, produto.getIpi());
            st.setDouble(48, produto.getPrecoPromocao());
            st.setString(49, produto.getDataPromocaoInicial());
            st.setString(50, produto.getDataPromocaoFinal());
            st.setInt(51, produto.getComissao());
            st.setDouble(52, produto.getComissaoValor());
            st.setString(53, produto.getFidelidadePontos());
            st.setDouble(54, produto.getEstoque());
            st.setDouble(55, produto.getEstoqueMinimo());
            st.setDouble(56, produto.getEstoqueMax());
            st.setDouble(57, produto.getEstoqueTara());
            st.setDouble(58, produto.getQtdEmbalagem());
            st.setString(59, produto.getQtdDiasValidade());
            st.setDouble(60, produto.getPesoBruto());
            st.setDouble(61, produto.getPesoLiquido());
            st.setString(62, produto.getTipoProduto());
            st.setString(63, produto.getOrigemProduto());
            st.setString(64, produto.getExTipi());
            st.setInt(65, produto.getAtivo());
            st.setString(66, produto.getObservacoes());
            st.setString(67, produto.getLocal());
            st.setString(68, produto.getRefCruzada1());
            st.setString(69, produto.getRefCruzada2());
            st.setString(70, produto.getRefCruzada3());
            st.setString(71, produto.getRefCruzada4());
            st.setString(72, produto.getRefCruzada5());
            st.setString(73, produto.getRefCruzada6());
            st.setString(74, produto.getCodEan());
            st.setString(75, produto.getCodigoMed());
            st.setString(76, produto.getTipoMed());
            st.setString(77, produto.getTabelaMed());
            st.setString(78, produto.getLinhaMed());
            st.setString(79, produto.getRefAnvisaMed());
            st.setString(80, produto.getPortariaMed());
            st.setString(81, produto.getRmsMed());
            st.setString(82, produto.getEdicaoPharmacos());
            st.setString(83, produto.getCombCprodAnp());
            st.setString(84, produto.getCombDescAnp());
            st.setDouble(85, produto.getCombPercentualGasPetroleo());
            st.setDouble(86, produto.getCombPercentualGasNatuaralNacional());
            st.setDouble(87, produto.getCombPercentualGasNaturalImportado());
            st.setDouble(88, produto.getCombValorPartilha());
            st.setString(89, produto.getMedClasseTerapeutica());
            st.setString(90, produto.getMedUnidadeMedida());
            st.setString(91, produto.getMedUsoProlongado());
            st.setString(92, produto.getMedPodeAtualizar());
            st.setDouble(93, produto.getMedPrecoVendaFpop());
            st.setString(94, produto.getMedApresentacaoFpop());
            st.setDouble(95, produto.getTribIssAliqSaida());
            st.setDouble(96, produto.getTribIcmsAliqsaida());
            st.setDouble(97, produto.getTribIcmsAliqRedBaseCalcSaida());
            st.setString(98, produto.getTribIcmsObs());
            st.setDouble(99, produto.getTribIcmsfcpAliq());
            st.setString(100, produto.getTribIpiSaida());
            st.setDouble(101, produto.getTribIpiAliqSaida());
            st.setString(102, produto.getTribPisSaida());
            st.setDouble(103, produto.getTribPisAliqSaida());
            st.setString(104, produto.getTribCofinsSaida());
            st.setDouble(105, produto.getTribCofinsAliqSaida());
            st.setString(106, produto.getTriGenero());
            st.setString(107, ""); // IMENDES CODIGO
            st.setString(108, ""); // IMENDES PRODUTO NOME
            st.executeUpdate();
            System.out.println("PRODUTOS inserido: " + produto);
            
        } catch(SQLException e) {
            throw new DbException("Erro ao inserir produto em insert: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    private Produto instanciacaoProduto(ResultSet rs) throws SQLException {
        Produto obj = new Produto();
        obj.setCodigo(rs.getString("controle"));
        obj.setNome(rs.getString("produto"));
        obj.setCodigoBarras(rs.getString("codbarras"));
        obj.setPrecoCompra(rs.getDouble("precocusto"));
        obj.setValorCompra(rs.getDouble("precocusto"));
        obj.setPrecoCusto(rs.getDouble("precocusto"));
        obj.setPrecoVenda(rs.getDouble("precovenda"));
        obj.setPesoBruto(rs.getDouble("peso"));
        obj.setCustoMedio(rs.getDouble("customedio"));
        obj.setEstoqueMinimo(rs.getDouble("qtdeminima"));
        obj.setEstoqueMax(rs.getDouble("qtdemaxima"));
        obj.setEstoque(rs.getDouble("qtde"));
        obj.setAtivo(Integer.parseInt(ObjetoUtil.getAtivo(rs.getString("ativo"))));
        obj.setTribIpiSaida(rs.getString("codtributacaoipi"));
        obj.setTribPisSaida(rs.getString("codtributacaopis"));
        obj.setTribCofinsSaida(rs.getString("codtributacaocofins"));
        obj.setPodeBalanca(ObjetoUtil.getPodeBalanca(rs.getString("pesado")));
        obj.setTribIcmsAliqsaida(rs.getDouble("aliquotaicmsecf"));
        obj.setReferencia(rs.getString("referencia"));
        obj.setDescontoMax(rs.getDouble("percmaximodesconto"));
        obj.setComissao(rs.getInt("perccomissao"));
        obj.setPrecoVenda2(rs.getDouble("precominimo"));
        obj.setTribPisAliqSaida(rs.getDouble("percpis"));
        obj.setTribCofinsAliqSaida(rs.getDouble("perccofins"));
        obj.setTribIcmsAliqRedBaseCalcSaida(rs.getDouble("percreducaobc"));
        obj.setPrecoVenda3(rs.getDouble("precorevenda"));
        obj.setTribIpiAliqSaida(rs.getDouble("percipi"));
        obj.setCombCprodAnp(rs.getString("codigoanp"));
        obj.setCombDescAnp(rs.getString("descricaoanp"));
        obj.setCombPercentualGasPetroleo(rs.getDouble("percglpcomb"));
        obj.setCombPercentualGasNatuaralNacional(rs.getDouble("percgnncomb"));
        obj.setCombValorPartilha(rs.getDouble("valorpartidacomb"));
        obj.setRmsMed(rs.getString("codigoanvisa"));
        obj.setTribIcmsfcpAliq(rs.getDouble("aliquotafcp"));
        obj.setLocal(rs.getString("localizacao"));
        // PADRONIZACAO DE obj
        obj.setQtdMinimaPv2(0.0);
        obj.setQtdMinimaPv3(0.0);
        obj.setQtdMinimaPv4(0.0);
        obj.setDescontoMax2(0.0);
        obj.setDescontoMax3(0.0);
        obj.setDescontoMax4(0.0);
        obj.setPrecoVenda3(0.0);
        obj.setPrecoVenda4(0.0);
        obj.setPrecoAntigo(0.0);
        obj.setValorFrete(0.0);
        obj.setPrecoPromocao(0.0);
        obj.setComissaoValor(0.0);
        obj.setEstoqueTara(0.0);
        obj.setQtdEmbalagem(1.0);
        obj.setPesoLiquido(0.0);
        obj.setCombPercentualGasNaturalImportado(0.0);
        obj.setMedPrecoVendaFpop(0.0);
        obj.setTribIssAliqSaida(0.0);
        return obj;
    }

    private void gerarTxtProdutosNulos(List<Produto> produtosNulos, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Produto produto : produtosNulos) {
                writer.write("Produto --> " + produto.getCodigo() + " - " + produto.getNome() + "\n");
            }
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}
