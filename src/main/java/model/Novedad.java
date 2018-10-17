package model;

public class Novedad {
	String titulo_novedad;
	String subtitulo_novedad;
	String cuerpo_novedad;
	String fecha_novedad;
	
	
	public Novedad(String n,String d, String b,String o) {
		titulo_novedad = n;
		subtitulo_novedad = d;
		cuerpo_novedad = b;
		fecha_novedad = o;
	
	}

	public String getTitulo_novedad() {
		return titulo_novedad;
	}
	
	
	public void setTitulo_novedad(String titulo_novedad) {
		this.titulo_novedad = titulo_novedad;
	}
	
	
	
	public String getSubtitulo_novedad() {
		return subtitulo_novedad;
	}
	
	
	public void setSubtitulo_novedad(String subtitulo_novedad) {
		this.subtitulo_novedad = subtitulo_novedad;
	}
	
	
	
	public String getCuerpo_novedad() {
		return cuerpo_novedad;
	}
	
	
	public void setCuerpo_novedad(String cuerpo_novedad) {
		this.cuerpo_novedad = cuerpo_novedad;
	}
	
	
	
	public String getFecha_novedad() {
		return fecha_novedad;
	}
	
	
	public void setFecha_novedad(String fecha_novedad) {
		this.fecha_novedad = fecha_novedad;
	}
}





