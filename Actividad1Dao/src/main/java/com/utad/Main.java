package com.utad;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static  String PATH_FILE = "./src/main/java/com/utad/archivoXML";

    public static void main(String[] args) {

        List<Alumno> listaAlumnos = readXML();
        insertarAlumnos(listaAlumnos);
        imprimirConsola();
    }

    private static void imprimirConsola(){
        String query ="SELECT * FROM alumnos";
        try{
            Connection connection = Conexion.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                while (resultSet.next()){
                    System.out.println("\nNombre: " + resultSet.getString("nombre")
                            + "\nApellido: " + resultSet.getString("apellido")
                            + "\nDNI:" + resultSet.getString("dni")
                            + "\nCurso:" + resultSet.getString("curso"));
                }

            }else{
                System.out.println("No existe ningún registro ");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void insertarAlumnos(List<Alumno> listaDeAlumnos){
        String query = "INSERT INTO alumnos(nombre, apellido, dni,curso) VALUES (?, ?, ?, ?) ";
        int registros =0;
        try{
            Connection connection = Conexion.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            for(Alumno alumno: listaDeAlumnos){
                ps.setString(1, alumno.getNombre());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getDni());
                ps.setString(4, alumno.getCurso());
                ps.executeUpdate();
                registros++;
            }
            System.out.println("El total de registros son : " +registros);
        } catch (SQLException e) {
            System.err.println("Error al insertar alumnos o ya existen "+ e.getMessage());
        }



    }




    //lee y envia la lista de alumnos
    private static List<Alumno> readXML() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try {
            JAXBContext ctx = JAXBContext.newInstance(Alumnos.class);
            Unmarshaller um = ctx.createUnmarshaller();

            File folderPath = new File(PATH_FILE);
            Alumnos alumnos = (Alumnos) um.unmarshal(folderPath);

            listaAlumnos.addAll(alumnos.getAlumnos());
        } catch (JAXBException e) {
            throw new RuntimeException(e);

        }
        return listaAlumnos;
    }



}