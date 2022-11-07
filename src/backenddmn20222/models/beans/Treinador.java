
package backenddmn20222.models.beans;

/**
 *
 * @author ursul
 */
public class Treinador {
    
private int id;
    private String nome;
    private String cpf;

    public Treinador(int id) {
        this.id = id;
    }

    public Treinador(String nome) {
        this.nome = nome;
    }

    public Treinador(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Treinador(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Treinador{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + '}';
    }
    
    
    
}