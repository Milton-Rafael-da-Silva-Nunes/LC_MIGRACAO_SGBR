package sistemas.SGBR.model.dao.impl;

import conexaoDB.exception.DbException;
import conexaoDB.firebird.FirebirdConnector;
import conexaoDB.mysql.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        PreparedStatement st = null;

        mapaCidade = getMapaCidade();
        mapaEstado = getMapaEstado();

        try {
            st = conn2.prepareStatement("INSERT INTO cliente(cpf_cnpj, ie, ie_indicador, im, nome, rg, razao_social, endereco, numero, referencia, cep, bairro, telefone, tel_comercial, fax, limite_credito, obs, endereco2, numero2, referencia2, cep2, bairro2, ativo, tipo, id_pais, id_estado, id_cidade, id_estado2, id_cidade2, id_empresa, id_clientecanal, pai_adi, mae_adi, nascimento_adi, sexo_adi, estcivil_adi, apelido_adi, email_adi, id_cidades_adi, id_estados_adi, empresa, fone_emp, endereco_emp, numero_emp, cep_emp, bairro_emp, cargo_emp, renda_emp, admissao_emp, id_cidades_emp, id_estados_emp, conjuje, cpf_conj, rg_conj, nascimento_conj, empresa_conj, fone_conj, endereco_conj, numero_conj, cep_conj, bairro_conj, cargo_conj, renda_conj, admissao_conj, id_cidades_conj, id_estados_conj, referencias, comercial_1, comercial_2, comercial_3, bancaria_1, bancaria_2, emissao, orgao, data_cadastro, datahora_alteracao, foto, poupanca, pode_aprazo, pode_cartacobranca, numero_contrato, numero_cartao, tabela_preco, id_vendedor, filiacao_fonemae, filiacao_fonepai, filiacao_endereco, filiacao_referencia, filiacao_numero, filiacao_cep, filiacao_bairro, filiacao_idcidade, filiacao_idestado, avalista_nome, avalista_cpf, avalista_rg, avalista_nascimento, avalista_fone, avalista_endereco, avalista_numero, avalista_cep, avalista_bairro, avalista_empresa, avalista_cargo, avalista_renda, avalista_admissao, avalista_idcidade, avalista_idestado, isuf) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, cliente.getCpfCnpj());
            st.setString(2, cliente.getIe());
            st.setString(3, cliente.getIeIndicador());
            st.setString(4, cliente.getIm());
            st.setString(5, cliente.getNome());
            st.setString(6, cliente.getRg());
            st.setString(7, cliente.getRazaoSocial());
            st.setString(8, cliente.getEndereco());
            st.setString(9, cliente.getNumero());
            st.setString(10, cliente.getReferencia());
            st.setString(11, cliente.getCep());
            st.setString(12, cliente.getBairro());
            st.setString(13, cliente.getTelefone());
            st.setString(14, cliente.getTelComercial());
            st.setString(15, cliente.getFax());
            st.setDouble(16, cliente.getLimiteCredito());
            st.setString(17, cliente.getObs());
            st.setString(18, cliente.getEndereco2());
            st.setString(19, cliente.getNumero2());
            st.setString(20, cliente.getReferencia2());
            st.setString(21, cliente.getCep2());
            st.setString(22, cliente.getBairro2());
            st.setString(23, cliente.getAtivo());
            st.setString(24, cliente.getTipo());
            st.setInt(25, cliente.getIdPais());
            st.setString(26, mapaEstado.get(cliente.getCodigoCidade()));
            st.setString(27, mapaCidade.get(cliente.getCodigoCidade()));
            st.setString(28, mapaEstado.get(cliente.getCodigoCidade()));
            st.setString(29, mapaCidade.get(cliente.getCodigoCidade()));
            st.setInt(30, cliente.getIdEmpresa());
            st.setInt(31, cliente.getIdClienteCanal());
            st.setString(32, cliente.getPaiAdi());
            st.setString(33, cliente.getMaeAdi());
            st.setString(34, cliente.getNascimentoAdi());
            st.setString(35, cliente.getSexoAdi());
            st.setString(36, cliente.getEstCivilAdi());
            st.setString(37, cliente.getApelidoAdi());
            st.setString(38, cliente.getEmailAdi());
            st.setInt(39, cliente.getIdCidadesAdi());
            st.setInt(40, cliente.getIdEstadosAdi());
            st.setString(41, cliente.getEmpresa());
            st.setString(42, cliente.getFoneEmp());
            st.setString(43, cliente.getEnderecoEmp());
            st.setString(44, cliente.getNumeroEmp());
            st.setString(45, cliente.getCepEmp());
            st.setString(46, cliente.getBairroEmp());
            st.setString(47, cliente.getCargoEmp());
            st.setDouble(48, cliente.getRendaEmp());
            st.setString(49, cliente.getAdmissaoEmp());
            st.setInt(50, cliente.getIdCidadesEmp());
            st.setInt(51, cliente.getIdEstadosEmp());
            st.setString(52, cliente.getConjuje());
            st.setString(53, cliente.getCpfConj());
            st.setString(54, cliente.getRgConj());
            st.setString(55, cliente.getNascimentoConj());
            st.setString(56, cliente.getEmpresaConj());
            st.setString(57, cliente.getFoneConj());
            st.setString(58, cliente.getEnderecoConj());
            st.setString(59, cliente.getNumeroConj());
            st.setString(60, cliente.getCepConj());
            st.setString(61, cliente.getBairroConj());
            st.setString(62, cliente.getCargoConj());
            st.setDouble(63, cliente.getRendaConj());
            st.setString(64, cliente.getAdmissaoConj());
            st.setInt(65, cliente.getIdCidadesConj());
            st.setInt(66, cliente.getIdEstadosConj());
            st.setString(67, cliente.getReferencias());
            st.setString(68, cliente.getComercial1());
            st.setString(69, cliente.getComercial2());
            st.setString(70, cliente.getComercial3());
            st.setString(71, cliente.getBancaria1());
            st.setString(72, cliente.getBancaria2());
            st.setString(73, cliente.getEmissao());
            st.setString(74, cliente.getOrgao());
            st.setString(75, cliente.getDataCadastro());
            st.setString(76, DataHoraUtil.getDataHoraAtual());
            st.setString(77, cliente.getFoto());
            st.setDouble(78, cliente.getPoupanca());
            st.setString(79, cliente.getPodeAprazo());
            st.setString(80, cliente.getPodeCartaCobranca());
            st.setString(81, cliente.getNumeroContrato());
            st.setString(82, cliente.getNumeroCartao());
            st.setString(83, cliente.getTabelaPreco());
            st.setInt(84, cliente.getIdVendedor());
            st.setString(85, cliente.getFiliacaoFoneMae());
            st.setString(86, cliente.getFiliacaoFonePai());
            st.setString(87, cliente.getFiliacaoEndereco());
            st.setString(88, cliente.getFiliacaoReferencia());
            st.setString(89, cliente.getFiliacaoNumero());
            st.setString(90, cliente.getFiliacaoCep());
            st.setString(91, cliente.getFiliacaoBairro());
            st.setString(92, cliente.getFiliacaoIdCidade());
            st.setString(93, cliente.getFiliacaoIdEstado());
            st.setString(94, cliente.getAvalistaNome());
            st.setString(95, cliente.getAvalistaCpf());
            st.setString(96, cliente.getAvalistaRg());
            st.setString(97, cliente.getAvalistaNascimento());
            st.setString(98, cliente.getAvalistaFone());
            st.setString(99, cliente.getAvalistaEndereco());
            st.setString(100, cliente.getAvalistaNumero());
            st.setString(101, cliente.getAvalistaCep());
            st.setString(102, cliente.getAvalistaBairro());
            st.setString(103, cliente.getAvalistaEmpresa());
            st.setString(104, cliente.getAvalistaCargo());
            st.setDouble(105, cliente.getAvalistaRenda());
            st.setString(106, cliente.getAvalistaAdmissao());
            st.setInt(107, cliente.getAvalistaIdCidade());
            st.setInt(108, cliente.getAvalistaIdEstado());
            st.setString(109, cliente.getIsUf());
            int linhas = st.executeUpdate();
            System.out.println("CLIENTE inserido: " + cliente);

            // Logica para setar a ID do retorno do clientes inserido.
            if (linhas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    cliente.setId(id);
                }
                MysqlConnector.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado! \n\n\nNenhuma linha efetada!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException("Erro ao inserir clientes: " + e.getMessage());
        } finally {
            MysqlConnector.closeStatement(st);
        }
    }

    private Cliente instanciacaoCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNumeroCartao(ObjetoUtil.validarString(rs.getString("controle")));
        cliente.setRazaoSocial(ObjetoUtil.removerCaracteresEspeciais(rs.getString("cliente")));
        cliente.setEndereco(ObjetoUtil.removerCaracteresEspeciais(rs.getString("endereco")));
        cliente.setEndereco2(ObjetoUtil.removerCaracteresEspeciais(rs.getString("endereco")));
        cliente.setReferencia(ObjetoUtil.removerCaracteresEspeciais(rs.getString("complemento")));
        cliente.setReferencia2(ObjetoUtil.removerCaracteresEspeciais(rs.getString("complemento")));
        cliente.setBairro(ObjetoUtil.removerCaracteresEspeciais(rs.getString("bairro")));
        cliente.setBairro2(ObjetoUtil.removerCaracteresEspeciais(rs.getString("bairro")));
        cliente.setCep(ObjetoUtil.validarString(rs.getString("cep")));
        cliente.setCep2(ObjetoUtil.validarString(rs.getString("cep")));
        cliente.setTipo(ObjetoUtil.validarTipo(rs.getString("tipocliente")));
        cliente.setRg(ObjetoUtil.validarString(rs.getString("rg")));
        cliente.setCpf(ObjetoUtil.validarString(ObjetoUtil.corrigirCpfCnpjClienteLc(rs.getString("cpf"))));
        cliente.setCnpj(ObjetoUtil.validarString(ObjetoUtil.corrigirCpfCnpjClienteLc(rs.getString("cnpj"))));
        cliente.setIe(ObjetoUtil.validarString(rs.getString("ie")));
        cliente.setIm(ObjetoUtil.validarString(rs.getString("im")));
        cliente.setNascimentoAdi(rs.getString("datanascimento"));
        cliente.setDataCadastro(rs.getString("datahoracadastro"));
        cliente.setPaiAdi(ObjetoUtil.removerCaracteresEspeciais(rs.getString("pai")));
        cliente.setMaeAdi(ObjetoUtil.removerCaracteresEspeciais(rs.getString("mae")));
        cliente.setObs(ObjetoUtil.tamanhoObsCliente(ObjetoUtil.getObs(rs.getString("telefone"), rs.getString("celular"), "", rs.getString("obs"))));
        cliente.setEmailAdi(ObjetoUtil.validarString(rs.getString("email")));
        cliente.setAtivo(ObjetoUtil.getAtivo(rs.getString("ativo")));
        cliente.setNome(ObjetoUtil.validarNomeFantasia(rs.getString("cliente"), rs.getString("fantasia")));
        cliente.setLimiteCredito(ObjetoUtil.validarDouble(rs.getDouble("limitecredito")));
        cliente.setConjuje(ObjetoUtil.removerCaracteresEspeciais(rs.getString("nomeconjuge")));
        cliente.setNumero(ObjetoUtil.validarString(rs.getString("numero")));
        cliente.setNumero2(ObjetoUtil.validarString(rs.getString("numero")));
        cliente.setSexoAdi(ObjetoUtil.validarSexo(rs.getString("sexo")));
        cliente.setCodigoCidade(ObjetoUtil.validarString(rs.getString("codigocidadeibge")));
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
