package sistemas.LC_SISTEMAS.model.entidades;

/**
 *
 * @author supor
 */
public class Fornecedor {
    
    private Integer id;
    private String razaoSocial;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private String rg;
    private String cpfCnpj;
    private String ie;
    private String obs;
    private String email;
    private String numero;
    private Integer ativo;
    private String codigoCidade;

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String razaoSocial, String nome, String endereco, String bairro, String cep, String rg, String cpfCnpj, String ie, String obs, String email, String numero, Integer ativo, String codigoCidade) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.ie = ie;
        this.obs = obs;
        this.email = email;
        this.numero = numero;
        this.ativo = ativo;
        this.codigoCidade = codigoCidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public String getCodigoCidade() {
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
