
package backenddmn20222.models.beans;

/**
 *
 * @author ursul
 */
public class Pokemon {
    
private int id;
    private String nome;
    private String tipo;

    public Pokemon(int id) {
        this.id = id;
    }

    public Pokemon(String nome) {
        this.nome = nome;
    }

    public Pokemon(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Pokemon(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setObs(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", nome=" + nome + ", obs=" + tipo + '}';
    }
    
    
    
}
