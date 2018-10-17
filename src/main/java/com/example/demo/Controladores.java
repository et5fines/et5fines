package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Noticia;
import model.Novedad;

@Controller
public class Controladores{
	@GetMapping("/")
	public static String inicio(Model template) throws SQLException {
		
		Connection connection;
        connection = DriverManager.getConnection(Settings.db_url,Settings.db_user, Settings.db_password);   
        PreparedStatement ps = connection.prepareStatement("SELECT titulo, subtitulo, cuerpo, fecha FROM noticias order by id desc LIMIT 10;" );  
        ResultSet resultado =  ps.executeQuery();
        
        ArrayList<Noticia> listaNoticias;
        listaNoticias = new ArrayList<Noticia>();
        
        while(resultado.next()) {
        	
        	Noticia noticia = new Noticia(resultado.getString("titulo"),resultado.getString("subtitulo"),
        			resultado.getString("cuerpo"),resultado.getString("fecha"));
        	
       listaNoticias.add(noticia);
       
        }
        
        template.addAttribute("listaDeNoticias",listaNoticias);
		
		
	return "inicio";
	}

	@GetMapping("/alumnos")
public static String alumnos(Model template) throws SQLException {
		
		Connection connection;
        connection = DriverManager.getConnection(Settings.db_url,Settings.db_user, Settings.db_password);   
        PreparedStatement ps = connection.prepareStatement("SELECT titulo, subtitulo, cuerpo, fecha FROM novedades order by id desc LIMIT 10;" );  
        ResultSet resultado =  ps.executeQuery();
        
        ArrayList<Novedad> listaNovedades;
        listaNovedades = new ArrayList<Novedad>();
        
        while(resultado.next()) {
        	
        	Novedad novedad = new Novedad(resultado.getString("titulo"),resultado.getString("subtitulo"),
        			resultado.getString("cuerpo"),resultado.getString("fecha"));
        	
       listaNovedades.add(novedad);
       
        }
        
        template.addAttribute("listaDeNovedades",listaNovedades);
			
	return "alumnos";
	}


	@GetMapping("/requisitos")
	public static String requisitos() {
				
	return "requisitos";
	}		
	
	@GetMapping("/contacto")
	public static String contacto() {
				
	return "contacto";
	}
	
	@GetMapping("/admin")
	public static String admin() {
				
	return "admin";
	}			
	
	 @PostMapping("/adminedit")
	public static String procesarLogin(@RequestParam String user,@RequestParam String password, Model template) throws SQLException {				
		if (user.equals("") || password.equals("")) {			
			return "/admin";}
		else{						
			Connection connection;
	        connection = DriverManager.getConnection(Settings.db_url,Settings.db_user, Settings.db_password);   
	        PreparedStatement ps = connection.prepareStatement("SELECT password FROM usuarios WHERE usuario ='" +user+ "'");  
			ResultSet resultado =  ps.executeQuery();					
			while (resultado.next()) {
			    String p = resultado.getString("password");			    
			    System.out.println(p);			    
			    if (password.equals(p)) {return "adminedit";}
			    else {return "admin";}}									
			 return "admin";
		} 
	 } 
	
	@PostMapping("/addnoticia")
		public static String procesarAddNoticia(@RequestParam String titulo_noticia ,@RequestParam String subtitulo_noticia,
				@RequestParam String cuerpo_noticia, @RequestParam String fecha_noticia,Model template) throws SQLException {
	
	if (titulo_noticia.equals("") || subtitulo_noticia.equals("") || cuerpo_noticia.equals("") ||
			fecha_noticia.equals(""))
	{	
		return "adminedit";}
	else {
						
		Connection connection;
     connection = DriverManager.getConnection(Settings.db_url,Settings.db_user, Settings.db_password);
		PreparedStatement ps = connection.prepareStatement("INSERT INTO noticias (titulo,subtitulo,cuerpo,fecha) VALUES (?,?,?,?)");
		ps.setString(1, titulo_noticia);
		ps.setString(2, subtitulo_noticia);
		ps.setString(3, cuerpo_noticia);
		ps.setString(4, fecha_noticia);
						
		ps.executeUpdate();
		
		return "cargaexitosa"; } 

		}
		
	 @PostMapping("/addnovedad")
		public static String procesarAddNovedad(@RequestParam String titulo_novedad ,@RequestParam String subtitulo_novedad,
				@RequestParam String cuerpo_novedad, @RequestParam String fecha_novedad,Model template) throws SQLException {
	
	if (titulo_novedad.equals("") || subtitulo_novedad.equals("") || cuerpo_novedad.equals("") ||
			fecha_novedad.equals(""))
	{
	
		return "adminedit";}
	else {
						
		Connection connection;
		connection = DriverManager.getConnection(Settings.db_url,Settings.db_user, Settings.db_password);
		PreparedStatement ps = connection.prepareStatement("INSERT INTO novedades (titulo,subtitulo,cuerpo,fecha) VALUES (?,?,?,?)");
		ps.setString(1, titulo_novedad);
		ps.setString(2, subtitulo_novedad);
		ps.setString(3, cuerpo_novedad);
		ps.setString(4, fecha_novedad);
						
		ps.executeUpdate();
		
		return "adminedit"; }

		} 
	 
	 /*	@PostMapping("deleteNovedad")
	 	public static String procesardeleteNovedad(@RequestParam String titulo_novedad ,@RequestParam String subtitulo_novedad,
				@RequestParam String cuerpo_novedad, @RequestParam String fecha_novedad,Model template) throws SQLException {
	 	return "borrar";} */
}		
