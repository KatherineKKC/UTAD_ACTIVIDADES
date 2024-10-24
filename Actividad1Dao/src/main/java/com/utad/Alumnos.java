package com.utad;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alumnos")
public class Alumnos {

    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @XmlElement(name = "alumno")
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
