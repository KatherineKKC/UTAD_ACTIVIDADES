package com.utad;
import javax.xml.bind.annotation.XmlElement;
public class Alumno {
    //ATRIBUTOS
    private String nombre;
    private String apellido;
    private String dni;
    private String curso;


    //METODOS GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    @XmlElement
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    @XmlElement
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCurso() {
        return curso;
    }
    @XmlElement
    public void setCurso(String curso) {
        this.curso = curso;
    }

}
