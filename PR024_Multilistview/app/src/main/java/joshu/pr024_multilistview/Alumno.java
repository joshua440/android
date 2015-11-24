package joshu.pr024_multilistview;

/**
 * Created by joshu on 29/10/2015.
 */
public class Alumno {

    private String name,telefono;
    private int age;

    public Alumno(String name, String telefono, int age){
        this.name=name;
        this.telefono=telefono;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Alumno{"+"name='"+name+'\''+",telefono='"+telefono +'\''+",age="+age+'}';
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

}
