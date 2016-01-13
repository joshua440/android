package com.example.joshu.mislibrosfavoritos.BddFicticia;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by joshu on 11/12/2015.
 */
public class Book implements Parcelable {

    private String título, autor, urlPortada,sinopsis;
    private int añoPublicación;

    public Book(String título, String autor, String urlPortada, String sinopsis, int añoPublicación) {
        this.título = título;
        this.autor = autor;
        this.urlPortada = urlPortada;
        this.sinopsis = sinopsis;
        this.añoPublicación = añoPublicación;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getAñoPublicación() {
        return añoPublicación;
    }

    public void setAñoPublicación(int añoPublicación) {
        this.añoPublicación = añoPublicación;
    }

    @Override
    public String toString() {
        return "Book{" + "título= " + título +", autor= " + autor + ", urlPortada= " + urlPortada + ", sinopsis= " + sinopsis + ", añoPublicación=" + añoPublicación + '}';
    }

    protected Book(Parcel in) {
        título = in.readString();
        autor = in.readString();
        urlPortada = in.readString();
        sinopsis = in.readString();
        añoPublicación = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(título);
        dest.writeString(autor);
        dest.writeString(urlPortada);
        dest.writeString(sinopsis);
        dest.writeInt(añoPublicación);
    }
}
