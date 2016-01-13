package joshu.practica1trim.Adapters;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by joshu on 29/10/2015.
 */
public class Contacto implements Parcelable {

    private String name,telefono,city,email;
    private int age;

    // Constructor.
    public Contacto(String name, String telefono, int age, String city, String email){
        this.name=name;
        this.telefono=telefono;
        this.age=age;
        this.city=city;
        this.email=email;
    }
    private Contacto(Parcel in) {
        readFromParcel(in);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Contacto{ name= " + name +", telefono= " + telefono +", city= " + city  +", email= " + email +", age= " + age +'}';
    }

    @Override
    public boolean equals(Object o) {
        boolean answer=false;
        if (this == o) {
            answer=true;
        } else if (o != null && o instanceof Contacto) {
            if (this.age == ((Contacto)o).age &&
                    this.name.equals(((Contacto)o).name) &&
                    this.telefono.equals(((Contacto)o).telefono) &&
                    this.city.equals(((Contacto)o).city) &&
                    this.email.equals(((Contacto)o).email)){
                answer=true;
            }
        }
        return answer;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + telefono.hashCode();
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Escribir las propiedades del objeto en un Parcel de destino.
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeString(telefono);
        dest.writeString(city);
        dest.writeString(email);
    }

    // Leer desde un Parcel las propiedades del objeto.
    void readFromParcel(Parcel in) {
        age = in.readInt();
        name = in.readString();
        telefono = in.readString();
        city = in.readString();
        email = in.readString();
    }

    // Creador del objeto Parcelable.
    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        // Crea un objeto Contacto a partir de un Parcel.
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        // Crea un array de alumnos del tamaño pasado como parámetro.
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };
}
