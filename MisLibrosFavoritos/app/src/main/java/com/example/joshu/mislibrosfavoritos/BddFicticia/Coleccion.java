package com.example.joshu.mislibrosfavoritos.BddFicticia;

import java.util.ArrayList;

/**
 * Created by joshu on 11/12/2015.
 */
public class Coleccion {
    /*Una variable privada estatica ArrayList para almacenar los books
    ◦ Un metodo publico estatico para anadir un libro al ArrayList.
            ◦ Un metodo publico estatico que retorna el ArrayList.
            ◦ Con objeto de que inicialmente haya algun libro en la colección, se creara en la clase un bloque
    estatico que anada al ArrayList alguno de los books mostrados en las figuras.*/

    private static ArrayList<Book> books =new ArrayList<Book>();

    public static void addBook(Book l){
        books.add(l);
    }

    public static ArrayList<Book> getBooks(){
        return books;
    }

    public static void addDefaultBooks(){
        //Book(String título, String autor, String urlPortada, String sinopsis, int añoPublicación)
        books.add(new Book("Ofrenda a la tormenta","Dolores Redondo","http://image.casadellibro.com/a/l/t1/88/9788423348688.jpg",
                "Sinopsis \n" +
                "Ha pasado ya un mes desde que la inspectora de la Policía Foral recuperó a su hijo y pudo detener a Berasategui. Pero a pesar de que tanto la Guardia Civil como el juez Markina dan por muerta a Rosario, Amaia siente que no está libre de peligro, un desasosiego que sólo Jonan comprende.\n" +
                "La muerte súbita de una niña en Elizondo resulta sospechosa: el bebé tiene unas marcas rojizas en el rostro que indican que ha habido presión digital, y además, su padre intenta llevarse el cadáver. La bisabuela de la pequeña sostiene que la tragedia es obra de Inguma, el demonio que inmoviliza a los durmientes, se bebe su aliento y les arrebata la vida durante el sueño. Pero serán los análisis forenses del doctor San Martín los que convencen a Amaia\n" +
                "Salazar de investigar otras muertes de bebés, que pronto revelarán un rastro inaudito en el valle. " +
                "Berasategui muere, entonces, inexplicablemente en su celda, lo que despliega una trepidante " +
                "investigación que llevará a Amaia al auténtico origen de los sucesos que han asolado el valle de Baztán. " +
                "Y mientras, desde el bosque, una impresionante tormenta llega para sepultar la verdad más demoledora.", 2015));

        books.add(new Book("El umbral de la eternidad","Ken Follett","http://image.casadellibro.com/a/l/t0/96/9788401342196.jpg",
                "Sinopsis \n" +
                "En el año 1961 Rebecca Hoffman, profesora en Alemania del Este y nieta de lady Maud, descubrirá que la policía secreta está vigilándola mientras su hermano menor, Walli, sueña con huir a Occidente para convertirse en músico de rock. " +
                "George Jakes, joven abogado que trabaja con los hermanos Kennedy, es un activista del movimiento por los derechos civiles de los negros en Estados Unidos que participará en las protestas de los estados del Sur y en la marcha sobre Washington liderada por Martin Luther King. " +
                "En Rusia las inclinaciones políticas enfrentan a los hermanos Tania y Dimka Dvorkin. Este se convierte en una de las jóvenes promesas del Kremlin mientras su hermana entrará a formar parte de un grupo activista que promueve la insurrección.", 2014));

        books.add(new Book("El impostor","Javier Cercas","http://image.casadellibro.com/a/l/t0/23/9788439729723.jpg ",
                "Sinopsis \n" +
                "¿Quién es Enric Marco? Un nonagenario barcelonés que se hizo pasar por superviviente de los campos nazis y que fue desenmascarado en mayo de 2005, después de presidir durante tres años la asociación española de los supervivientes, pronunciar centenares de conferencias, conceder decenas de entrevistas, recibir importantes distinciones y conmover en algún caso hasta las lágrimas a los parlamentarios españoles reunidos para rendir homenaje por vez primera a los republicanos deportados por el III Reich. "+
                "El caso dio la vuelta al mundo y convirtió a Marco en el gran impostor y el gran maldito. Ahora, casi una década más tarde, Javier Cercas asedia, en este thriller hipnótico que es también un banquete con muchos platos -narración, crónica, ensayo, biografía y autobiografía-, el enigma del personaje, su verdad y sus falsedades y, a través de esa indagación que recorre casi un siglo de historia de España, bucea con una pasión de kamikaze y una honestidad desgarradora en lo más profundo de nosotros mismos: en nuestra infinita capacidad de autoengaño, en nuestro conformismo y nuestras mentiras, en nuestra sed insaciable de afecto, en nuestras necesidades contrapuestas de ficción y de realidad, en las zonas más dolorosas de nuestro pasado reciente.", 2014));

        books.add(new Book("Mi color favorito es verte","Pilar Eyre","http://static2.planetadelibros.com/usuaris/libros/fotos/172/tam_1/mi-color-favorito-es-verte_9788408134060.jpg",
                "Sinopsis \n" +
                "Pilar Eyre, una periodista madura y aún presa de una gran pasión por la vida, conoce, durante un verano en la Costa Brava, a Sébastien, un corresponsal de guerra francés de gran atractivo. Entre ellos surge un amor inesperado que los lleva a vivir tres días de intensa relación erótica y sentimental. Cuando Sébastien desaparece repentinamente, Pilar lo busca con desesperación siguiendo las pistas ambiguas que el periodista ha ido dejando a su paso, pero los resultados son cada vez más sorprendentes y misteriosos. Esta no es una bella historia de amor crepuscular, esta es una bella historia de amor entre una mujer que se atreve a llegar hasta el límite y un hombre secuestrado por unos sentimientos imprevistos. "+
                "Mi color favorito es verte es una aventura real. Acerquémonos de puntillas y miremos por el ojo de la cerradura: ahí dentro hay una mujer desnuda." , 2014));
    }
}
