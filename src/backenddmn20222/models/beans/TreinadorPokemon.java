
package backenddmn20222.models.beans;

/**
 *
 * @author ursul
 */
public class TreinadorPokemon {
    
    private int id;
    private int idPokemon;
    private int idTreinador;
    private String obs;
    private Treinador tre;
    private Pokemon pok;

    public TreinadorPokemon(int id) {
        this.id = id;
    }

    public TreinadorPokemon(String obs) {
        this.obs = obs;
    }

    public TreinadorPokemon(int idPokemon, int idTreinador, String obs) {
        this.idPokemon = idPokemon;
        this.idTreinador = idTreinador;
        this.obs = obs;
    }

    public TreinadorPokemon(int id, int idPokemon, int idTreinador, String obs) {
        this.id = id;
        this.idPokemon = idPokemon;
        this.idTreinador = idTreinador;
        this.obs = obs;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(int idTreinador) {
        this.idTreinador = idTreinador;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Treinador getTre() {
        return tre;
    }

    public void setTre(Treinador tre) {
        this.tre = tre;
    }

    public Pokemon getPok() {
        return pok;
    }

    public void setPok(Pokemon pok) {
        this.pok = pok;
    }

    @Override
    public String toString() {
        return "TreinadorPokemon{" + "id=" + id + ", idTreinador=" + idTreinador + ", idPokemon=" + idPokemon + ", obs=" + obs + '}';
    }
    
}
