package joshu.pr015;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by joshu on 23/10/2015.
 */
public class Alumno implements Parcelable {

    private String dni, nombre, sexo;
    private int edad;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {  this.edad = edad;   }

    public String getSexo() { return sexo;  }

    public void setSexo(String sexo) {  this.sexo = sexo;  }

    public Alumno(){
    }

    protected Alumno(Parcel in) {
        dni = in.readString();
        nombre = in.readString();
        sexo = in.readString();
        edad = in.readInt();
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dni);
        dest.writeString(nombre);
        dest.writeString(sexo);
        dest.writeInt(edad);
    }
}
