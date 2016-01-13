package joshu.practica1trim.Adapters;

import java.util.ArrayList;

/**
 * Created by joshu on 11/12/2015.
 */
public class ContactoList {

    private static ArrayList<Contacto> list =new ArrayList<Contacto>();

    public static void addContacto(Contacto c){
        //Uso el metodo add para quitarme duplicados
        if (!list.contains(c)){
            list.add(c);
        }
    }

    public static ArrayList<Contacto> getList(){
        return list;
    }

    public static void addDefaultContactos(){
        //Contacto(String name, String telefono, int age, String city, String email)
        //los agrego con add porque al girar se crea una y otra vez y creceria solo por girar
        ContactoList.addContacto(new Contacto("Joshua", "754325453", 27, "Los Barrios", "joshua@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Cristina", "785452453", 20, "La Linea", "cristina@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Joaquin", "354123453k", 25, "Cordoba", "joaquin@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Ivan", "786543453", 23, "La Linea", "ivan@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Pablo", "321345453", 29, "Algeciras", "pablo@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Gabriel", "453128453", 21, "Algeciras", "gabriel@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Manuel", "156345453", 24, "Algeciras", "manuel@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Alejandro", "315478453", 22, "Jimena", "alejandro@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Ismael", "654345453", 24, "Desconocido", "ismael@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Otro Ivan", "315153453", 26, "Desconocido", "otroIvan@emailfalso.com"));
        ContactoList.addContacto(new Contacto("Otro Alejandro", "31375453", 28, "Desconocido", "otroAlejandro@emailfalso.com"));
    }
}
