package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Fornecedor {

    private Integer id;
    private Integer idEmpresa;
    private Integer idEstado;
    private Integer idCidade;
    private Integer idPlanoContas;
    private String tipoFornecedor;
    private String nome;
    private String razaoSocial;
    private String ie;
    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String fone;
    private String fax;
    private String email;
    private String obs;
    private Integer ativo;
    private static final String CODIGO_CIDADE_PADRAO = "1501402";
    // Atributos do sistema SGBR
    private String codigoCidade;
    private String rg;
    private String cpf;
    private String cnpj;

    public Fornecedor() {
        idEmpresa = 1;
        idPlanoContas = 0;
        tipoFornecedor = "Outros";
        fone = "(  )     -   ";
        fax = "(  )     -   ";
    }

    public String getNumero() {
        return numero.length() <= 10 ? numero : numero.substring(0, 10);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdPlanoContas() {
        return idPlanoContas;
    }

    public void setIdPlanoContas(Integer idPlanoContas) {
        this.idPlanoContas = idPlanoContas;
    }

    public String getTipo() {
        return getCnpjCpf().length() == 18 ? "J" : "F";
    }

    public String getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(String tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    public String getNome() {
        return nome.length() <= 80 ? nome : nome.substring(0, 80);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial.length() <= 80 ? razaoSocial : razaoSocial.substring(0, 80);
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpjCpf() {
        return !cpf.isEmpty() ? cpf : cnpj;
    }

    public String getIe() {
        String ieRg = !ie.isEmpty() ? ie : rg;
        return ieRg.length() <= 20 ? ieRg : ieRg.substring(0, 20);
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getEndereco() {
        return endereco.length() <= 80 ? endereco : endereco.substring(0, 80);
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro.length() <= 45 ? bairro : bairro.substring(0, 45);
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep.length() <= 20 ? cep : cep.substring(0, 20);
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email.length() <= 80 ? email.toLowerCase() : email.substring(0, 80).toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // retorna a cidade padrao para quando nao tem codigo de cidade CIDADE Belem-PA
    public String getCodigoCidade() {
        return !codigoCidade.isEmpty() ? codigoCidade : CODIGO_CIDADE_PADRAO;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
