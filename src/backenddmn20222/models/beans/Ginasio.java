
package backenddmn20222.models.beans;

/**
 *
 * @author ursul
 */
public class Ginasio {
    
private int id;
    private String estado;
    private String pais;

    public Ginasio(int id) {
        this.id = id;
    }

    public Ginasio(String estado) {
        this.estado = estado;
    }

    public Ginasio(String estado, String pais) {
        this.estado = estado;
        this.pais = pais;
    }

    public Ginasio(int id, String estado, String pais) {
        this.id = id;
        this.estado = estado;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Ginasio{" + "id=" + id + ", estado=" + estado + ", pais=" + pais + '}';
    }
    
    
    
}
