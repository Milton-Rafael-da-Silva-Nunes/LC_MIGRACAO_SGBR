package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import sistemas.LC_SISTEMAS.model.entidades.Cliente;
import sistemas.SGBR.model.dao.ClienteDao;
import util.DataHoraUtil;
import util.ObjetoUtil;

/**
 *
 * @author Rafael Nunes
 */
public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn1; // Firebird
    private Connection conn2; // Mysql

    public ClienteDaoJDBC(Connection conn1, Connection conn2) {
        this.conn1 = conn1;
        this.conn2 = conn2;
    }
    
    private TreeMap<String, String> mapaCidade;
    private TreeMap<String, String> mapaEstado;

    @Override
    public List<Cliente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn1.prepareStatement("SELECT * FROM tcliente WHERE cliente IS NOT NULL;");
            rs = st.executeQuery();

            List<Cliente> lista = new ArrayList<>();
            
            while (rs.next()) {
                Cliente cliente = instanciacaoCliente(rs);
                lista.add(cliente);
            }

            return lista;

        } catch (SQLException e) {
            throw new DbException("Error ao buscar clientes em findAll: " + e.getMessage());
        } finally {
            FirebirdConnector.closeStatement(st);
            FirebirdConnector.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Cliente cliente) {
        PreparedStatement pstm = null;
        
        mapaCidade = getMapaCidade();
        mapaEstado = getMapaEstado();
        
        try {
            pstm = conn2.prepareStatement("INSERT INTO cliente(cpf_cnpj, ie, ie_indicador, im, nome, rg, razao_social, endereco, numero, referencia, cep, bairro, telefone, tel_comercial, fax, limite_credito, obs, endereco2, numero2, referencia2, cep2, bairro2, ativo, tipo, id_pais, id_estado, id_cidade, id_estado2, id_cidade2, id_empresa, id_clientecanal, pai_adi, mae_adi, nascimento_adi, sexo_adi, estcivil_adi, apelido_adi, email_adi, id_cidades_adi, id_estados_adi, empresa, fone_emp, endereco_emp, numero_emp, cep_emp, bairro_emp, cargo_emp, renda_emp, admissao_emp, id_cidades_emp, id_estados_emp, conjuje, cpf_conj, rg_conj, nascimento_conj, empresa_conj, fone_conj, endereco_conj, numero_conj, cep_conj, bairro_conj, cargo_conj, renda_conj, admissao_conj, id_cidades_conj, id_estados_conj, referencias, comercial_1, comercial_2, comercial_3, bancaria_1, bancaria_2, emissao, orgao, data_cadastro, datahora_alteracao, foto, poupanca, pode_aprazo, pode_cartacobranca, numero_contrato, numero_cartao, tabela_preco, id_vendedor, filiacao_fonemae, filiacao_fonepai, filiacao_endereco, filiacao_referencia, filiacao_numero, filiacao_cep, filiacao_bairro, filiacao_idcidade, filiacao_idestado, avalista_nome, avalista_cpf, avalista_rg, avalista_nascimento, avalista_fone, avalista_endereco, avalista_numero, avalista_cep, avalista_bairro, avalista_empresa, avalista_cargo, avalista_renda, avalista_admissao, avalista_idcidade, avalista_idestado) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    
            pstm.setString(1, cliente.getCpfCnpj());
            pstm.setString(2, cliente.getIe());
            pstm.setString(3, cliente.getIeIndicador());
            pstm.setString(4, cliente.getIm());
            pstm.setString(5, cliente.getNome());
            pstm.setString(6, cliente.getRg());
            pstm.setString(7, cliente.getRazaoSocial());
            pstm.setString(8, cliente.getEndereco());
            pstm.setString(9, cliente.getNumero());
            pstm.setString(10, cliente.getReferencia());
            pstm.setString(11, cliente.getCep());
            pstm.setString(12, cliente.getBairro());
            pstm.setString(13, cliente.getTelefone());
            pstm.setString(14, cliente.getTelComercial());
            pstm.setString(15, cliente.getFax());
            pstm.setDouble(16, cliente.getLimiteCredito());
            pstm.setString(17, cliente.getObs());
            pstm.setString(18, cliente.getEndereco2());
            pstm.setString(19, cliente.getNumero2());
            pstm.setString(20, cliente.getReferencia2());
            pstm.setString(21, cliente.getCep2());
            pstm.setString(22, cliente.getBairro2());
            pstm.setString(23, cliente.getAtivo());
            pstm.setString(24, cliente.getTipo());
            pstm.setInt(25, cliente.getIdPais());
            pstm.setString(26, mapaEstado.get(cliente.getCodigoCidade()));
            pstm.setString(27, mapaCidade.get(cliente.getCodigoCidade()));
            pstm.setString(28, mapaEstado.get(cliente.getCodigoCidade()));
            pstm.setString(29, mapaCidade.get(cliente.getCodigoCidade()));
            pstm.setInt(30, cliente.getIdEmpresa());
            pstm.setInt(31, cliente.getIdClienteCanal());
            pstm.setString(32, cliente.getPaiAdi());
            pstm.setString(33, cliente.getMaeAdi());
            pstm.setString(34, cliente.getNascimentoAdi());
            pstm.setString(35, cliente.getSexoAdi());
            pstm.setString(36, cliente.getEstCivilAdi());
            pstm.setString(37, cliente.getApelidoAdi());
            pstm.setString(38, cliente.getEmailAdi());
            pstm.setInt(39, cliente.getIdCidadesAdi());
            pstm.setInt(40, cliente.getIdEstadosAdi());
            pstm.setString(41, cliente.getEmpresa());
            pstm.setString(42, cliente.getFoneEmp());
            pstm.setString(43, cliente.getEnderecoEmp());
            pstm.setString(44, cliente.getNumeroEmp());
            pstm.setString(45, cliente.getCepEmp());
            pstm.setString(46, cliente.getBairroEmp());
            pstm.setString(47, cliente.getCargoEmp());
            pstm.setDouble(48, cliente.getRendaEmp());
            pstm.setString(49, cliente.getAdmissaoEmp());
            pstm.setInt(50, cliente.getIdCidadesEmp());
            pstm.setInt(51, cliente.getIdEstadosEmp());
            pstm.setString(52, cliente.getConjuje());
            pstm.setString(53, cliente.getCpfConj());
            pstm.setString(54, cliente.getRgConj());
            pstm.setString(55, cliente.getNascimentoConj());
            pstm.setString(56, cliente.getEmpresaConj());
            pstm.setString(57, cliente.getFoneConj());
            pstm.setString(58, cliente.getEnderecoConj());
            pstm.setString(59, cliente.getNumeroConj());
            pstm.setString(60, cliente.getCepConj());
            pstm.setString(61, cliente.getBairroConj());
            pstm.setString(62, cliente.getCargoConj());
            pstm.setDouble(63, cliente.getRendaConj());
            pstm.setString(64, cliente.getAdmissaoConj());
            pstm.setInt(65, cliente.getIdCidadesConj());
            pstm.setInt(66, cliente.getIdEstadosConj());
            pstm.setString(67, cliente.getReferencias());
            pstm.setString(68, cliente.getComercial1());
            pstm.setString(69, cliente.getComercial2());
            pstm.setString(70, cliente.getComercial3());
            pstm.setString(71, cliente.getBancaria1());
            pstm.setString(72, cliente.getBancaria2());
            pstm.setString(73, cliente.getEmissao());
            pstm.setString(74, cliente.getOrgao());
            pstm.setString(75, cliente.getDataCadastro());
            pstm.setString(76, DataHoraUtil.getDataHoraAtual());
            pstm.setString(77, cliente.getFoto());
            pstm.setDouble(78, cliente.getPoupanca());
            pstm.setString(79, cliente.getPodeAprazo());
            pstm.setString(80, cliente.getPodeCartaCobranca());
            pstm.setString(81, cliente.getNumeroContrato());
            pstm.setString(82, cliente.getNumeroCartao());
            pstm.setString(83, cliente.getTabelaPreco());
            pstm.setInt(84, cliente.getIdVendedor());
            pstm.setString(85, cliente.getFiliacaoFoneMae());
            pstm.setString(86, cliente.getFiliacaoFonePai());
            pstm.setString(87, cliente.getFiliacaoEndereco());
            pstm.setString(88, cliente.getFiliacaoReferencia());
            pstm.setString(89, cliente.getFiliacaoNumero());
            pstm.setString(90, cliente.getFiliacaoCep());
            pstm.setString(91, cliente.getFiliacaoBairro());
            pstm.setString(92, cliente.getFiliacaoIdCidade());
            pstm.setString(93, cliente.getFiliacaoIdEstado());
            pstm.setString(94, cliente.getAvalistaNome());
            pstm.setString(95, cliente.getAvalistaCpf());
            pstm.setString(96, cliente.getAvalistaRg());
            pstm.setString(97, cliente.getAvalistaNascimento());
            pstm.setString(98, cliente.getAvalistaFone());
            pstm.setString(99, cliente.getAvalistaEndereco());
            pstm.setString(100, cliente.getAvalistaNumero());
            pstm.setString(101, cliente.getAvalistaCep());
            pstm.setString(102, cliente.getAvalistaBairro());
            pstm.setString(103, cliente.getAvalistaEmpresa());
            pstm.setString(104, cliente.getAvalistaCargo());
            pstm.setDouble(105, cliente.getAvalistaRenda());
            pstm.setString(106, cliente.getAvalistaAdmissao());
            pstm.setInt(107, cliente.getAvalistaIdCidade());
            pstm.setInt(108, cliente.getAvalistaIdEstado());
            pstm.executeUpdate();
            System.out.println("CLIENTE INSERIDO: " + cliente);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException("Erro ao inserir clientes: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(pstm);
        }
    }

    private Cliente instanciacaoCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNumeroCartao(rs.getString("controle"));
        cliente.setRazaoSocial(rs.getString("cliente"));
        cliente.setEndereco(ObjetoUtil.validarString(rs.getString("endereco")));
        cliente.setEndereco2(ObjetoUtil.validarString(rs.getString("endereco")));
        cliente.setReferencia(ObjetoUtil.validarString(rs.getString("complemento")));
        cliente.setReferencia2(ObjetoUtil.validarString(rs.getString("complemento")));
        cliente.setBairro(ObjetoUtil.validarString(rs.getString("bairro")));
        cliente.setBairro2(ObjetoUtil.validarString(rs.getString("bairro")));
        cliente.setCep(ObjetoUtil.validarString(rs.getString("cep")));
        cliente.setCep2(ObjetoUtil.validarString(rs.getString("cep")));
        cliente.setTipo(ObjetoUtil.validarTipo(rs.getString("tipocliente")));
        cliente.setRg(ObjetoUtil.validarString(rs.getString("rg")));
//        cliente.setCpfCnpj(ObjetoUtil.corrigirCpfCnpjClienteLc(ObjetoUtil.validarCpfCnpj(rs.getString("cpf"), rs.getString("cnpj"))));
        cliente.setIe(ObjetoUtil.validarString(rs.getString("ie")));
        cliente.setIm(ObjetoUtil.validarString(rs.getString("im")));
        cliente.setNascimentoAdi(rs.getString("datanascimento"));
        cliente.setDataCadastro(rs.getString("datahoracadastro"));
        cliente.setPaiAdi(ObjetoUtil.validarString(rs.getString("pai")));
        cliente.setMaeAdi(ObjetoUtil.validarString(rs.getString("mae")));
        cliente.setObs(ObjetoUtil.tamanhoObsCliente(ObjetoUtil.getObs(rs.getString("telefone"), rs.getString("celular"), "", rs.getString("obs"))));
        cliente.setEmailAdi(ObjetoUtil.validarString(rs.getString("email")));
        cliente.setAtivo(ObjetoUtil.getAtivo(rs.getString("ativo")));
        cliente.setNome(ObjetoUtil.validarNomeFantasia(rs.getString("cliente"), rs.getString("fantasia")));
        cliente.setLimiteCredito(rs.getDouble("limitecredito"));
        cliente.setConjuje(ObjetoUtil.validarString(rs.getString("nomeconjuge")));
        cliente.setNumero(ObjetoUtil.validarString(rs.getString("numero")));
        cliente.setNumero2(ObjetoUtil.validarString(rs.getString("numero")));
        cliente.setSexoAdi(ObjetoUtil.validarSexo(rs.getString("sexo")));
        cliente.setCodigoCidade(rs.getString("codigocidadeibge"));
        return cliente;
    }
    
    private TreeMap<String, String> getMapaCidade() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap();

        try {
            st = conn2.prepareStatement("select id, codigocidade from cidades");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("codigocidade"), rs.getString("id"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            MysqlConnector.closeResultSet(rs);
            MysqlConnector.closeStatement(st);
        }
        return map;
    }
    
    private TreeMap<String, String> getMapaEstado() {
        PreparedStatement st = null;
        ResultSet rs = null;
        TreeMap<String, String> map = new TreeMap();

        try {
            st = conn2.prepareStatement("select (select e.id from estados e where e.iduf = c.iduf)as id_estado, c.codigocidade from cidades c");
            rs = st.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("codigocidade"), rs.getString("id_estado"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            MysqlConnector.closeResultSet(rs);
            MysqlConnector.closeStatement(st);
        }
        return map;
    }
}
