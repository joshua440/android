package joshu.pr021;

/**
 * Created by joshu on 06/11/2015.
 */
public class Alumno {

    private String name,telefono;
    private int age;

    public Alumno(String name, String telefono){
        this.name=name;
        this.telefono=telefono;
    }

    @Override
    public String toString() {
        return "Alumno{"+"name='"+name+'\''+",telefono='"+telefono +'\''+",age="+age+'}';
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
