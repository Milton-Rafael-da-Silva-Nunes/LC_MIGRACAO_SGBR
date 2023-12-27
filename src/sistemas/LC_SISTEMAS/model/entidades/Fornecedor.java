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
    // Atributos do sistema SGBR
    private String codigoCidade;
    private String rg;
    private String cpf;
    private String cnpj;

    public Fornecedor() {
        tipoFornecedor = "Outros";
        fone = "(  )     -   ";
        fax = "(  )     -   ";
    }

    public Fornecedor(Integer id, Integer idEmpresa, Integer idEstado, Integer idCidade, Integer idPlanoContas, String tipoFornecedor, String nome, String razaoSocial, String ie, String endereco, String numero, String bairro, String cep, String fone, String fax, String email, String obs, Integer ativo, String codigoCidade, String rg, String cpf, String cnpj) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idEstado = idEstado;
        this.idCidade = idCidade;
        this.idPlanoContas = idPlanoContas;
        this.tipoFornecedor = tipoFornecedor;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.ie = ie;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.fone = fone;
        this.fax = fax;
        this.email = email;
        this.obs = obs;
        this.ativo = ativo;
        this.codigoCidade = codigoCidade;
        this.rg = rg;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public String getNumero() {
        if (numero.length() > 10) {
            return numero.substring(0, 10);
        }
        return numero;
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
        if(getCnpjCpf().length()==18) {
            return "J";
        } else {
            return "F";
        }
    }

    public String getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(String tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpjCpf() {
        if(!cpf.isEmpty()) {
            return cpf;
        } else {
            return cnpj;
        }
    }
    
    public String getIe() {
        if (!ie.isEmpty()) {
            return ie;
        } else {
            return rg;
        }
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
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
        return email.toLowerCase();
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

    public String getCodigoCidade() {
        if (codigoCidade == null || codigoCidade.equals("")) {
            return "1501402"; // CIDADE Belem-PA
        }
        return codigoCidade;
    }

    public void setCodigoCidade(String codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
