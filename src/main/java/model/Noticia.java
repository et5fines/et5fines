package model;

public class Noticia {
	String titulo_noticia;
	String subtitulo_noticia;
	String cuerpo_noticia;
	String fecha_noticia;
	
	
	public Noticia(String n,String d, String b,String o) {
		titulo_noticia = n;
		subtitulo_noticia = d;
		cuerpo_noticia = b;
		fecha_noticia = o;
	
	}

	public String getTitulo_noticia() {
		return titulo_noticia;
	}
	
	
	public void setTitulo_noticia(String titulo_noticia) {
		this.titulo_noticia = titulo_noticia;
	}
	
	
	
	public String getSubtitulo_noticia() {
		return subtitulo_noticia;
	}
	
	
	public void setSubtitulo_noticia(String subtitulo_noticia) {
		this.subtitulo_noticia = subtitulo_noticia;
	}
	
	
	
	public String getCuerpo_noticia() {
		return cuerpo_noticia;
	}
	
	
	public void setCuerpo_noticia(String cuerpo_noticia) {
		this.cuerpo_noticia = cuerpo_noticia;
	}
	
	
	
	public String getFecha_noticia() {
		return fecha_noticia;
	}
	
	
	public void setFecha_noticia(String fecha_noticia) {
		this.fecha_noticia = fecha_noticia;
	}
}





