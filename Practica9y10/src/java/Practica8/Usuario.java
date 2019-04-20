/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.io.Serializable;
/**
 *
 * @author michelle
 */
public class Usuario extends Object implements Serializable{
    private String nombre;
    private String contrasena;
    private String correo;
    private String fechaDeNacimiento;
    private String id;
    
    public Usuario(String username, String email,String password, String FechaDeNacimiento ){
        this.contrasena= password;
        this.nombre= username;
        this.correo= email;
        this.fechaDeNacimiento= FechaDeNacimiento;
    }
    
    public Usuario(String id, String username, String email,String password, String FechaDeNacimiento ){
        this.contrasena= password;
        this.nombre= username;
        this.correo= email;
        this.fechaDeNacimiento= FechaDeNacimiento;
        this.id= id;
    }
    
    public Usuario(){
        
    }
    
    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Nombre: " + this.getNombre() + ", Correo: " + this.getCorreo() + ", Contraseña: " + this.getContrasena() + ", FechaDeNacimiento: " + this.getFechaDeNacimiento();
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
}
